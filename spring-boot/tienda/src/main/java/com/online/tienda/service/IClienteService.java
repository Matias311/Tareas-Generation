package com.online.tienda.service;

import com.online.tienda.dto.ClienteRequestDTO;
import com.online.tienda.dto.ClienteResponseDTO;
import java.util.List;

/** IClienteService. */
public interface IClienteService {

  public ClienteResponseDTO crearCliente(ClienteRequestDTO dto);

  public List<ClienteResponseDTO> listarClientes();

  public ClienteResponseDTO buscarPorId(Long id);
}
