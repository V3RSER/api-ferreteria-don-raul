package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.volante.CompraDTO;
import co.com.sofka.app.ferreteria.dtos.volante.VolanteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iVolanteService {
    Mono<VolanteDTO> add(Mono<CompraDTO> compra);

    Mono<VolanteDTO> delete(String id);

    Mono<VolanteDTO> update(String id, Mono<VolanteDTO> clienteDTO);

    Mono<VolanteDTO> findById(String id);

    Flux<VolanteDTO> findAll();
}