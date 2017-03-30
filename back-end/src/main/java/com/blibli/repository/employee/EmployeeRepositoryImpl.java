package com.blibli.repository.employee;

import com.blibli.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Dias on 3/30/2017.
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public Employee findLogin(String email, String password) {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Employee> result = em.createNativeQuery(
                "SELECT * FROM EMPLOYEE WHERE EMAIL='"+email+"' AND PASSWORD='"+password+"'", Employee.class).getResultList();

        return result.get(0);
    }
}
