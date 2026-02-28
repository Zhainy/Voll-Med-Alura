package med.voll.api.model.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.direccion.DatosDireccion;

public record DatosActualizacionMedico(
        @NotNull Long id,
        String nombre,
        String email,
        DatosDireccion direccion
) {
}
