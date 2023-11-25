package com.alura.hotel.enums;


public class IteradoCountry {

    /**
     * Itera el Enum de {@link CountryEnum} y obtiene los datos del mismo.
     * @return String[] de las naciones del enum.
     */
    public static String[] naciones(){
        String[] listaNaciones = new String[193];

        for(CountryEnum items: CountryEnum.values()){

            listaNaciones[items.ordinal()] = items.getNacion();
        }
        return listaNaciones;
    }
}
