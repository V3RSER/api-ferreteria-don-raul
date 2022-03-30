package co.com.sofka.app.ferreteria.services;

import co.com.sofka.app.ferreteria.dtos.cliente.CarritoProductoDTO;
import co.com.sofka.app.ferreteria.dtos.cliente.ClienteDTO;
import co.com.sofka.app.ferreteria.dtos.cliente.FacturaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface iClienteService {
    Mono<ClienteDTO> add(Mono<ClienteDTO> clienteDTO);

    Mono<ClienteDTO> delete(String id);

    Mono<ClienteDTO> update(String id, Mono<ClienteDTO> clienteDTO);

    Mono<ClienteDTO> findById(String id);

    Mono<ClienteDTO> findByDocumentoIdentidad(String documentoIdentidad);

    Flux<ClienteDTO> findAll();

    Mono<FacturaDTO> generateFactura(String idCliente, String vendedor, Flux<CarritoProductoDTO> productos);

    Flux<FacturaDTO> findAllFacturas();
}