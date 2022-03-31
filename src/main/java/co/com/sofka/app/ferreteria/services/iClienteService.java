package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.cliente.ClienteDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iClienteService {
    Mono<ClienteDTO> add(Mono<ClienteDTO> clienteDTO);

    Mono<ClienteDTO> delete(String id);

    Mono<ClienteDTO> update(String id, Mono<ClienteDTO> clienteDTO);

    Mono<ClienteDTO> findById(String id);

    Flux<ClienteDTO> findAll();
}
