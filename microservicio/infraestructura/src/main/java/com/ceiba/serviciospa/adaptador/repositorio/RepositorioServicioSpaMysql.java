package com.ceiba.serviciospa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioServicioSpaMysql implements RepositorioServicioSpa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="serviciospa", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="serviciospa", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="serviciospa", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="serviciospa", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="serviciospa", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioServicioSpaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(ServicioSpa servicioSpa) {
        return this.customNamedParameterJdbcTemplate.crear(servicioSpa, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(ServicioSpa servicioSpa) {
        this.customNamedParameterJdbcTemplate.actualizar(servicioSpa, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }


}
