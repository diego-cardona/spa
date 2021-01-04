package com.ceiba.cita.modelo.dto;

import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoCita {

    private Long id;
    private Usuario usuario;
    private Long idProfesional;
    private LocalDateTime fecha;
    private Long precio;
    private String nombre;
    private ServicioSpa servicioSpa;

}
