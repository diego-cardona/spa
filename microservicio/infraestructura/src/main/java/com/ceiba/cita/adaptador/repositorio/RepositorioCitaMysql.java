package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public class RepositorioCitaMysql implements RepositorioCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @SqlStatement(namespace="cita", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cita", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cita", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="cita", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cita", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cita cita) {
        MapSqlParameterSource paramSource = crearParametros(cita);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.namedParameterJdbcTemplate.update(sqlCrear, paramSource,keyHolder,new String[] { "id" });
        return keyHolder.getKey().longValue();
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
    public void actualizar(Cita cita) {
        MapSqlParameterSource paramSource = crearParametros(cita);
        this.namedParameterJdbcTemplate.update(sqlActualizar, paramSource);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    public MapSqlParameterSource crearParametros(Cita cita){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",cita.getId().toString())
                .addValue("usuario", cita.getUsuario().getId().toString())
                .addValue("idProfesional", cita.getIdProfesional().toString())
                .addValue("fecha",cita.getFecha().toString())
                .addValue("precio",cita.getPrecio().toString())
                .addValue("servicioSpa",cita.getServicioSpa().getId().toString());
        return paramSource;
    }
    public MapSqlParameterSource crearParametrosUpdate(Cita cita){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",cita.getId().toString())
                .addValue("usuario", cita.getUsuario().getId().toString())
                .addValue("idProfesional", cita.getIdProfesional().toString())
                .addValue("fecha", LocalDateTime.now().toString())
                .addValue("precio",cita.getPrecio().toString())
                .addValue("servicioSpa",cita.getServicioSpa().getId().toString());
        return paramSource;
    }

}
