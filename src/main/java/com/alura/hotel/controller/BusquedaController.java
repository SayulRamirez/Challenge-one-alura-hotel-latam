package com.alura.hotel.controller;

import com.alura.hotel.dao.BusquedaDao;
import com.alura.hotel.factory.ConnectionFactory;

import java.util.List;

public class BusquedaController {

    private BusquedaDao busquedaDao;

    public BusquedaController(){
        this.busquedaDao = new BusquedaDao(new ConnectionFactory().conectar());
    }

    public List<Object> cargarDatosPorApellido(String parametro) {
        return busquedaDao.cargarDatosPorApellido(parametro);
    }

    public List<Object> cargarDatosPorNumero(int numeroReserva) {
        return busquedaDao.cargarDatosPorNumero(numeroReserva);
    }
}
