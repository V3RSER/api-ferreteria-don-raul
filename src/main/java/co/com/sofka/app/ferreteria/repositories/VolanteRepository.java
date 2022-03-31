package co.com.sofka.app.ferreteria.repositories;

import co.com.sofka.app.ferreteria.models.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolanteRepository extends ReactiveMongoRepository<Volante, String> {
}
