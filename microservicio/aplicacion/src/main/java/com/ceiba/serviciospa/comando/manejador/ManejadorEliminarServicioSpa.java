package com.ceiba.serviciospa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.serviciospa.servicio.ServicioEliminarServicioSpa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarServicioSpa implements ManejadorComando<Long> {
    private final ServicioEliminarServicioSpa servicioEliminarServicioSpa;

    public ManejadorEliminarServicioSpa(ServicioEliminarServicioSpa servicioEliminarServicioSpa) {
        this.servicioEliminarServicioSpa = servicioEliminarServicioSpa;
    }

    public void ejecutar(Long idServicioSpa) {
        this.servicioEliminarServicioSpa.ejecutar(idServicioSpa);
    }

}
