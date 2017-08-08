package com.blibli.repository;

import com.blibli.Configuration;
import com.blibli.model.Employee;
import com.blibli.repository.employee.EmployeeRepository;
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
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeRepository.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void showActiveEmployeeTest() {
        Employee employee = this.employeeRepository.save(new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee"));

        List<Employee> listEmployee = this.employeeRepository.showActiveEmployee();
        LOG.debug("listEmployee:{}", listEmployee);

        Assert.assertThat(listEmployee.isEmpty(), Matchers.equalTo(false));
        Assert.assertThat(listEmployee.get(0), Matchers.equalTo(employee));
    }

    @Test
    public void showOneEmployeeTest() {
        Employee employee = this.employeeRepository.save(new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee"));

        Employee cekEmployee = this.employeeRepository.showOneEmployee("12345");
        LOG.debug("cekEmployee:", cekEmployee);

        Assert.assertThat(cekEmployee, Matchers.equalTo(employee));
    }

    @Test
    public void deleteEmployeeTest() {
        Employee employee = this.employeeRepository.save(new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee"));

        Employee deleteEmployee = this.employeeRepository.deleteEmployee("12345");
        LOG.debug("deleteEmployee:", deleteEmployee);

        Assert.assertThat(deleteEmployee, Matchers.equalTo(employee));
    }

    @Test
    public void findOneByEmailTest() {
        Employee employee = this.employeeRepository.save(new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Employee"));

        Employee cekEmployee = this.employeeRepository.findOneByEmail("emp@mail.com");
        LOG.debug("cekEmployee:", cekEmployee);

        Assert.assertThat(cekEmployee, Matchers.equalTo(employee));
    }

    @Test
    public void getAllAdminTest() {
        Employee employee = this.employeeRepository.save(new Employee("12345", "Test Employee", "emp@mail.com", "emp", "Admin"));

        List<Employee> listAdmin = this.employeeRepository.getAllAdmin();
        LOG.debug("listAdmin:{}", listAdmin);

        Assert.assertThat(listAdmin.isEmpty(), Matchers.equalTo(false));
        Assert.assertThat(listAdmin.get(0), Matchers.equalTo(employee));
    }
}
