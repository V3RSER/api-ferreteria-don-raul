package co.com.sofka.app.ferreteria.dtos.volante;

import co.com.sofka.app.ferreteria.dtos.factura.CarritoProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private List<CarritoProductoDTO> carrito;
    private String nombreProveedor;
    private String documentoIdentidadProveedor;
}
