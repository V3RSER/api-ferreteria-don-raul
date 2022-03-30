package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
