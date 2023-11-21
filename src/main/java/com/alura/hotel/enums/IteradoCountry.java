package com.alura.hotel.enums;

public class IteradoCountry {

    public static String[] naciones(){
        String[] listaNaciones = new String[194];

        for(CountryEnum items: CountryEnum.values()){

            listaNaciones[items.ordinal()] = items.getNacion();
        }
        return listaNaciones;
    }
}
