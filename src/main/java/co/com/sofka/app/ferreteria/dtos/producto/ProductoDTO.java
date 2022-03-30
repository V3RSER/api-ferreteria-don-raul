package co.com.sofka.app.ferreteria.dtos.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private ExistenciaDTO existencias;
    private String idProveedor;
    private String nombreProveedor;
}
