package co.com.sofka.app.ferreteria.dtos.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExistenciaDTO {
    private Integer actual;
    private Integer minimo;
    private Integer maximo;
}
