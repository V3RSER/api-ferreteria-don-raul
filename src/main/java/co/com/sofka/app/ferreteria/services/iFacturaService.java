package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.factura.FacturaDTO;
import co.com.sofka.app.ferreteria.dtos.factura.VentaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface iFacturaService {
    Mono<FacturaDTO> add(Mono<VentaDTO> venta);

    Mono<FacturaDTO> delete(String id);

    Mono<FacturaDTO> update(String id, Mono<FacturaDTO> clienteDTO);

    Mono<FacturaDTO> findById(String id);

    Flux<FacturaDTO> findAll();
}