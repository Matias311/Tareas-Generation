package com.online.tienda.controller;

import com.online.tienda.dto.ClienteRequestDTO;
import com.online.tienda.dto.ClienteResponseDTO;
import com.online.tienda.service.IClienteService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** ClienteController. */
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
  private final IClienteService service;

  @PostMapping()
  public ResponseEntity<ClienteResponseDTO> crearCliente(@RequestBody ClienteRequestDTO dto) {
    return new ResponseEntity<>(service.crearCliente(dto), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<ClienteResponseDTO>> obtenerTodos() {
    return ResponseEntity.ok(service.listarClientes());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClienteResponseDTO> obtenerPorId(@PathVariable Long id) {
    return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.FOUND);
  }
}
