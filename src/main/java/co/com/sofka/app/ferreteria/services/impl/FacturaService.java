package co.com.sofka.app.ferreteria.services.impl;

import co.com.sofka.app.ferreteria.dtos.factura.CarritoProductoDTO;
import co.com.sofka.app.ferreteria.dtos.factura.FacturaDTO;
import co.com.sofka.app.ferreteria.dtos.factura.VentaDTO;
import co.com.sofka.app.ferreteria.repositories.FacturaRepository;
import co.com.sofka.app.ferreteria.services.iFacturaService;
import co.com.sofka.app.ferreteria.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class FacturaService implements iFacturaService {
    @Autowired
    private FacturaRepository repository;

    @Override
    public Mono<FacturaDTO> add(Mono<VentaDTO> venta) {
        var facturaDTO = new FacturaDTO();
        return venta
                .map((VentaDTO v) -> {
                    facturaDTO.setFecha(LocalDateTime.now());
                    facturaDTO.setVendedor(v.getVendedor());
                    facturaDTO.setCliente(v.getCliente());
                    facturaDTO.setCliente(facturaDTO.getCliente());
                    facturaDTO.setProductos(v.getCarrito());
                    facturaDTO.setTotal(v.getCarrito()
                            .stream()
                            .mapToDouble((CarritoProductoDTO p) -> {
                                p.setTotal(p.getProducto().getPrecio() * p.getCantidad());
                                return p.getTotal();
                            }).sum());
                    return facturaDTO;
                })
                .map(AppUtils::facturaDtoToModel)
                .flatMap(this.repository::save)
                .map(AppUtils::facturaModelToDto);
    }

    @Override
    public Mono<FacturaDTO> delete(String id) {
        return this.repository
                .findById(id)
                .flatMap(p -> this.repository.deleteById(p.getId()).thenReturn(p))
                .map(AppUtils::facturaModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<FacturaDTO> update(String id, Mono<FacturaDTO> facturaDTO) {
        return this.repository.findById(id)
                .flatMap(p -> facturaDTO.map(AppUtils::facturaDtoToModel)
                        .doOnNext(factura -> factura.setId(id)))
                .flatMap(this.repository::save)
                .map(AppUtils::facturaModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<FacturaDTO> findById(String id) {
        return this.repository.findById(id)
                .map(AppUtils::facturaModelToDto)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<FacturaDTO> findAll() {
        return this.repository.findAll()
                .map(AppUtils::facturaModelToDto)
                .switchIfEmpty(Flux.empty());
    }
}
