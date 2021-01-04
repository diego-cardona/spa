package com.ceiba.cita.consulta;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;
import com.ceiba.serviciospa.puerto.dao.DaoServicioSpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCitas {

    private final DaoCita daoCita;

    public ManejadorListarCitas(DaoCita daoCita){
        this.daoCita = daoCita;
    }

    public List<DtoCita> ejecutar(){ return this.daoCita.listar(); }
}
