package com.blibli.repository;

import com.blibli.Configuration;
import com.blibli.model.Office;
import com.blibli.repository.office.OfficeRepository;
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
public class OfficeRepositoryTest {
    @Autowired
    OfficeRepository officeRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeRepository.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void showActiveOffice() {
        Office office = this.officeRepository.save(new Office("12345", "Test Office"));

        List<Office> listOffice = this.officeRepository.showActiveOffice();
        LOG.debug("listOffice:{}", listOffice);

        Assert.assertThat(listOffice.isEmpty(), Matchers.equalTo(false));
        Assert.assertThat(listOffice.get(0), Matchers.equalTo(office));
    }

    @Test
    public void showOneOffice() {
        Office office = this.officeRepository.save(new Office("12345", "Test Office"));

        Office cekOffice = this.officeRepository.showOneOffice("12345");
        LOG.debug("cekOffice:", cekOffice);

        Assert.assertThat(cekOffice, Matchers.equalTo(office));
    }

    @Test
    public void deleteOffice() {
        Office office = this.officeRepository.save(new Office("12345", "Test Office"));

        Office deleteOffice = this.officeRepository.deleteOffice("12345");
        LOG.debug("deleteOffice:", deleteOffice);

        Assert.assertThat(deleteOffice, Matchers.equalTo(office));
    }
}
