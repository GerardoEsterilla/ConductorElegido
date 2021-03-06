package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags={"Controlador consulta cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarCliente manejadorListarCliente;

    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarCliente) {
        this.manejadorListarCliente = manejadorListarCliente;
    }

    @GetMapping
    @ApiOperation("Listar clientes")
    public List<DtoCliente> listar() {
        return this.manejadorListarCliente.ejecutar();
    }

    @GetMapping(value = "/{cedula}")
    @ApiOperation("Listar cliente por cedula")
    public DtoCliente listarClienteCedula(@PathVariable String cedula) {
        return this.manejadorListarCliente.ejecutarCedulaCliente(cedula);
    }

}
