package com.example.UserApi.service;

import com.example.UserApi.exception.exceptionhandler.ResourceNotFoundException;
import com.example.UserApi.model.Usuario;
import com.example.UserApi.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/** UsuarioService. */
@Service
public class UsuarioService {

  private final UsuarioRepository repo;

  public UsuarioService(UsuarioRepository repo) {
    this.repo = repo;
  }

  public List<Usuario> getAll() {
    return repo.findAll();
  }

  public Usuario guardar(Usuario model) {
    return repo.save(model);
  }

  public Usuario buscarPorId(Long id) {
    return repo.findById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException("No se encontro el usuario con id: " + id));
  }

  public void eliminar(Long id) {
    repo.deleteById(id);
  }
}
