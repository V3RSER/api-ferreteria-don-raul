package co.com.sofka.app.ferreteria.dtos.volante;

import co.com.sofka.app.ferreteria.dtos.factura.CarritoProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolanteDTO {
    private String id;
    private LocalDateTime fecha;
    private String nombreProveedor;
    private String documentoIdentidadProveedor;
    private List<CarritoProductoDTO> productos;
    private Double total;
}
