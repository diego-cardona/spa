package com.ceiba.configuracion;

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



}
