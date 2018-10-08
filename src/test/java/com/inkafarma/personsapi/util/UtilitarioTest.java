package com.inkafarma.personsapi.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class UtilitarioTest {


    @Test
    public void getDeathDateEstimate() {
        log.info("fecha:"+Utilitario.getDeathDateEstimate("2019-03-16"));

    }
}