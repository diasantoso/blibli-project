package com.gdn.service;

import com.gdn.model.Booking;
import com.gdn.model.Employee;
import com.gdn.repository.booking.BookingRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 8/8/2017.
 */
public class BookingServiceTest {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeServiceTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.bookingRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void getAllBookingTest() {
        List<Booking> listBooking = new ArrayList<Booking>();
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        listBooking.add(new Booking("11111", "Test Booking 1", "book-1", emp));
        listBooking.add(new Booking("22222", "Test Booking 2", "book-2", emp));
        BDDMockito.given(this.bookingRepository.showAll()).willReturn(listBooking);

        List<Booking> result = bookingService.getAllBooking();

        Assert.assertEquals(listBooking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .showAll();
    }

    @Test
    public void getByIdTest() {
        List<Booking> listBooking = new ArrayList<Booking>();
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        listBooking.add(new Booking("11111", "Test Booking 1", "book-1", emp));
        BDDMockito.given(this.bookingRepository.showById("11111")).willReturn(listBooking);

        List<Booking> result = bookingService.getById("11111");

        Assert.assertEquals(listBooking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .showById("11111");
    }

    @Test
    public void saveTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = new Booking("11111", "Test Booking 1", "book-1", emp);
        BDDMockito.given(this.bookingRepository.save(booking)).willReturn(booking);

        Booking result = bookingService.save(booking);

        Assert.assertEquals(booking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .save(booking);
    }

    @Test
    public void deleteTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = new Booking("11111", "Test Booking 1", "book-1", emp);
        BDDMockito.given(this.bookingRepository.deleteBooking("11111")).willReturn(booking);

        Booking result = bookingService.delete("11111");

        Assert.assertEquals(booking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .deleteBooking("11111");
    }

    @Test
    public void findTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = new Booking("11111", "Test Booking 1", "book-1", emp);
        BDDMockito.given(this.bookingRepository.findOne("11111")).willReturn(booking);

        Booking result = bookingService.find("11111");

        Assert.assertEquals(booking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .findOne("11111");
    }

    @Test
    public void getByEmpIdTest() {
        List<Booking> listBooking = new ArrayList<Booking>();
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        listBooking.add(new Booking("11111", "Test Booking 1", "book-1", emp));
        listBooking.add(new Booking("22222", "Test Booking 2", "book-2", emp));
        BDDMockito.given(this.bookingRepository.showByEmployeeId("12345")).willReturn(listBooking);

        List<Booking> result = bookingService.getByEmpId("12345");

        Assert.assertEquals(listBooking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .showByEmployeeId("12345");
    }

    @Test
    public void count() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = new Booking("11111", "Test Booking 1", "book-1", emp);
        BDDMockito.given(this.bookingRepository.countBooking()).willReturn(BigInteger.ONE);

        BigInteger result = bookingService.count();

        Assert.assertEquals(BigInteger.ONE, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .countBooking();
    }

    @Test
    public void getBookingByTicketTest() {
        Employee emp = new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee");
        Booking booking = new Booking("11111", "Test Booking 1", "book-1", emp);
        BDDMockito.given(this.bookingRepository.getBookingByTicket("book-1")).willReturn(booking);

        Booking result = bookingService.getBookingByTicket("book-1");

        Assert.assertEquals(booking, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .getBookingByTicket("book-1");
    }
}
