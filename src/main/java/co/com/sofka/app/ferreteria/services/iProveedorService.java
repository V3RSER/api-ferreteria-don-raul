package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.cliente.FacturaDTO;
import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import co.com.sofka.app.ferreteria.dtos.proveedor.ProveedorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface iProveedorService {
    Mono<ProveedorDTO> add(ProveedorDTO clienteDTO);

    Mono<ProveedorDTO> delete(String id);

    Mono<ProveedorDTO> update(String id, ProveedorDTO clienteDTO);

    Mono<ProveedorDTO> findById(String id);

    Mono<ProductoDTO> findByDocumentoIdentidad(String documentoIdentidad);

    Flux<ProveedorDTO> findAll();

    Mono<FacturaDTO> generateVolante(String idProveedor, List<ProductoDTO> productos);
}