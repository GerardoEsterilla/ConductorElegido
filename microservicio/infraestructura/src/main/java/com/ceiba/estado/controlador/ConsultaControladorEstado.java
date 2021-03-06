package com.ceiba.estado.controlador;

import com.ceiba.estado.consulta.ManejadorListarEstado;
import com.ceiba.estadoservicio.modelo.dto.DtoEstado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
@Api(tags={"Controlador consulta estados"})
public class ConsultaControladorEstado {

    private final ManejadorListarEstado manejadorListarEstado;

    public ConsultaControladorEstado(ManejadorListarEstado manejadorListarEstado) {
        this.manejadorListarEstado = manejadorListarEstado;
    }

    @GetMapping
    @ApiOperation("Listar estados")
    public List<DtoEstado> listar() {
        return this.manejadorListarEstado.ejecutar();
    }

}
