package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class CitaTestDataBuilder {

    private Long id;
    private Usuario usuario;
    private Long idProfesional;
    private LocalDateTime fecha;
    private Long precio;
    private ServicioSpa servicioSpa;


    public CitaTestDataBuilder() {
        id = 1l;
        usuario = Mockito.mock(Usuario.class);
        idProfesional = 1L;
        fecha = LocalDateTime.now();
        precio = 1000l;
        servicioSpa = Mockito.mock(ServicioSpa.class);
    }



    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public CitaTestDataBuilder conIdProfesional(Long id) {
        this.idProfesional = idProfesional;
        return this;
    }

    public CitaTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public CitaTestDataBuilder conPrecio(Long precio) {
        this.precio = precio;
        return this;
    }

    public CitaTestDataBuilder conServicioSpa(ServicioSpa servicioSpa) {
        this.servicioSpa = servicioSpa;
        return this;
    }

    public Cita build() {
        return new Cita(id,usuario, idProfesional,fecha,precio, servicioSpa);
    }
}
