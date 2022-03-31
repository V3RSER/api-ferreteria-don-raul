package co.com.sofka.app.ferreteria.services.impl;

import co.com.sofka.app.ferreteria.dtos.cliente.ClienteDTO;
import co.com.sofka.app.ferreteria.repositories.ClienteRepository;
import co.com.sofka.app.ferreteria.services.iClienteService;
import co.com.sofka.app.ferreteria.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService implements iClienteService {
    @Autowired
    private ClienteRepository repository;
    
    @Override
    public Mono<ClienteDTO> add(Mono<ClienteDTO> clienteDTO) {
        return clienteDTO.map(AppUtils::clienteDtoToModel)
                .flatMap(this.repository::save)
                .map(AppUtils::clienteModelToDto);
    }

    @Override
    public Mono<ClienteDTO> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p))
                .map(AppUtils::clienteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ClienteDTO> update(String id, Mono<ClienteDTO> clienteDTO) {
        return this.repository.findById(id)
                .flatMap(p -> clienteDTO.map(AppUtils::clienteDtoToModel)
                        .doOnNext(cliente -> cliente.setId(id)))
                .flatMap(this.repository::save)
                .map(AppUtils::clienteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ClienteDTO> findById(String id) {
        return this.repository.findById(id)
                .map(AppUtils::clienteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<ClienteDTO> findAll() {
        return this.repository.findAll()
                .map(AppUtils::clienteModelToDto)
                .switchIfEmpty(Flux.empty());
    }
}
