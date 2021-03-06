package co.com.sofka.app.ferreteria.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String id;
    private String nombre;
    private String celular;
    private String documentoIdentidad;
}
