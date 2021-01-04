package com.ceiba.serviciospa.testdatabuilder;

import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoServicioSpaTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    private Long precio;

    public ComandoServicioSpaTestDataBuilder() {
        id = 1l;
        nombre = "test";
        clave = "1234";
        fechaCreacion = LocalDateTime.now();
        precio = 10000l;
    }

    public ComandoServicioSpaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoServicioSpaTestDataBuilder conPrecio(Long precio) {
        this.precio = precio;
        return this;
    }

    public ComandoServicioSpa build() {
        return new ComandoServicioSpa(id,nombre, clave,fechaCreacion,precio);
    }
}
