package co.com.sofka.app.ferreteria.services.impl;

import co.com.sofka.app.ferreteria.dtos.factura.CarritoProductoDTO;
import co.com.sofka.app.ferreteria.dtos.volante.CompraDTO;
import co.com.sofka.app.ferreteria.dtos.volante.VolanteDTO;
import co.com.sofka.app.ferreteria.repositories.VolanteRepository;
import co.com.sofka.app.ferreteria.services.iVolanteService;
import co.com.sofka.app.ferreteria.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class VolanteService implements iVolanteService {
    @Autowired
    private VolanteRepository repository;

    @Override
    public Mono<VolanteDTO> add(Mono<CompraDTO> compra) {
        var volanteDTO = new VolanteDTO();
        return compra
                .map((CompraDTO v) -> {
                    volanteDTO.setFecha(LocalDateTime.now());
                    volanteDTO.setNombreProveedor(v.getNombreProveedor());
                    volanteDTO.setDocumentoIdentidadProveedor(v.getDocumentoIdentidadProveedor());
                    volanteDTO.setProductos(v.getCarrito());
                    volanteDTO.setTotal(v.getCarrito()
                            .stream()
                            .mapToDouble((CarritoProductoDTO p) -> {
                                p.setTotal(p.getProduct().getPrecio() * p.getCantidad());
                                return p.getTotal();
                            }).sum());
                    return volanteDTO;
                })
                .map(AppUtils::volanteDtoToModel)
                .flatMap(this.repository::save)
                .map(AppUtils::volanteModelToDto);
    }

    @Override
    public Mono<VolanteDTO> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p))
                .map(AppUtils::volanteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<VolanteDTO> update(String id, Mono<VolanteDTO> volanteDTO) {
        return this.repository.findById(id)
                .flatMap(p -> volanteDTO.map(AppUtils::volanteDtoToModel)
                        .doOnNext(volante -> volante.setId(id)))
                .flatMap(this.repository::save)
                .map(AppUtils::volanteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<VolanteDTO> findById(String id) {
        return this.repository.findById(id)
                .map(AppUtils::volanteModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<VolanteDTO> findAll() {
        return this.repository.findAll()
                .map(AppUtils::volanteModelToDto)
                .switchIfEmpty(Flux.empty());
    }
}
