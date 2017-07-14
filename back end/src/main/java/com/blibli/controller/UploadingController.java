package com.blibli.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.blibli.response.ResponseBack;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.springframework.hateoas.Link;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ADIN on 5/9/2017.
 */
@Controller
public class UploadingController {
//    public static final String uploadingdir = System.getProperty("user.dir") + "/src/main/resources/static/images/";
//
//    @RequestMapping("/upload")
//    public String uploading (Model model){
//        File file = new File(uploadingdir);
//        model.addAttribute("files",file.listFiles());
//        return "uploading";
//    }
//
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
//
//            for(MultipartFile uploadedFile : uploadingFiles) {
//                File file = new File(uploadingdir + uploadedFile.getOriginalFilename());
//                uploadedFile.transferTo(file);
//            }
//
//        return "redirect:/upload";
//
//    }

    private static final Logger log = LoggerFactory.getLogger(UploadingController.class);

    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    @Autowired
    public UploadingController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(Model model) throws IOException {
        return "index";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(method = RequestMethod.GET, value = "/api/files")
    public ResponseEntity<List<Link>> list(Model model) throws IOException {

        List<Link> files = Files.walk(Paths.get(ROOT))
                .filter(path -> !path.equals(Paths.get(ROOT)))
                .map(path -> Paths.get(ROOT).relativize(path))
                .map(path -> linkTo(methodOn(UploadingController.class).getFile(path.toString())).withRel(path.toString()))
                .collect(Collectors.toList());

        return new ResponseEntity<List<Link>>(files, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(method = RequestMethod.POST, value = "/api/upload")
    @ResponseBody
    public ResponseBack handleFileUpload(@RequestParam("file") MultipartFile file) {
        ResponseBack responseBack = new ResponseBack();
        String filename = "default.jpg";
        if (!file.isEmpty()) {
            try {
                filename = "room-"+ RandomStringUtils.randomAlphanumeric(5)+"-"+file.getOriginalFilename();
                Files.copy(file.getInputStream(), Paths.get(ROOT,file.getOriginalFilename()));
            } catch (IOException|RuntimeException e) {

            }
        }

        responseBack.setResponse(filename);
        return responseBack;
    }
}
