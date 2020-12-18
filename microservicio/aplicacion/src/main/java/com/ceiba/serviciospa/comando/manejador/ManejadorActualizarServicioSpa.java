package com.ceiba.serviciospa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.comando.fabrica.FabricaServicioSpa;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.servicio.ServicioActualizarServicioSpa;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarServicioSpa implements ManejadorComando<ComandoServicioSpa> {

    private final FabricaServicioSpa fabricaServicioSpa;
    private final ServicioActualizarServicioSpa servicioActualizarServicioSpa;

    public ManejadorActualizarServicioSpa(FabricaServicioSpa fabricaServicioSpa, ServicioActualizarServicioSpa servicioActualizarServicioSpa) {
        this.fabricaServicioSpa = fabricaServicioSpa;
        this.servicioActualizarServicioSpa = servicioActualizarServicioSpa;
    }

    public void ejecutar(ComandoServicioSpa comandoServicioSpa) {
        ServicioSpa servicioSpa = this.fabricaServicioSpa.crear(comandoServicioSpa);
        this.servicioActualizarServicioSpa.ejecutar(servicioSpa);
    }


}
