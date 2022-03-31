package co.com.sofka.app.ferreteria.services.impl;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import co.com.sofka.app.ferreteria.repositories.ProductoRepository;
import co.com.sofka.app.ferreteria.services.iProductoService;
import co.com.sofka.app.ferreteria.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoService implements iProductoService {
    @Autowired
    private ProductoRepository repository;

    @Override
    public Mono<ProductoDTO> add(Mono<ProductoDTO> productoDTO) {
        return productoDTO.map(AppUtils::productoDtoToModel)
                .flatMap(this.repository::save)
                .map(AppUtils::productoModelToDto);
    }

    @Override
    public Mono<ProductoDTO> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p))
                .map(AppUtils::productoModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProductoDTO> update(String id, Mono<ProductoDTO> productoDTO) {
        return this.repository.findById(id)
                .flatMap(p -> productoDTO.map(AppUtils::productoDtoToModel)
                        .doOnNext(producto -> producto.setId(id)))
                .flatMap(this.repository::save)
                .map(AppUtils::productoModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProductoDTO> updateStock(String id, Integer stock) {
        return this.repository.findById(id)
                .doOnNext(producto -> producto.getExistencias().setActual(stock))
                .flatMap(this.repository::save)
                .map(AppUtils::productoModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<ProductoDTO> findById(String id) {
        return this.repository.findById(id)
                .map(AppUtils::productoModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<ProductoDTO> findAll() {
        return this.repository.findAll()
                .map(AppUtils::productoModelToDto)
                .switchIfEmpty(Flux.empty());
    }
}
