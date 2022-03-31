package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.ProveedorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iProveedorService {
    Mono<ProveedorDTO> add(Mono<ProveedorDTO> proveedorDTO);

    Mono<ProveedorDTO> delete(String id);

    Mono<ProveedorDTO> update(String id, Mono<ProveedorDTO> proveedorDTO);

    Mono<ProveedorDTO> findById(String id);

    Flux<ProveedorDTO> findAll();
}