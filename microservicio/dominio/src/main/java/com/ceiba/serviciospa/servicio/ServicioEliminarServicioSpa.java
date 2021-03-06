package com.ceiba.serviciospa.servicio;

import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;

public class ServicioEliminarServicioSpa {

    private final RepositorioServicioSpa repositorioServicioSpa;

    public ServicioEliminarServicioSpa(RepositorioServicioSpa repositorioServicioSpa) {
        this.repositorioServicioSpa = repositorioServicioSpa;
    }

    public void ejecutar(Long id) {
        this.repositorioServicioSpa.eliminar(id);
    }

}
