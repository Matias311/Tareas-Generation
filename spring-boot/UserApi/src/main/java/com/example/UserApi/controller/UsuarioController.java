package com.example.UserApi.controller;

import com.example.UserApi.dto.UsuarioDTO;
import com.example.UserApi.exception.exceptionhandler.ResourceNotFoundException;
import com.example.UserApi.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** UsuarioController. */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  public final UsuarioService service;

  public UsuarioController(UsuarioService service) {
    this.service = service;
  }

  @GetMapping("/")
  public ResponseEntity<List<UsuarioDTO>> listar() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping("/save")
  public ResponseEntity<UsuarioDTO> crear(@Valid @RequestBody UsuarioDTO model) {
    return new ResponseEntity<>(service.guardar(model), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
    return ResponseEntity.ok(service.buscarPorId(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDTO> actualizar(
      @PathVariable Long id, @Valid @RequestBody UsuarioDTO entity) {
    if (id < 0) {
      throw new ResourceNotFoundException("No se puede utiliza un id < 0");
    }

    return new ResponseEntity<UsuarioDTO>(service.actualizar(id, entity), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public HttpStatus eliminar(@PathVariable Long id) {
    if (id < 0) {
      throw new ResourceNotFoundException("No se puede utiliza un id < 0");
    }

    service.eliminar(id);
    return HttpStatus.OK;
  }
}
