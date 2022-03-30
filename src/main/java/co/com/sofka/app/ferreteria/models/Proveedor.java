package co.com.sofka.app.ferreteria.models;

import co.com.sofka.app.ferreteria.dtos.VolanteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "proveedores")
public class Proveedor {
    @Id
    private String id;
    private String nombre;
    private String celular;
    private String documentoIdentidad;
    private List<VolanteDTO> volantes;
}
