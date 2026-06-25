package com.example.UserApi.controller;

import com.example.UserApi.exception.exceptionhandler.ResourceNotFoundException;
import com.example.UserApi.model.Usuario;
import com.example.UserApi.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
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
  public List<Usuario> listar() {
    return service.getAll();
  }

  @PostMapping("/save")
  public Usuario crear(@Valid @RequestBody Usuario model) {
    return service.guardar(model);
  }

  @GetMapping("/{id}")
  public Usuario obtener(@PathVariable Long id) {
    return service.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public Usuario actualizar(@PathVariable Long id, @Valid @RequestBody Usuario entity) {
    if (id < 0) {
      throw new ResourceNotFoundException("No se puede utiliza un id < 0");
    }
    entity.setId(id);
    return service.guardar(entity);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    if (id < 0) {
      throw new ResourceNotFoundException("No se puede utiliza un id < 0");
    }

    service.eliminar(id);
  }
}
