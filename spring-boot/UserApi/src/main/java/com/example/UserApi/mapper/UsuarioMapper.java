package com.example.UserApi.mapper;

import com.example.UserApi.dto.UsuarioDTO;
import com.example.UserApi.model.Usuario;
import org.springframework.stereotype.Component;

/** UsuarioMapper. */
@Component
public class UsuarioMapper {

  public Usuario toEntity(UsuarioDTO dto) {
    Usuario usuario = new Usuario();
    usuario.setId(dto.id());
    usuario.setNombre(dto.nombre());
    usuario.setApellido(dto.apellido());
    usuario.setEdad(dto.edad());
    return usuario;
  }

  public UsuarioDTO toDto(Usuario model) {
    UsuarioDTO usuario =
        new UsuarioDTO(model.getId(), model.getNombre(), model.getApellido(), model.getEdad());
    return usuario;
  }
}
