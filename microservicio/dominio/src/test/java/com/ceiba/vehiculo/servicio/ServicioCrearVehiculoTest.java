package com.ceiba.vehiculo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.vehiculo.modelo.entidad.Vehiculo;
import com.ceiba.vehiculo.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.VehiculoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearVehiculoTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia del Vehiculo")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelVehiculo() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearVehiculo.ejecutar(vehiculo), ExcepcionDuplicidad.class,"El vehiculo ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el vehiculo de manera correcta")
    void deberiaCrearElVehiculoDeManeraCorrecta() {
        // arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        RepositorioVehiculo repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        Mockito.when(repositorioVehiculo.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioVehiculo.crear(vehiculo)).thenReturn(10L);
        ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
        // act
        Long idVehiculo = servicioCrearVehiculo.ejecutar(vehiculo);
        //- assert
        assertEquals(10L,idVehiculo);
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).crear(vehiculo);
    }
}
