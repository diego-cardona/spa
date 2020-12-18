package com.ceiba.serviciospa.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoServicioSpa {

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    private Long precio;

}
