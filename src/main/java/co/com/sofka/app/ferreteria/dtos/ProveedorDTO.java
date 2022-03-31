package co.com.sofka.app.ferreteria.dtos;

import co.com.sofka.app.ferreteria.dtos.volante.VolanteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private String id;
    private String nombre;
    private String celular;
    private String documentoIdentidad;
    private List<VolanteDTO> volantes;
}
