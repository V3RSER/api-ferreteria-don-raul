package co.com.sofka.app.ferreteria.models;

import co.com.sofka.app.ferreteria.dtos.producto.ExistenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inventario")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private ExistenciaDTO existencias;
    private String idProveedor;
    private String nombreProveedor;
}
