package com.blibli.repository;

import com.blibli.Configuration;
import com.blibli.model.Room;
import com.blibli.repository.room.RoomRepository;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Dias on 6/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Configuration.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional(readOnly = false)
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private static final Logger LOG = LoggerFactory.getLogger(RoomRepository.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void showActiveRoom() {
        Room room = this.roomRepository.save(new Room("12345", "Test Room"));

        List<Room> listRoom = this.roomRepository.showActiveRoom();
        LOG.debug("listRoom:{}", listRoom);

        Assert.assertThat(listRoom.isEmpty(), Matchers.equalTo(false));
        Assert.assertThat(listRoom.get(0), Matchers.equalTo(room));
    }

    @Test
    public void showOneRoom() {
        Room room = this.roomRepository.save(new Room("12345", "Test Room"));

        Room cekRoom = this.roomRepository.showOneRoom("12345");
        LOG.debug("cekRoom:", cekRoom);

        Assert.assertThat(cekRoom, Matchers.equalTo(room));
    }

    @Test
    public void deleteRoom() {
        Room room = this.roomRepository.save(new Room("12345", "Test Room"));

        Room deleteRoom = this.roomRepository.deleteRoom("12345");
        LOG.debug("deleteRoom:", deleteRoom);

        Assert.assertThat(deleteRoom, Matchers.equalTo(room));
    }
}
