package com.online.tienda.controller;

import com.online.tienda.dto.ProductoRequestDTO;
import com.online.tienda.dto.ProductoResponseDTO;
import com.online.tienda.service.IProductoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** ProductoController. */
@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {

  private final IProductoService service;

  @PostMapping()
  public ResponseEntity<ProductoResponseDTO> crearProducto(@RequestBody ProductoRequestDTO dto) {
    return new ResponseEntity<>(service.crearProducto(dto), HttpStatus.CREATED);
  }

  @GetMapping()
  public ResponseEntity<List<ProductoResponseDTO>> listarProductos() {
    return ResponseEntity.ok(service.listarProductos());
  }

  @GetMapping("{id}")
  public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
    return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.FOUND);
  }

  @DeleteMapping("{id}")
  public HttpStatus eliminarProducto(@PathVariable Long id) {
    service.eliminarProducto(id);
    return HttpStatus.OK;
  }
}
