package com.blibli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;

/**
 * Created by Dias on 8/1/2017.
 */
@Controller
public class EmailSendController {

    //ini prototype.. nanti jika udah selesai bakal disesuain lagi

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/email")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }

    private void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("mikhaelmds@gmail.com");
        helper.setSubject("Booking Meeting Information");
        helper.setText("Attention,\n" +
                "You have successfully booked a meeting room");

        sender.send(message);
    }
}
