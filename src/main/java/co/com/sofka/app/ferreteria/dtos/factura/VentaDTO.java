package co.com.sofka.app.ferreteria.dtos.factura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private List<CarritoProductoDTO> carrito;
    private String vendedor;
    private String cliente;
}
