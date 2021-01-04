package com.ceiba.cita.comando;

import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
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


