package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
    Mono<Producto> findByNombre(String nombre);
}
