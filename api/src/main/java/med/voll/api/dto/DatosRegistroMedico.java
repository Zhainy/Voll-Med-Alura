package med.voll.api.dto;

import med.voll.api.model.direccion.DatosDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento_identidad,
        Especialidad especialidad,
        DatosDireccion direccion) {
}
