package com.ceiba.servicio.servicio;

import com.ceiba.servicio.puerto.repositorio.RepositorioServicio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarServicioTest {

    @Test
    @DisplayName("Deberia eliminar el servicio llamando al repositorio")
    void deberiaEliminarElServicioLlamandoAlRepositorio() {
        RepositorioServicio repositorioServicio = Mockito.mock(RepositorioServicio.class);
        ServicioEliminarServicio servicioEliminarServicio = new ServicioEliminarServicio(repositorioServicio);

        servicioEliminarServicio.ejecutar(1l);

        Mockito.verify(repositorioServicio , Mockito.times(1)).eliminar(1l);

    }

}
