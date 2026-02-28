package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.model.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PagedResourcesAssembler<DatosListaPaciente> pagedResourcesAssembler;
    @Autowired
    private DatosListaPacienteModelAssembler datosListaPacienteModelAssembler;
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroPaciente datos, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(datos);
         repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosListaPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<DatosListaPaciente>>> listar(@PageableDefault(page = 0, size = 10, sort = { "nombre" }) Pageable paginacion) {
        Page<DatosListaPaciente> pagina = repository.findAllByActivoTrue(paginacion)
                .map(DatosListaPaciente::new);

        var modelo = pagedResourcesAssembler.toModel(pagina, datosListaPacienteModelAssembler);
        return ResponseEntity.ok(modelo);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionPaciente datos) {
        var paciente = repository.getReferenceById(datos.id());
        paciente.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosListaPaciente(paciente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.desactivar();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosListaPaciente> detallar(@PathVariable Long id){
        var paciente = repository.findById(id).orElseThrow();
        return  ResponseEntity.ok(new DatosListaPaciente(paciente));
    }

}
