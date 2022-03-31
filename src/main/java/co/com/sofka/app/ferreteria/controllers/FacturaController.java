package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.factura.FacturaDTO;
import co.com.sofka.app.ferreteria.dtos.factura.VentaDTO;
import co.com.sofka.app.ferreteria.services.iFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class FacturaController {
    @Autowired
    private iFacturaService service;

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<FacturaDTO> add(@RequestBody Mono<VentaDTO> venta) {
        return this.service.add(venta);
    }

    @DeleteMapping("/factura/{id}")
    public Mono<ResponseEntity<FacturaDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/factura/{id}")
    public Mono<ResponseEntity<FacturaDTO>> update(@PathVariable("id") String id,
                                                   @RequestBody Mono<FacturaDTO> facturaDTO) {
        return this.service.update(id, facturaDTO)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/factura/{id}")
    public Mono<FacturaDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/facturas")
    public Flux<FacturaDTO> findAll() {
        return this.service.findAll();
    }
}
