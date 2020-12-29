package com.ceiba.serviciospa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;
import com.ceiba.serviciospa.servicio.testdatabuilder.ServicioSpaTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarServicioSpaTest {

    @Test
    public void validarServicioSpaExistenciaPreviaTest() {
        // arrange
        ServicioSpa servicioSpa = new ServicioSpaTestDataBuilder().conId(1l).build();

        RepositorioServicioSpa repositorioServicioSpa = Mockito.mock(RepositorioServicioSpa.class);
        Mockito.when(repositorioServicioSpa.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarServicioSpa servicioActualizarServicioSpa = new ServicioActualizarServicioSpa(repositorioServicioSpa);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarServicioSpa.ejecutar(servicioSpa), ExcepcionDuplicidad.class,"El servicio spa ya existe en el sistema");
    }
}
