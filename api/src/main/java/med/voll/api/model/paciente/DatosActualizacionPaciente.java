package med.voll.api.model.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        @Valid DatosDireccion direccion
) {
}