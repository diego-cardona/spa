package com.ceiba.serviciospa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;
import com.ceiba.serviciospa.puerto.dao.DaoServicioSpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoServicioSpaMysql implements DaoServicioSpa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="serviciospa", value="listar")
    private static String sqlListar;

    public DaoServicioSpaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoServicioSpa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoServicioSpa());
    }
}
