package com.ceiba.vehiculo.servicio;

import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarVehiculoTest {

    @Test
    @DisplayName("Deberia eliminar el vehiculo llamando al repositorio")
    void deberiaEliminarElClienteLlamandoAlRepositorio() {
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        ServicioEliminarVehiculo servicioEliminarVehiculo = new ServicioEliminarVehiculo(repositorioVehiculo);

        servicioEliminarVehiculo.ejecutar(1l);

        Mockito.verify(repositorioVehiculo , Mockito.times(1)).eliminar(1l);

    }

}
