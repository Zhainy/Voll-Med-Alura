package med.voll.api.model.medico;

import med.voll.api.model.direccion.DatosDireccion;

public record DatosActualizacionMedico(
        Long id,
        String nombre,
        String email,
        DatosDireccion direccion
) {
}
