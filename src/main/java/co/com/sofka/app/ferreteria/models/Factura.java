package co.com.sofka.app.ferreteria.models;

import co.com.sofka.app.ferreteria.dtos.factura.CarritoProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "facturas")
public class Factura {
    @Id
    private String id;
    private LocalDateTime fecha;
    private String cliente;
    private String vendedor;
    private List<CarritoProductoDTO> productos;
    private Double total;
}
