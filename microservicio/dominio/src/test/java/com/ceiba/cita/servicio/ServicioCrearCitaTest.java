package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearCitaTest {


    @Test
    public void validarCitaEsSabadoTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        LocalDateTime sabado = LocalDateTime.of(2021, 1, 2, 0, 0);
        boolean esperado = true;
        boolean resultadoReal = cita.esDiaSabadoODomingo(sabado);
        // act - assert
        Assert.assertEquals(esperado, resultadoReal);
    }

    @Test
    public void validarCitaNoEsSabadoTest() {
        // arrange
        Cita cita = new CitaTestDataBuilder().build();
        LocalDateTime viernes = LocalDateTime.of(2021, 1, 1, 0, 0);
        boolean esperado = false;
        boolean resultadoReal = cita.esDiaSabadoODomingo(viernes);
        // act - assert
        Assert.assertEquals(esperado, resultadoReal);
    }

    @Test
    public void validarDiaDeLaCitaTest() {

        // arrange
        LocalDateTime diaSolicitudCita = LocalDateTime.of(2021, 1, 8, 0, 0);
        Cita cita = new CitaTestDataBuilder().conFecha(diaSolicitudCita).build();
        LocalDateTime diaDeLaCitaEsperado = LocalDateTime.of(2021, 1, 12, 0, 0);
        Cita citaMock = Mockito.mock(Cita.class);
        Mockito.when (citaMock.determinarDiaDeLaCita(Mockito.any())).thenReturn(diaDeLaCitaEsperado);
        cita.determinarDiaDeLaCita(diaSolicitudCita);
        // act - assert
        Assert.assertEquals(diaDeLaCitaEsperado.getDayOfMonth(), cita.getFecha().getDayOfMonth());
    }



    @Test
    public void validarIsFestivoTest() {
        // arrange
        LocalDateTime diaFestivo = LocalDateTime.of(2021, 1, 1, 0, 0);
        Cita cita = new CitaTestDataBuilder().build();
        cita.determinarFestivos(2021);
        boolean esFestivo = cita.esFestivo(diaFestivo);

        // act - assert
        Assert.assertEquals(true, esFestivo);
    }

    @Test
    public void validarNotIsFestivoTest() {
        // arrange
        LocalDateTime diaFestivo = LocalDateTime.of(2021, 1, 2, 0, 0);
        Cita cita = new CitaTestDataBuilder().build();
        cita.determinarFestivos(2021);
        boolean esFestivo = cita.esFestivo(diaFestivo);

        // act - assert
        Assert.assertEquals(false, esFestivo);
    }

    @Test
    public void validarPrecioNormalTest() {
        // arrange
        Long precioEsperado = 40000l;
        Cita cita = new CitaTestDataBuilder().conPrecio(40000l).conFecha(LocalDateTime.of(2021, 1, 4, 0, 0)).build();
        cita.determinarPrecioDeLaCita();

        // act - assert
        Assert.assertEquals(precioEsperado, cita.getPrecio());
    }

    @Test
    public void validarPrecioDobleTest() {
        // arrange
        Long precioEsperado = 80000l;
        Cita cita = new CitaTestDataBuilder().conPrecio(40000l).conFecha(LocalDateTime.of(2021, 1, 1, 0, 0)).build();
        cita.determinarPrecioDeLaCita();

        // act - assert
        Assert.assertEquals(precioEsperado, cita.getPrecio());
    }


}
