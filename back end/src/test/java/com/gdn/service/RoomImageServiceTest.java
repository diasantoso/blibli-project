package com.gdn.service;

import com.gdn.model.Room;
import com.gdn.model.RoomImage;
import com.gdn.repository.roomImage.RoomImageRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 8/10/2017.
 */
public class RoomImageServiceTest {

    @InjectMocks
    private RoomImageService roomImageService;

    @Mock
    private RoomImageRepository roomImageRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeServiceTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.roomImageRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void getAllRoomImagesTest() {
        List<RoomImage> listRoomImage = new ArrayList<RoomImage>();
        listRoomImage.add(new RoomImage());
        listRoomImage.add(new RoomImage());
        BDDMockito.given(this.roomImageRepository.showAllRoomImages()).willReturn(listRoomImage);

        List<RoomImage> result = roomImageService.getAllRoomImages();

        Assert.assertEquals(listRoomImage, result);
        Mockito.verify(this.roomImageRepository, Mockito.times(1))
                .showAllRoomImages();
    }

    @Test
    public void getAllImagesForOneRoomTest() {
        RoomImage data = new RoomImage();
        data.setRoom(new Room("11111", "Test Room 1"));
        List<RoomImage> listRoomImage = new ArrayList<RoomImage>();
        listRoomImage.add(data);
        BDDMockito.given(this.roomImageRepository.showImagesForOneRoom("11111")).willReturn(listRoomImage);

        List<RoomImage> result = roomImageService.getAllImagesForOneRoom("11111");

        Assert.assertEquals(listRoomImage, result);
        Mockito.verify(this.roomImageRepository, Mockito.times(1))
                .showImagesForOneRoom("11111");
    }

    @Test
    public void createTest() {
        RoomImage roomImage = new RoomImage();
        roomImage.setIdRoomImage("1");
        BDDMockito.given(this.roomImageRepository.save(roomImage)).willReturn(roomImage);

        RoomImage result = roomImageService.create(roomImage);

        Assert.assertEquals(roomImage, result);
        Mockito.verify(this.roomImageRepository, Mockito.times(1))
                .save(roomImage);
    }
}
