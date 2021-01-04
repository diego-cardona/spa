package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {




    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        //Datos del usuario
        Long idUsuario = resultSet.getLong("usuario");
        String nombreUsuario = resultSet.getString("usuario.nombre");
        String claveUsuario = resultSet.getString("usuario.clave");
        LocalDateTime fechaUsuario = extraerLocalDateTime(resultSet, "usuario.fecha_creacion");

        Long idProfesional = resultSet.getLong("idProfesional");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        Long precio = resultSet.getLong("precio");
        String nombre = resultSet.getString("nombre");

        //Datos del servicio spa
        Long idServicioSpa = resultSet.getLong("serviciospa");
        String nombreServicioSpa = resultSet.getString("serviciospa.nombre");
        String claveServicioSpa = resultSet.getString("serviciospa.clave");
        LocalDateTime fechaServicioSpa = extraerLocalDateTime(resultSet, "serviciospa.fecha_creacion");
        Long precioServicioSpa = resultSet.getLong("serviciospa.precio");

        Usuario usuario = new Usuario(idUsuario,nombreUsuario,claveUsuario,fechaUsuario);
        ServicioSpa servicioSpa = new ServicioSpa(idServicioSpa,nombreServicioSpa,claveServicioSpa,fechaServicioSpa,precioServicioSpa);

        return new DtoCita(id,usuario,idProfesional,fecha,precio,nombre,servicioSpa);
    }


}
