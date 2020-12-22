package com.ceiba.serviciospa.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.comando.fabrica.FabricaServicioSpa;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.servicio.ServicioCrearServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearServicioSpa implements ManejadorComandoRespuesta<ComandoServicioSpa, ComandoRespuesta<Long>> {

    private final FabricaServicioSpa fabricaServicioSpa;
    private final ServicioCrearServicio servicioCrearServicioSpa;

    public ManejadorCrearServicioSpa(FabricaServicioSpa fabricaServicioSpa, ServicioCrearServicio servicioCrearServicioSpa) {
        this.fabricaServicioSpa = fabricaServicioSpa;
        this.servicioCrearServicioSpa = servicioCrearServicioSpa;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoServicioSpa comandoServicioSpa) {
        ServicioSpa servicioSpa = this.fabricaServicioSpa.crear(comandoServicioSpa);
        return new ComandoRespuesta<>(this.servicioCrearServicioSpa.ejecutar(servicioSpa));
    }
}
