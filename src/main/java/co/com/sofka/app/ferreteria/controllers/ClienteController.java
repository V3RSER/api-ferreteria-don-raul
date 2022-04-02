package co.com.sofka.app.ferreteria.controllers;

import co.com.sofka.app.ferreteria.dtos.ClienteDTO;
import co.com.sofka.app.ferreteria.services.iClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    private iClienteService service;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ClienteDTO> add(@RequestBody Mono<ClienteDTO> clienteDTO) {
        return this.service.add(clienteDTO);
    }

    @DeleteMapping("/cliente/{id}")
    public Mono<ResponseEntity<ClienteDTO>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/cliente/{id}")
    public Mono<ResponseEntity<ClienteDTO>> update(@PathVariable("id") String id,
                                                   @RequestBody Mono<ClienteDTO> clienteDTO) {
        return this.service.update(id, clienteDTO)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/cliente/{id}")
    public Mono<ClienteDTO> findById(@PathVariable("id") String id) {
        return this.service.findById(id);
    }

    @GetMapping("/clientes")
    public Flux<ClienteDTO> findAll() {
        return this.service.findAll();
    }
}
