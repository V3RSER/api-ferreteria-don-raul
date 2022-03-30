package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
}
