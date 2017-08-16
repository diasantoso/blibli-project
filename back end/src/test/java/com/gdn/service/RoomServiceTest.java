package com.gdn.service;

import com.gdn.model.Room;
import com.gdn.repository.room.RoomRepository;
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
 * Created by Dias on 8/8/2017.
 */
public class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomRepository roomRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeServiceTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.roomRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void getAllActiveTest() {
        List<Room> listRoom = new ArrayList<Room>();
        listRoom.add(new Room("1111", "Test Room 1"));
        listRoom.add(new Room("2222", "Test Room 2"));
        BDDMockito.given(this.roomRepository.showActiveRoom()).willReturn(listRoom);

        List<Room> result = roomService.getAllActive();

        Assert.assertEquals(listRoom, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .showActiveRoom();
    }

    @Test
    public void getAllTest() {
        List<Room> listRoom = new ArrayList<Room>();
        listRoom.add(new Room("1111", "Test Room 1"));
        listRoom.add(new Room("2222", "Test Room 2"));
        BDDMockito.given(this.roomRepository.findAll()).willReturn(listRoom);

        List<Room> result = roomService.getAll();

        Assert.assertEquals(listRoom, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .findAll();
    }

    @Test
    public void saveTest() {
        Room room = new Room("1111", "Test Room 1");
        BDDMockito.given(this.roomRepository.save(room)).willReturn(room);

        Room result = roomService.save(room);

        Assert.assertEquals(room, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .save(room);
    }

    @Test
    public void getOneActiveTest() {
        Room dataRoom = new Room("1111", "Test Room 1");
        BDDMockito.given(this.roomRepository.showOneRoom("1111")).willReturn(dataRoom);

        Room result = roomService.getOneActive("1111");

        Assert.assertEquals(dataRoom, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .showOneRoom("1111");
    }

    @Test
    public void deleteTest() {
        Room room = new Room("1111", "Test Room 1");
        BDDMockito.given(this.roomRepository.deleteRoom("1111")).willReturn(room);

        Room result = roomService.delete("1111");

        Assert.assertEquals(room, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .deleteRoom("1111");
    }
}
