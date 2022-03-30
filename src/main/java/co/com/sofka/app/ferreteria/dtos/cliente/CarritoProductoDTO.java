package co.com.sofka.app.ferreteria.dtos.cliente;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoProductoDTO {
    private ProductoDTO producto;
    private Integer cantidad;
}
