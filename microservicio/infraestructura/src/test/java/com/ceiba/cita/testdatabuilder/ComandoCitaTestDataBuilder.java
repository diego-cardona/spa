package com.ceiba.cita.testdatabuilder;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private Usuario usuario;
    private Long idProfesional;
    private LocalDateTime fecha;
    private Long precio;
    private ServicioSpa servicioSpa;

    public ComandoCitaTestDataBuilder() {
        id = 1l;

        usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNombre("petri");
        usuario.setClave("8976");
        usuario.setFechaCreacion(LocalDateTime.now());

        idProfesional = 1234l;
        fecha = LocalDateTime.now();
        precio = 10000l;

        servicioSpa = new ServicioSpa();
        servicioSpa.setId(1l);
        servicioSpa.setNombre("Corte de cabello");
        servicioSpa.setClave("6532");
        servicioSpa.setFechaCreacion(LocalDateTime.now());
        servicioSpa.setPrecio(15000l);

    }

    public ComandoCitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCitaTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public ComandoCitaTestDataBuilder conIdProfesional(Long idProfesional) {
        this.idProfesional = idProfesional;
        return this;
    }

    public ComandoCitaTestDataBuilder confecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public ComandoCitaTestDataBuilder conPrecio(Long precio) {
        this.precio = precio;
        return this;
    }

    public ComandoCitaTestDataBuilder conservicioSpa(ServicioSpa servicioSpa) {
        this.servicioSpa = servicioSpa;
        return this;
    }

    public ComandoCita build() {
        return new ComandoCita(id,usuario, idProfesional,fecha,precio,servicioSpa);
    }
}
