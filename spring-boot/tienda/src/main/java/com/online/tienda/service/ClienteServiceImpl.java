package com.online.tienda.service;

import com.online.tienda.dto.ClienteRequestDTO;
import com.online.tienda.dto.ClienteResponseDTO;
import com.online.tienda.mapper.ClienteMapper;
import com.online.tienda.repository.ClienteRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/** ClienteService. */
@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

  private final ClienteRepository repo;
  private final ClienteMapper mapper;

  @Override
  public ClienteResponseDTO crearCliente(ClienteRequestDTO dto) {
    return mapper.toDto(repo.save(mapper.toEntity(dto)));
  }

  @Override
  public List<ClienteResponseDTO> listarClientes() {
    return repo.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public ClienteResponseDTO buscarPorId(Long id) {
    var cliente = repo.findById(id).orElseThrow(); // TODO: manejar excepcion
    return mapper.toDto(cliente);
  }
}
