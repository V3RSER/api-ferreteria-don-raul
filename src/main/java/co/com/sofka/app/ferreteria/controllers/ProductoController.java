package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import co.com.sofka.app.ferreteria.services.iProductoService;
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
    private iProductoService service;

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProductoDTO> add(@RequestBody Mono<ProductoDTO> productoDTO) {
        return this.service.add(productoDTO);
    }

    @DeleteMapping("/producto/{id}")
    public Mono<ResponseEntity<ProductoDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/producto/{id}")
    public Mono<ResponseEntity<ProductoDTO>> update(@PathVariable("id") String id,
                                                    @RequestBody Mono<ProductoDTO> productoDTO) {
        return this.service.update(id, productoDTO)
                .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/producto/{id}/stock")
    public Mono<ResponseEntity<ProductoDTO>> updateStock(@PathVariable("id") String id,
                                                         @RequestBody Integer stock) {
        return this.service.updateStock(id, stock)
                .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/producto/{id}")
    public Mono<ProductoDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/producto/nombre:{nombre}")
    public Mono<ProductoDTO> findByNombre(@PathVariable("document") String nombre) {
        return this.service.findByNombre(nombre);
    }

    @GetMapping("/productos")
    public Flux<ProductoDTO> findAll() {
        return this.service.findAll();
    }

}
