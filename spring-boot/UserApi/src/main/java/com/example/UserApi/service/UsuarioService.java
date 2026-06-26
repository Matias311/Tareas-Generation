package com.example.UserApi.service;

import com.example.UserApi.dto.UsuarioDTO;
import com.example.UserApi.exception.exceptionhandler.ResourceNotFoundException;
import com.example.UserApi.mapper.UsuarioMapper;
import com.example.UserApi.model.Usuario;
import com.example.UserApi.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/** UsuarioService. */
@Service
public class UsuarioService {

  private final UsuarioRepository repo;
  private final UsuarioMapper mapper;

  public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper) {
    this.repo = repo;
    this.mapper = mapper;
  }

  public List<UsuarioDTO> getAll() {
    return repo.findAll().stream().map(mapper::toDto).toList();
  }

  public UsuarioDTO guardar(UsuarioDTO model) {
    Usuario usuario = repo.save(mapper.toEntity(model));
    return mapper.toDto(usuario);
  }

  public UsuarioDTO actualizar(Long id, UsuarioDTO model) {
    Usuario usuario =
        repo.findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el usuario con id: " + id));

    usuario.setEdad(model.edad());
    usuario.setApellido(model.apellido());
    usuario.setNombre(model.nombre());

    return mapper.toDto(repo.save(usuario));
  }

  public UsuarioDTO buscarPorId(Long id) {
    Usuario usuario =
        repo.findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el usuario con id: " + id));
    return mapper.toDto(usuario);
  }

  public void eliminar(Long id) {
    repo.deleteById(id);
  }
}
