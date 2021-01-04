package com.ceiba.cita.comando;


import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ComandoCita implements Serializable {
    private Long id;
    private Usuario usuario;
    private Long idProfesional;
    private LocalDateTime fecha;
    private Long precio;
    private ServicioSpa servicioSpa;


   public ComandoCita() {
    }

    public ComandoCita(Long id, Usuario usuario, Long idProfesional, LocalDateTime fecha, Long precio, ServicioSpa servicioSpa) {
        this.id = id;
        this.usuario = usuario;
        this.idProfesional = idProfesional;
        this.fecha = fecha;
        this.precio = precio;
        this.servicioSpa = servicioSpa;
    }


}


