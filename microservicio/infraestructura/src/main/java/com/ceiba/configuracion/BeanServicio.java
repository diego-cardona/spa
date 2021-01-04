package com.ceiba.configuracion;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.serviciospa.puerto.repositorio.RepositorioServicioSpa;
import com.ceiba.serviciospa.servicio.ServicioActualizarServicioSpa;
import com.ceiba.serviciospa.servicio.ServicioCrearServicio;
import com.ceiba.serviciospa.servicio.ServicioEliminarServicioSpa;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }


    //-------------------------------------------------------------------------------------------

    @Bean
    public ServicioCrearServicio servicioCrearServicio(RepositorioServicioSpa repositorioServicioSpa) {
        return new ServicioCrearServicio(repositorioServicioSpa);
    }

    @Bean
    public ServicioEliminarServicioSpa servicioEliminarServicioSpa(RepositorioServicioSpa repositorioServicioSpa) {
        return new ServicioEliminarServicioSpa(repositorioServicioSpa);
    }

    @Bean
    public ServicioActualizarServicioSpa servicioActualizarServicioSpa(RepositorioServicioSpa repositorioServicioSpa) {
        return new ServicioActualizarServicioSpa(repositorioServicioSpa);
    }
    //-------------------------------------------------------------------------------------------

    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita) {
        return new ServicioCrearCita(repositorioCita);
    }

    @Bean
    public ServicioEliminarCita servicioEliminarCita(RepositorioCita repositorioCita) {
        return new ServicioEliminarCita(repositorioCita);
    }

    @Bean
    public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
        return new ServicioActualizarCita(repositorioCita);
    }


}
