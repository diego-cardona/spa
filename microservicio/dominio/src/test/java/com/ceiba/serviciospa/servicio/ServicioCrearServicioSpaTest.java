package com.ceiba.serviciospa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;
import com.ceiba.serviciospa.servicio.testdatabuilder.ServicioSpaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearServicioSpaTest {

    @Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
        ServicioSpaTestDataBuilder servicioSpaTestDataBuilder = new ServicioSpaTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(() -> servicioSpaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }

    @Test
    public void validarServicioSpaExistenciaPreviaTest() {
        // arrange
        ServicioSpa servicioSpa = new ServicioSpaTestDataBuilder().build();
        RepositorioServicioSpa repositorioServicioSpa = Mockito.mock(RepositorioServicioSpa.class);
        Mockito.when(repositorioServicioSpa.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearServicio servicioCrearServicioSpa = new ServicioCrearServicio(repositorioServicioSpa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearServicioSpa.ejecutar(servicioSpa), ExcepcionDuplicidad.class,"El servicio spa ya existe en el sistema");
    }
}
