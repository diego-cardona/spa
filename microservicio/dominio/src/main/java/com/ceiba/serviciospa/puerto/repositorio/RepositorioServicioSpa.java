package com.ceiba.serviciospa.puerto.repositorio;

import com.ceiba.serviciospa.modelo.entidad.ServicioSpa;

public interface RepositorioServicioSpa {
        /**
         * Permite crear un serviciospa
         * @param serviciospa
         * @return el id generado
         */
        Long crear(ServicioSpa serviciospa);

        /**
         * Permite actualizar un usuario
         * @param usuario
         */
        void actualizar(ServicioSpa usuario);

        /**
         * Permite eliminar un usuario
         * @param id
         */
        void eliminar(Long id);

        /**
         * Permite validar si existe un serviciospa con un nombre
         * @param nombre
         * @return si existe o no
         */
        boolean existe(String nombre);

        /**
         * Permite validar si existe un serviciospa con un nombre excluyendo un id
         * @param nombre
         * @return si existe o no
         */
        boolean existeExcluyendoId(Long id,String nombre);

    }
