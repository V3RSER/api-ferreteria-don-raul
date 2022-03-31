package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iProductoService {
    Mono<ProductoDTO> add(Mono<ProductoDTO> productoDTO);

    Mono<ProductoDTO> delete(String id);

    Mono<ProductoDTO> update(String id, Mono<ProductoDTO> productoDTO);

    Mono<ProductoDTO> addStock(String id, Integer cantidad);

    Mono<ProductoDTO> reduceStock(String id, Integer cantidad);

    Mono<ProductoDTO> findById(String id);

    Flux<ProductoDTO> findAll();
}
