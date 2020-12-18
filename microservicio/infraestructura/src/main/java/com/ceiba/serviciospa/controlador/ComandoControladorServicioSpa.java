package com.ceiba.serviciospa.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.serviciospa.comando.ComandoServicioSpa;
import com.ceiba.serviciospa.comando.manejador.ManejadorActualizarServicioSpa;
import com.ceiba.serviciospa.comando.manejador.ManejadorCrearServicioSpa;
import com.ceiba.serviciospa.comando.manejador.ManejadorEliminarServicioSpa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviciosspa")
@Api(tags = { "Controlador comando serviciospa"})
public class ComandoControladorServicioSpa {

    private final ManejadorCrearServicioSpa manejadorCrearServicioSpa;
    private final ManejadorEliminarServicioSpa manejadorEliminarServicioSpa;
    private final ManejadorActualizarServicioSpa manejadorActualizarServicioSpa;

    @Autowired
    public ComandoControladorServicioSpa(ManejadorCrearServicioSpa manejadorCrearServicioSpa,
                                         ManejadorEliminarServicioSpa manejadorEliminarServicioSpa,
                                         ManejadorActualizarServicioSpa manejadorActualizarServicioSpa) {
        this.manejadorCrearServicioSpa = manejadorCrearServicioSpa;
        this.manejadorEliminarServicioSpa = manejadorEliminarServicioSpa;
        this.manejadorActualizarServicioSpa = manejadorActualizarServicioSpa;
    }

    @PostMapping
    @ApiOperation("Crear ServicioSpa")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoServicioSpa comandoServicioSpa) {
        return manejadorCrearServicioSpa.ejecutar(comandoServicioSpa);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar ServicioSpa")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarServicioSpa.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar ServicioSpa")
    public void actualizar(@RequestBody ComandoServicioSpa comandoServicioSpa,@PathVariable Long id) {
        comandoServicioSpa.setId(id);
        manejadorActualizarServicioSpa.ejecutar(comandoServicioSpa);
    }

}
