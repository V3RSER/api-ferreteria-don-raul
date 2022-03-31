package co.com.sofka.app.ferreteria.services.impl;

import co.com.sofka.app.ferreteria.dtos.ProveedorDTO;
import co.com.sofka.app.ferreteria.repositories.ProveedorRepository;
import co.com.sofka.app.ferreteria.services.iProveedorService;
import co.com.sofka.app.ferreteria.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorService implements iProveedorService {
    @Autowired
    private ProveedorRepository repository;

    @Override
    public Mono<ProveedorDTO> add(Mono<ProveedorDTO> proveedorDTO) {
        return proveedorDTO.map(AppUtils::proveedorDtoToModel)
                .flatMap(this.repository::save)
                .map(AppUtils::proveedorModelToDto);
    }

    @Override
    public Mono<ProveedorDTO> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p))
                .map(AppUtils::proveedorModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProveedorDTO> update(String id, Mono<ProveedorDTO> proveedorDTO) {
        return this.repository.findById(id)
                .flatMap(p -> proveedorDTO.map(AppUtils::proveedorDtoToModel)
                        .doOnNext(proveedor -> proveedor.setId(id)))
                .flatMap(this.repository::save)
                .map(AppUtils::proveedorModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProveedorDTO> findById(String id) {
        return this.repository.findById(id)
                .map(AppUtils::proveedorModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<ProveedorDTO> findAll() {
        return this.repository.findAll()
                .map(AppUtils::proveedorModelToDto)
                .switchIfEmpty(Flux.empty());
    }
}
