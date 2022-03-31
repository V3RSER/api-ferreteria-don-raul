package co.com.sofka.app.ferreteria.dtos.cliente;

import co.com.sofka.app.ferreteria.dtos.factura.FacturaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String id;
    private String nombre;
    private String celular;
    private String documentoIdentidad;
    private Set<FacturaDTO> facturas;
}
