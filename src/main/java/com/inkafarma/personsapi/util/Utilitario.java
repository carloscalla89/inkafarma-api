package com.inkafarma.personsapi.util;

import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import com.google.appengine.repackaged.org.joda.time.Years;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

@Slf4j
@Component
public class Utilitario {

    private Properties properties;

    @Autowired
    public Utilitario(Properties properties){
        this.properties = properties;
    }

    public String getDeathDateEstimateRandom(String fechaNacimiento){
        String datos[] = fechaNacimiento.split("-");

        Calendar unaFecha;
        Random aleatorio;
        aleatorio = new Random();


        unaFecha = Calendar.getInstance();
        unaFecha.set (aleatorio.nextInt(50)+Integer.parseInt(datos[0]), aleatorio.nextInt(Integer.parseInt(datos[1]))+1, aleatorio.nextInt(Integer.parseInt(datos[2]))+1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(unaFecha.getTime());
    }

    public String getDeathDateEstimate(String fechaNacimiento){

        String datos[] = fechaNacimiento.split("-");

        LocalDate birthDate = LocalDate.of(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),Integer.parseInt(datos[2]));
        LocalDate localDate = LocalDate.now();
        Period period = Period.between(birthDate,localDate);

        log.info("fecha de nacimiento:"+fechaNacimiento);
        log.info("edad actual:"+period.getYears());

        String rango = properties.getRange().stream().filter(r -> {

            String val[] = r.split("_");

            return Integer.parseInt(val[0]) <= period.getYears() && Integer.parseInt(val[1]) >= period.getYears();
        }).findFirst().orElse("81_more");

        float probabilidad = Float.parseFloat(properties.getDeathProbability().get("range_"+rango));
        int expectativaVida = Integer.parseInt(properties.getAverageLifeHope().get("range_"+rango));

        int diferencia = expectativaVida - period.getYears();

        int edadMuerte;

        if (diferencia > 0) {

            edadMuerte= (int)(diferencia*(100.0-probabilidad)/100) + period.getYears();
        } else {
            diferencia = diferencia*-1;
            edadMuerte = (int)(diferencia*(100.0-probabilidad*(diferencia/4+1))/100) +  period.getYears()+1;
        }

        LocalDate deathDate = LocalDate.of(Integer.parseInt(datos[0])+edadMuerte,localDate.getMonth(),localDate.getDayOfMonth());

        log.info("fecha probable de muerte:"+deathDate);

        return deathDate.toString();
    }
}
