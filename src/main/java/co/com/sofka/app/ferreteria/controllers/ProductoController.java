package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.cliente.CarritoProductoDTO;
import co.com.sofka.app.ferreteria.dtos.cliente.ClienteDTO;
import co.com.sofka.app.ferreteria.dtos.cliente.FacturaDTO;
import co.com.sofka.app.ferreteria.services.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private iClienteService service;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ClienteDTO> add(@RequestBody Mono<ClienteDTO> clienteDTO) {
        return this.service.add(clienteDTO);
    }

    @DeleteMapping("/cliente/{id}")
    private Mono<ResponseEntity<ClienteDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/cliente/{id}")
    private Mono<ResponseEntity<ClienteDTO>> update(@PathVariable("id") String id, @RequestBody Mono<ClienteDTO> clienteDTO) {
        return this.service.update(id, clienteDTO)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/cliente/{id}")
    private Mono<ClienteDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/cliente/document:{document}")
    private Mono<ClienteDTO> findByDocumentoIdentidad(@PathVariable("document") String document) {
        return this.service.findByDocumentoIdentidad(document);
    }

    @GetMapping("/clientes")
    private Flux<ClienteDTO> findAll() {
        return this.service.findAll();
    }

    @PostMapping("/cliente/{id}/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<FacturaDTO> generateFactura(@PathVariable("id") String id, @RequestBody String vendedor,
                                             @RequestBody Flux<CarritoProductoDTO> productos) {
        return this.service.generateFactura(id, vendedor, productos);
    }

    @GetMapping("/facturas")
    private Flux<FacturaDTO> findAllFacturas() {
        return this.service.findAllFacturas();
    }
}
