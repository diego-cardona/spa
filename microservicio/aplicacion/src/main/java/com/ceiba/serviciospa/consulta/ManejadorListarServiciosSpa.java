package com.ceiba.serviciospa.consulta;

import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;
import com.ceiba.serviciospa.puerto.dao.DaoServicioSpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarServiciosSpa {

    private final DaoServicioSpa daoServicioSpa;

    public ManejadorListarServiciosSpa(DaoServicioSpa daoServicioSpa){
        this.daoServicioSpa = daoServicioSpa;
    }

    public List<DtoServicioSpa> ejecutar(){ return this.daoServicioSpa.listar(); }
}
