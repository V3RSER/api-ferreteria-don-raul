package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
