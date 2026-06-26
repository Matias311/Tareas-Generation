package com.online.tienda.service;

import com.online.tienda.dto.ProductoRequestDTO;
import com.online.tienda.dto.ProductoResponseDTO;
import com.online.tienda.mapper.ProductoMapper;
import com.online.tienda.repository.ProductoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/** ProductoServiceImpl. */
@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

  private final ProductoRepository repo;
  private final ProductoMapper mapper;

  @Override
  public ProductoResponseDTO crearProducto(ProductoRequestDTO dto) {
    return mapper.toDto(repo.save(mapper.toEntity(dto)));
  }

  @Override
  public List<ProductoResponseDTO> listarProductos() {
    return repo.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public ProductoResponseDTO buscarPorId(Long id) {
    var p = repo.findById(id).orElseThrow(); // TODO: Manejar la excepcion
    return mapper.toDto(p);
  }

  @Override
  public void eliminarProducto(Long id) {
    repo.deleteById(id);
  }
}
