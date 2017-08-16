package com.gdn.repository;

import com.gdn.Configuration;
import com.gdn.model.Booking;
import com.gdn.model.Employee;
import com.gdn.repository.booking.BookingRepository;
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
import java.math.BigInteger;
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
    public void showAllTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        List<Booking> cekBooking = this.bookingRepository.showAll();
        LOG.debug("cekBooking:", cekBooking);

        Assert.assertThat(cekBooking.get(0), Matchers.equalTo(booking));
    }

    @Test
    public void showByIdTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        List<Booking> cekBooking = this.bookingRepository.showById("12345");
        LOG.debug("cekBooking:", cekBooking);

        Assert.assertThat(cekBooking.get(0), Matchers.equalTo(booking));
    }

    @Test
    public void deleteBookingTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        Booking deleteBooking = this.bookingRepository.deleteBooking("12345");
        LOG.debug("deleteBooking:", deleteBooking);

        Assert.assertThat(deleteBooking, Matchers.equalTo(booking));
    }

    @Test
    public void showByEmployeeIdTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        List<Booking> cekBooking = this.bookingRepository.showByEmployeeId("12345");
        LOG.debug("cekBooking:", cekBooking);

        Assert.assertThat(cekBooking.get(0), Matchers.equalTo(booking));
    }

    @Test
    public void countBookingTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        BigInteger countBooking = this.bookingRepository.countBooking();

        Assert.assertThat(countBooking, Matchers.equalTo(1));
    }

    @Test
    public void getBookingByTicketTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = this.bookingRepository.save(new Booking("12345", "Test Booking", "book-1", emp));

        Booking getBookingByTicket = this.bookingRepository.getBookingByTicket("book-1");
        LOG.debug("getBookingByTicket:", getBookingByTicket);

        Assert.assertThat(getBookingByTicket, Matchers.equalTo(booking));
    }
}
