package co.com.sofka.app.ferreteria.dtos.cliente;

import co.com.sofka.app.ferreteria.dtos.producto.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    @Id
    private String id;
    private LocalDate fecha;
    private String cliente;
    private String vendedor;
    private List<ProductoDTO> productos;
    private Double total;
}
