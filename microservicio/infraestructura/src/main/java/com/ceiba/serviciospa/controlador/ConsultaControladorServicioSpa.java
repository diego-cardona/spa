package com.ceiba.serviciospa.controlador;

import com.ceiba.serviciospa.consulta.ManejadorListarServiciosSpa;
import com.ceiba.serviciospa.modelo.dto.DtoServicioSpa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serviciosspa")
@Api(tags={"Controlador consulta servicios spa"})
public class ConsultaControladorServicioSpa {

    private final ManejadorListarServiciosSpa manejadorListarServiciosSpa;

    public ConsultaControladorServicioSpa(ManejadorListarServiciosSpa manejadorListarServiciosSpa) {
        this.manejadorListarServiciosSpa = manejadorListarServiciosSpa;
    }

    @GetMapping
    @ApiOperation("Listar Servicios Spa")
    public List<DtoServicioSpa> listar() {
        return this.manejadorListarServiciosSpa.ejecutar();
    }

}
