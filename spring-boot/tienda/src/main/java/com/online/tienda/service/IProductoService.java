package com.online.tienda.service;

import com.online.tienda.dto.ProductoRequestDTO;
import com.online.tienda.dto.ProductoResponseDTO;
import java.util.List;

/** IProductoService. */
public interface IProductoService {

  public ProductoResponseDTO crearProducto(ProductoRequestDTO dto);

  public List<ProductoResponseDTO> listarProductos();

  public ProductoResponseDTO buscarPorId(Long id);

  public void eliminarProducto(Long id);
}
