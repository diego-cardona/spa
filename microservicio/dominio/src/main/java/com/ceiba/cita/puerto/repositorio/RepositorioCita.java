package com.ceiba.cita.puerto.repositorio;
import com.ceiba.cita.modelo.entidad.Cita;

public interface RepositorioCita {
        /**
         * Permite crear una cita
         * @param cita
         * @return el id generado
         */
        Long crear(Cita cita);

        /**
         * Permite actualizar una cita
         * @param cita
         */
        void actualizar(Cita cita);

        /**
         * Permite eliminar una cita
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
