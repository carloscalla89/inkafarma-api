package com.inkafarma.personsapi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utilitario {
    public static String getDeathDateEstimate(String fechaNacimiento){
        String datos[] = fechaNacimiento.split("-");

        Calendar unaFecha;
        Random aleatorio;
        aleatorio = new Random();


        unaFecha = Calendar.getInstance();
        unaFecha.set (aleatorio.nextInt(50)+Integer.parseInt(datos[0]), aleatorio.nextInt(Integer.parseInt(datos[1]))+1, aleatorio.nextInt(Integer.parseInt(datos[2]))+1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(unaFecha.getTime());
    }
}
