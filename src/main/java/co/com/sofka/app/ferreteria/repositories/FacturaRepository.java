package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura, String> {
}
