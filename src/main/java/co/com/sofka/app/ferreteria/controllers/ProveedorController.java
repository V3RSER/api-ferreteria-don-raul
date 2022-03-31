package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.ProveedorDTO;
import co.com.sofka.app.ferreteria.services.iProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private iProveedorService service;

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProveedorDTO> add(@RequestBody Mono<ProveedorDTO> proveedorDTO) {
        return this.service.add(proveedorDTO);
    }

    @DeleteMapping("/proveedor/{id}")
    public Mono<ResponseEntity<ProveedorDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/proveedor/{id}")
    public Mono<ResponseEntity<ProveedorDTO>> update(@PathVariable("id") String id,
                                                     @RequestBody Mono<ProveedorDTO> proveedorDTO) {
        return this.service.update(id, proveedorDTO)
                .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/proveedor/{id}")
    public Mono<ProveedorDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/proveedors")
    public Flux<ProveedorDTO> findAll() {
        return this.service.findAll();
    }

}
