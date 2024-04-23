package com.alura.hotel.controller;

import com.alura.hotel.dao.NewUsuarioDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Usuario;

public class NewUsuarioController {

    private final NewUsuarioDao newUsuarioDao;

    public NewUsuarioController(){
        this.newUsuarioDao = new NewUsuarioDao();
    }

    public void createNewUser(Usuario usuarioNew, Huesped dataNewHuesped) {
        newUsuarioDao.createNewUser(usuarioNew, dataNewHuesped);
    }
}
