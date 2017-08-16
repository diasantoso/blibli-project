package com.gdn.service;

import com.gdn.repository.booking.BookingRepository;
import com.gdn.repository.employee.EmployeeRepository;
import com.gdn.repository.office.OfficeRepository;
import com.gdn.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dias on 5/26/2017.
 */
@Service
public class CountService {

    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BookingRepository bookingRepository;

    public Long countOffice() {
        return officeRepository.count();
    }

    public Long countRoom() {
        return roomRepository.count();
    }

    public Long countEmployee() {
        return employeeRepository.count();
    }

    public Long countBooking() {
        return bookingRepository.count();
    }
}
