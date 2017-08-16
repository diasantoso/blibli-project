package com.gdn.service;

import com.gdn.model.*;
import com.gdn.repository.booking.BookingRepository;
import com.gdn.repository.employee.EmployeeRepository;
import com.gdn.repository.office.OfficeRepository;
import com.gdn.repository.room.RoomRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

/**
 * Created by Dias on 8/9/2017.
 */
public class CountServiceTest {

    @InjectMocks
    private CountService countService;

    @Mock
    OfficeRepository officeRepository;
    @Mock
    RoomRepository roomRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    BookingRepository bookingRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.bookingRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void countOfficeTest() {
        Office office = new Office("11111", "Test Office 1");

        Long data = 12345678910L;

        BDDMockito.given(this.officeRepository.count()).willReturn(data);

        Long result = countService.countOffice();

        Assert.assertEquals(data, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .count();
    }

    @Test
    public void countRoomTest() {
        Room room = new Room("11111", "Test Room 1");

        Long data = 12345678910L;

        BDDMockito.given(this.roomRepository.count()).willReturn(data);

        Long result = countService.countRoom();

        Assert.assertEquals(data, result);
        Mockito.verify(this.roomRepository, Mockito.times(1))
                .count();
    }

    @Test
    public void countEmployeeTest() {
        Employee emp = new Employee("11111", "emp", "emp@mail.com", "emp", "Admin");

        Long data = 12345678910L;

        BDDMockito.given(this.employeeRepository.count()).willReturn(data);

        Long result = countService.countEmployee();

        Assert.assertEquals(data, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .count();
    }

    @Test
    public void countBookingTest() {
        Employee emp = new Employee("11111", "emp", "emp@mail.com", "emp", "Admin");
        Booking booking = new Booking("11111", "Book 1", "book-1", emp);

        Long data = 12345678910L;

        BDDMockito.given(this.bookingRepository.count()).willReturn(data);

        Long result = countService.countBooking();

        Assert.assertEquals(data, result);
        Mockito.verify(this.bookingRepository, Mockito.times(1))
                .count();
    }
}
