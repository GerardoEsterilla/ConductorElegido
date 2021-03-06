package com.ceiba.estadoservicio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estadoservicio.modelo.entidad.Estado;
import com.ceiba.estadoservicio.puerto.repositorio.RepositorioEstado;

public class ServicioCrearEstado {
    private static final String EL_ESTADO_YA_EXISTE_EN_EL_SISTEMA = "El estado ya existe en el sistema";

    private final RepositorioEstado repositorioEstado;

    public ServicioCrearEstado(RepositorioEstado repositorioEstado) {this.repositorioEstado = repositorioEstado;
    }

    public Long ejecutar(Estado estado) {
        validarExistenciaPrevia(estado);
        return this.repositorioEstado.crear(estado);
    }

    private void validarExistenciaPrevia(Estado estado) {
        boolean existe = this.repositorioEstado.existe(estado.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_ESTADO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
