package com.blibli.service;

import com.blibli.repository.booking.BookingRepository;
import com.blibli.repository.employee.EmployeeRepository;
import com.blibli.repository.office.OfficeRepository;
import com.blibli.repository.room.RoomRepository;
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
