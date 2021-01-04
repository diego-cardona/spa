package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDateTime;

public class ServicioActualizarCita {

    private static final String LA_CITA_YA_EXISTE_EN_EL_SISTEMA = "El cita ya existe en el sistema";

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void ejecutar(Cita cita) {
        //validarExistenciaPrevia(cita);
        LocalDateTime fecha = LocalDateTime.now();
        cita.determinarDiaDeLaCita(fecha);
        cita.determinarPrecioDeLaCita();
        this.repositorioCita.actualizar(cita);
    }

    private void validarExistenciaPrevia(Cita cita) {
        boolean existe = this.repositorioCita.existeExcluyendoId(cita.getId(),cita.getUsuario().getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CITA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
