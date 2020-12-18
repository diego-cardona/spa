package com.ceiba.serviciospa.comando.fabrica;

import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import org.springframework.stereotype.Component;

@Component
public class FabricaServicioSpa {

    public ServicioSpa crear(ComandoServicioSpa comandoServicioSpa) {
        return new ServicioSpa(
                comandoServicioSpa.getId(),
                comandoServicioSpa.getNombre(),
                comandoServicioSpa.getClave(),
                comandoServicioSpa.getFecha(),
                comandoServicioSpa.getPrecio()
        );
    }
}
