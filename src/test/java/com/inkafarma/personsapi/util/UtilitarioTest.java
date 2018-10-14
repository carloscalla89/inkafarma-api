package com.inkafarma.personsapi.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UtilitarioTest {

    @Mock
    private Properties properties;

    @InjectMocks
    private Utilitario utilitario;

    @Test
    public void getDeathDateEstimate2() {
        Map<String, String> list = new HashMap();
        list.put("range_0_10","3.23");
        list.put("range_11_20","0.65");
        list.put("range_21_30","1.21");
        list.put("range_31_40","1.84");
        list.put("range_41_50","4.31");
        list.put("range_51_60","9.69");
        list.put("range_61_70","18.21");
        list.put("range_71_80","27.28");
        list.put("range_81_more","33.58");


        Map<String, String> listHope = new HashMap();
        listHope.put("range_0_10","80");
        listHope.put("range_11_20","80");
        listHope.put("range_21_30","80");
        listHope.put("range_31_40","80");
        listHope.put("range_41_50","80");
        listHope.put("range_51_60","80");
        listHope.put("range_61_70","84");
        listHope.put("range_71_80","88");
        listHope.put("range_81_more","95");

        when(properties.getRange()).thenReturn(Arrays.asList("0_10","11_20","21_30","31_40","41_50","61_70","71_80"));
        when(properties.getDeathProbability()).thenReturn(list);
        when(properties.getAverageLifeHope()).thenReturn(listHope);

        utilitario = new Utilitario(properties);
        utilitario.getDeathDateEstimate("1922-05-21");

    }
}