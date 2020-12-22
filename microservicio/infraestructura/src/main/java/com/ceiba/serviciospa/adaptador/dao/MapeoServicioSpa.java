package com.ceiba.serviciospa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoServicioSpa implements RowMapper<DtoServicioSpa>, MapperResult {
    @Override
    public DtoServicioSpa mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String clave = resultSet.getString("clave");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        Long precio = resultSet.getLong("precio");

        return new DtoServicioSpa(id,nombre,clave,fecha,precio);
    }
}
