package com.blibli.service;

import com.blibli.model.Employee;
import com.blibli.repository.employee.EmployeeRepository;
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
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeServiceTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.employeeRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void doLoginTest() {
        Employee emp = new Employee("1111", "Test Employee 1", "emp@mail.com", "emp", "Employee");
        BDDMockito.given(this.employeeRepository.findLogin("emp@mail.com", "emp")).willReturn(emp);

        Employee result = employeeService.doLogin("emp@mail.com", "emp");

        Assert.assertEquals(emp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .findLogin("emp@mail.com", "emp");
    }

    @Test
    public void getAllActiveTest() {
        List<Employee> listEmp = new ArrayList<Employee>();
        listEmp.add(new Employee("1111", "Test Office 1", "emp1@mail.com", "emp1", "Employee"));
        listEmp.add(new Employee("2222", "Test Office 2", "emp2@mail.com", "emp2", "Employee"));
        BDDMockito.given(this.employeeRepository.showActiveEmployee()).willReturn(listEmp);

        List<Employee> result = employeeService.getAllActive();

        Assert.assertEquals(listEmp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .showActiveEmployee();
    }

    @Test
    public void getAllTest() {
        List<Employee> listEmp = new ArrayList<Employee>();
        listEmp.add(new Employee("1111", "Test Office 1", "emp1@mail.com", "emp1", "Employee"));
        listEmp.add(new Employee("2222", "Test Office 2", "emp2@mail.com", "emp2", "Employee"));
        BDDMockito.given(this.employeeRepository.findAll()).willReturn(listEmp);

        List<Employee> result = employeeService.getAll();

        Assert.assertEquals(listEmp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .findAll();
    }

    @Test
    public void getOneActiveTest() {
        Employee dataEmp = new Employee("1111", "Test Office 1", "emp@mail.com", "emp", "Employee");
        BDDMockito.given(this.employeeRepository.showOneEmployee("1111")).willReturn(dataEmp);

        Employee result = employeeService.getOneActive("1111");

        Assert.assertEquals(dataEmp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .showOneEmployee("1111");
    }

    @Test
    public void saveTest() {
        Employee emp = new Employee("1111", "Test Office 1", "emp@mail.com", "emp", "Employee");
        BDDMockito.given(this.employeeRepository.save(emp)).willReturn(emp);

        Employee result = employeeService.save(emp);

        Assert.assertEquals(emp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .save(emp);
    }

    @Test
    public void deleteTest() {
        Employee emp = new Employee("1111", "Test Office 1", "emp@mail.com", "emp", "Employee");
        BDDMockito.given(this.employeeRepository.deleteEmployee("1111")).willReturn(emp);

        Employee result = employeeService.delete("1111");

        Assert.assertEquals(emp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .deleteEmployee("1111");
    }

    @Test
    public void findOneByEmailTest() {
        Employee dataEmp = new Employee("1111", "Test Office 1", "emp@mail.com", "emp", "Employee");
        BDDMockito.given(this.employeeRepository.findOneByEmail("emp@mail.com")).willReturn(dataEmp);

        Employee result = employeeService.findOneByEmail("emp@mail.com");

        Assert.assertEquals(dataEmp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .findOneByEmail("emp@mail.com");
    }

    @Test
    public void getAllAdminTest() {
        List<Employee> listEmp = new ArrayList<Employee>();
        listEmp.add(new Employee("1111", "Test Office 1", "emp1@mail.com", "emp1", "Admin"));
        listEmp.add(new Employee("2222", "Test Office 2", "emp2@mail.com", "emp2", "Admin"));
        BDDMockito.given(this.employeeRepository.getAllAdmin()).willReturn(listEmp);

        List<Employee> result = employeeService.getAllAdmin();

        Assert.assertEquals(listEmp, result);
        Mockito.verify(this.employeeRepository, Mockito.times(1))
                .getAllAdmin();
    }
}
