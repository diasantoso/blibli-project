package com.blibli.repository;

import com.blibli.Configuration;
import com.blibli.model.Booking;
import com.blibli.repository.booking.BookingRepository;
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
public class BookingRepositoryTest {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private static final Logger LOG = LoggerFactory.getLogger(BookingRepository.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void showById() {
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking"));

        List<Booking> cekBooking = this.bookingRepository.showById("12345");
        LOG.debug("cekBooking:", cekBooking);

        Assert.assertThat(cekBooking.get(0), Matchers.equalTo(booking));
    }

    @Test
    public void deleteOffice() {
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking"));

        Booking deleteBooking = this.bookingRepository.deleteBooking("12345");
        LOG.debug("deleteBooking:", deleteBooking);

        Assert.assertThat(deleteBooking, Matchers.equalTo(booking));
    }
}
