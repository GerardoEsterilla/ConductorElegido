package com.ceiba.vehiculo.puerto.repositorio;

import com.ceiba.vehiculo.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

    /**
     * Permite crear un vehiculo
     * @param vehiculo
     * @return el id generado
     */
    Long crear(Vehiculo vehiculo);

    /**
     * Permite actualizar un vehiculo
     * @param vehiculo
     */
    void actualizar(Vehiculo vehiculo);

    /**
     * Permite eliminar un vehiculo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un vehiculo con una placa
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);

    /**
     * Permite validar si existe un conductor con un vehiculo excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
