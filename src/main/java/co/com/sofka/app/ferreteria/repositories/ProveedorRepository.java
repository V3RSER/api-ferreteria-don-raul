package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
    Mono<Proveedor> findByDocumentoIdentidad(String documentoIdentidad);
}
