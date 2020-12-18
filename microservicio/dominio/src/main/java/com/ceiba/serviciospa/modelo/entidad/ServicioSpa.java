package com.ceiba.serviciospa.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class ServicioSpa {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO = "Se debe ingresar el nombre de servicio";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_SERVICIO = "Se debe ingresar el nombre de servicio";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
    private Long precio;

    public ServicioSpa(Long id,String nombre, String clave,LocalDateTime fechaCreacion, Long precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_SERVICIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DEL_SERVICIO);

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
        this.precio = precio;
    }

}
