package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import co.com.sofka.app.ferreteria.dtos.proveedor.ProveedorDTO;
import co.com.sofka.app.ferreteria.dtos.proveedor.VolanteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface iProveedorService {
    Mono<ProveedorDTO> add(ProveedorDTO clienteDTO);

    Mono<ProveedorDTO> delete(String id);

    Mono<ProveedorDTO> update(String id, ProveedorDTO clienteDTO);

    Mono<ProveedorDTO> findById(String id);

    Mono<ProveedorDTO> findByDocumentoIdentidad(String documentoIdentidad);

    Flux<ProveedorDTO> findAll();

    Mono<VolanteDTO> generateVolante(String idProveedor, List<ProductoDTO> productos);
}