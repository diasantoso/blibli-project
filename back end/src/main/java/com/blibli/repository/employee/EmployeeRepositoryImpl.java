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

    @Override
    public Employee deleteEmployee(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Employee result = em.find(Employee.class, id);

        if(result.getStatus()==1)
            result.setStatus(0);
        else if(result.getStatus()==0)
            result.setStatus(1);

        em.getTransaction().commit();

        return result;
    }

    @Override
    public List<Employee> showActiveEmployee() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Employee> result = em.createNativeQuery(
                "SELECT * FROM EMPLOYEE WHERE STATUS=1", Employee.class).getResultList();
        return result;
    }

    @Override
    public Employee showOneEmployee(String id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Employee result = (Employee) em.createNativeQuery(
                "SELECT * FROM EMPLOYEE WHERE STATUS=1 AND id_employee = '" + id +"' ", Employee.class).getSingleResult();
        return result;
    }

    @Override
    public Employee findOneByEmail(String email) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Employee result = null;

        try {
            result = (Employee) em.createNativeQuery(
                    "SELECT * FROM employee WHERE email='" + email + "';", Employee.class).getSingleResult();
        }
        catch(Exception ex){}

        return result;
    }

    @Override
    public List<Employee> getAllAdmin() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Employee> result = em.createNativeQuery(
                "SELECT * FROM EMPLOYEE WHERE STATUS=1 AND ROLE='Admin'", Employee.class).getResultList();
        return result;
    }
}
