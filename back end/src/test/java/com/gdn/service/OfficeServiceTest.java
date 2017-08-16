package com.gdn.service;

import com.gdn.model.Office;
import com.gdn.repository.office.OfficeRepository;
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
public class OfficeServiceTest {

    @InjectMocks
    private OfficeService officeService;

    @Mock
    private OfficeRepository officeRepository;

    private static final Logger LOG = LoggerFactory.getLogger(OfficeServiceTest.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
        BDDMockito.then(this.officeRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    public void getAllActiveTest() {
        List<Office> listOffice = new ArrayList<Office>();
        listOffice.add(new Office("1111", "Test Office 1"));
        listOffice.add(new Office("2222", "Test Office 2"));
        BDDMockito.given(this.officeRepository.showActiveOffice()).willReturn(listOffice);

        List<Office> result = officeService.getAllActive();

        Assert.assertEquals(listOffice, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .showActiveOffice();
    }

    @Test
    public void getAllTest() {
        List<Office> listOffice = new ArrayList<Office>();
        listOffice.add(new Office("1111", "Test Office 1"));
        listOffice.add(new Office("2222", "Test Office 2"));
        BDDMockito.given(this.officeRepository.findAll()).willReturn(listOffice);

        List<Office> result = officeService.getAll();

        Assert.assertEquals(listOffice, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .findAll();
    }

    @Test
    public void saveTest() {
        Office office = new Office("1111", "Test Office 1");
        BDDMockito.given(this.officeRepository.save(office)).willReturn(office);

        Office result = officeService.save(office);

        Assert.assertEquals(office, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .save(office);
    }

    @Test
    public void getOneActiveTest() {
        Office dataOffice = new Office("1111", "Test Office 1");
        BDDMockito.given(this.officeRepository.showOneOffice("1111")).willReturn(dataOffice);

        Office result = officeService.getOneActive("1111");

        Assert.assertEquals(dataOffice, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .showOneOffice("1111");
    }

    @Test
    public void deleteTest() {
        Office office = new Office("1111", "Test Office 1");
        BDDMockito.given(this.officeRepository.deleteOffice("1111")).willReturn(office);

        Office result = officeService.delete("1111");

        Assert.assertEquals(office, result);
        Mockito.verify(this.officeRepository, Mockito.times(1))
                .deleteOffice("1111");
    }
}
