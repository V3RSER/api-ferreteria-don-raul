package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.volante.CompraDTO;
import co.com.sofka.app.ferreteria.dtos.volante.VolanteDTO;
import co.com.sofka.app.ferreteria.services.iVolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VolanteController {
    @Autowired
    private iVolanteService service;

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<VolanteDTO> add(@RequestBody Mono<CompraDTO> compra) {
        return this.service.add(compra);
    }

    @DeleteMapping("/volante/{id}")
    public Mono<ResponseEntity<VolanteDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/volante/{id}")
    public Mono<ResponseEntity<VolanteDTO>> update(@PathVariable("id") String id,
                                                   @RequestBody Mono<VolanteDTO> volanteDTO) {
        return this.service.update(id, volanteDTO)
                .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/volante/{id}")
    public Mono<VolanteDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/volantes")
    public Flux<VolanteDTO> findAll() {
        return this.service.findAll();
    }
}
