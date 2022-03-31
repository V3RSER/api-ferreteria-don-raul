package co.com.sofka.app.ferreteria.dtos.factura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    @Id
    private String id;
    private LocalDateTime fecha;
    private String cliente;
    private String vendedor;
    private List<CarritoProductoDTO> productos;
    private Double total;
}
