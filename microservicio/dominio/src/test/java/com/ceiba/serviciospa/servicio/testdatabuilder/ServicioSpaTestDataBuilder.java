package com.ceiba.serviciospa.servicio.testdatabuilder;

import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class ServicioSpaTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    private Long precio;


    public ServicioSpaTestDataBuilder() {
        nombre = "Masaje";
        clave = "1234";
        fechaCreacion = LocalDateTime.now();
        precio = 1000l;
    }

    public ServicioSpaTestDataBuilder conClave(String clave) {
        this.clave = clave;
        return this;
    }

    public ServicioSpaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ServicioSpa build() {
        return new ServicioSpa(id,nombre, clave,fechaCreacion,precio);
    }
}
