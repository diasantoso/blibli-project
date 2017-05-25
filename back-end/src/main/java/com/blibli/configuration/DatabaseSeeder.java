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

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dias on 5/16/2017.
 */

//@Component
public class DatabaseSeeder {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;

    @PostConstruct
    private void mockupData() {
        //EMPLOYEE DATA
        Employee employee1 = new Employee();
        employee1.setName("Dias");
        employee1.setPassword("dias");
        employee1.setRole("Admin");

        Employee employee2 = new Employee();
        employee2.setName("Audine");
        employee2.setPassword("audine");
        employee2.setRole("Employee");

        //OFFICE DATA
        Office office1 = new Office();
        office1.setIdOffice("11111");
        office1.setName("KS. Tubun");
        office1.setAddress("Jalan Tubun Raya no 100");
        office1.setCity("Jakarta");
        office1.setTelephone("778899");
        office1.setStatus(1);

        Office office2 = new Office();
        office2.setIdOffice("222222");
        office2.setName("KS. Thamrin");
        office2.setAddress("Jalan Thamrin no 99");
        office2.setCity("Jakarta");
        office2.setTelephone("123456");
        office2.setStatus(1);

        //ROOM DATA
        Room room1 = new Room();
        room1.setIdRoom("333");
        room1.setName("Room A:202");
        room1.setCapacity(5);
        room1.setNumberExtension("777888");
        room1.setIsConference("Yes");
        room1.setIsProjector("Yes");
        room1.setStatus(1);

        Room room2 = new Room();
        room2.setIdRoom("444");
        room2.setName("Room B:100");
        room2.setCapacity(10);
        room2.setNumberExtension("111222");
        room2.setIsConference("Yes");
        room2.setIsProjector("No");
        room2.setStatus(1);

        List<Room> listA = new ArrayList<>();
        listA.add(room1);

        List<Room> listB = new ArrayList<>();
        listA.add(room2);

        office1.setRooms(listA);
        office2.setRooms(listB);

        room1.setOffice(office1);
        room2.setOffice(office2);

        //BOOKING DATA
        Booking booking1 = new Booking();
        booking1.setIdBooking("101");
        booking1.setSubject("Meeting Front-End Developer");
        booking1.setDescription("Meeting to complete sprint 1");
        booking1.setDateMeeting(Date.valueOf("2017/12/20"));
        booking1.setStartTime(java.sql.Time.valueOf("09:00:00"));
        booking1.setEndTime(java.sql.Time.valueOf("11:00:00"));
        booking1.setAddedDate(Date.valueOf("2017/12/20"));
        booking1.setStatusBooking("Not yet");
        booking1.setStatus(1);
        booking1.setRoom(room1);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        officeRepository.save(office1);
        officeRepository.save(office2);
        roomRepository.save(room1);
        roomRepository.save(room2);
        bookingRepository.save(booking1);
    }
}
