package co.com.sofka.app.ferreteria.models;

import co.com.sofka.app.ferreteria.dtos.cliente.FacturaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String celular;
    private String documentoIdentidad;
    private Set<FacturaDTO> facturas;
}
