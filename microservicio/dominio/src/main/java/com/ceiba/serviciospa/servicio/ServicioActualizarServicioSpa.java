package com.ceiba.serviciospa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;


public class ServicioActualizarServicioSpa {

    private static final String EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA = "El servicio spa ya existe en el sistema";

    private final RepositorioServicioSpa repositorioServicioSpa;

    public ServicioActualizarServicioSpa(RepositorioServicioSpa repositorioServicioSpa) {
        this.repositorioServicioSpa = repositorioServicioSpa;
    }

    public void ejecutar(ServicioSpa servicioSpa) {
        validarExistenciaPrevia(servicioSpa);
        this.repositorioServicioSpa.actualizar(servicioSpa);
    }

    private void validarExistenciaPrevia(ServicioSpa servicioSpa) {
        boolean existe = this.repositorioServicioSpa.existeExcluyendoId(servicioSpa.getId(),servicioSpa.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_SERVICIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
