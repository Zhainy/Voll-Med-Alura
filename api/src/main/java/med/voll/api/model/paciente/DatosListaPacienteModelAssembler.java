package med.voll.api.model.paciente;

import lombok.NonNull;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DatosListaPacienteModelAssembler implements RepresentationModelAssembler<DatosListaPaciente, EntityModel<DatosListaPaciente>> {
    public EntityModel<DatosListaPaciente> toModel(@NonNull DatosListaPaciente datosListaPaciente) {
        return EntityModel.of(datosListaPaciente);
    }
}
