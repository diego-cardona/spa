package com.ceiba.serviciospa.puerto.dao;

import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;

import java.util.List;

public interface DaoServicioSpa {
    /**
     * Permite listar servicios spa
     * @return los servicios
     */
    List<DtoServicioSpa> listar();
}
