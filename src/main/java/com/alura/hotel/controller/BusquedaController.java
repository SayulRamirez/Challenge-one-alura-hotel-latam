package com.alura.hotel.controller;

import com.alura.hotel.dao.BusquedaDao;

import java.util.List;

public class BusquedaController {

    private final BusquedaDao busquedaDao;

    public BusquedaController(){
        this.busquedaDao = new BusquedaDao();
    }

    public List<Object> cargarDatosPorApellido(String parametro) {
        return busquedaDao.cargarDatosPorApellido(parametro);
    }

    public List<Object> cargarDatosPorNumero(int numeroReserva) {
        return busquedaDao.cargarDatosPorNumero(numeroReserva);
    }
}
