package com.blibli.configuration;

import com.blibli.model.Booking;
import com.blibli.model.Employee;
import com.blibli.model.Office;
import com.blibli.model.Room;
import com.blibli.repository.booking.BookingRepository;
import com.blibli.repository.employee.EmployeeRepository;
import com.blibli.repository.office.OfficeRepository;
import com.blibli.repository.room.RoomRepository;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 5/16/2017.
 */
@Service
public class DatabaseSeeder {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;

    public void mockupData() {
        //EMPLOYEE DATA
        Employee employee1 = new Employee();
        employee1.setName("Dias");
        employee1.setEmail("dias@gmail.com");
        employee1.setPassword("dias");
        employee1.setRole("Admin");
        employee1.setStatus(1);

        Employee employee2 = new Employee();
        employee2.setName("Audine");
        employee2.setEmail("audine@gmail.com");
        employee2.setPassword("audine");
        employee2.setRole("Employee");
        employee2.setStatus(1);

        //OFFICE DATA
        Office office1 = new Office();
        office1.setName("KS. Tubun");
        office1.setAddress("Jalan Tubun Raya no 100");
        office1.setCity("Jakarta");
        office1.setTelephone("778899");
        office1.setStatus(1);

        Office office2 = new Office();
        office2.setName("KS. Thamrin");
        office2.setAddress("Jalan Thamrin no 99");
        office2.setCity("Jakarta");
        office2.setTelephone("123456");
        office2.setStatus(1);

        //ROOM DATA
        Room room1 = new Room();
        room1.setName("Room A:202");
        room1.setCapacity(5);
        room1.setNumberExtension("777888");
        room1.setIsConference("Yes");
        room1.setIsProjector("Yes");
        room1.setStatus(1);

        Room room2 = new Room();
        room2.setName("Room B:100");
        room2.setCapacity(10);
        room2.setNumberExtension("111222");
        room2.setIsConference("Yes");
        room2.setIsProjector("No");
        room2.setStatus(1);

        Room room3 = new Room();
        room3.setName("Room B:200");
        room3.setCapacity(3);
        room3.setNumberExtension("333444");
        room3.setIsConference("No");
        room3.setIsProjector("No");
        room3.setStatus(1);

        room1.setOffice(office1);
        room2.setOffice(office2);
        room3.setOffice(office2);

        //BOOKING DATA
        Booking booking1 = new Booking();
        booking1.setSubject("Meeting Front-End Developer");
        booking1.setDescription("Meeting to complete sprint 1");
        booking1.setDateMeeting(Date.valueOf("2017-12-20"));
        booking1.setStartTime(java.sql.Time.valueOf("09:00:00"));
        booking1.setEndTime(java.sql.Time.valueOf("11:00:00"));
        booking1.setAddedDate(Date.valueOf("2017-12-20"));
        booking1.setStatusBooking("Not yet");
        booking1.setStatus(1);
        booking1.setEmployee(employee2);
        booking1.setRoom(room1);

        Employee emp1 = employeeRepository.save(employee1);
        Employee emp2 = employeeRepository.save(employee2);
        Office ofc1 = officeRepository.save(office1);
        Office ofc2 = officeRepository.save(office2);
        Room rm1 = roomRepository.save(room1);
        Room rm2 = roomRepository.save(room2);
        Room rm3 = roomRepository.save(room3);
        Booking bk1 = bookingRepository.save(booking1);
    }
}
