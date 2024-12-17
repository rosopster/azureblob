package com.nttdata.azureblob.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.azureblob.model.Cliente;
import com.nttdata.azureblob.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes() {
        try {
            List<Cliente> clientes = clienteService.obtenerClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los clientes: " + e.getMessage());
        }
    }
}
