package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;
import com.ceiba.serviciospa.servicio.ServicioActualizarServicioSpa;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarCitaTest {

    /*
    @Test
    public void validarServicioSpaExistenciaPreviaTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().conId(1l).build();

        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class,"El servicio spa ya existe en el sistema");
    }

     */
}
