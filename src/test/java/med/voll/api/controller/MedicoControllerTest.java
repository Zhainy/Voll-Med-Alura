package med.voll.api.controller;

import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.direccion.Direccion;
import med.voll.api.domain.medico.DatosDetalleMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.dto.DatosRegistroMedico;
import med.voll.api.dto.Especialidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DatosRegistroMedico> datosRegistroMedicoJson;

    @Autowired
    private JacksonTester<DatosDetalleMedico> datosDetalleMedicoJson;

    @MockitoBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Debería devolver código http 400 cuando las informaciones son inválidas")
    @WithMockUser
    void registrar_escenario1() throws Exception {
        var response = mvc
                .perform(post("/medicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus())
                .isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
    @Test
    @DisplayName("Debería devolver código http 200 cuando las informaciones son válidas")
    @WithMockUser
    void registrar_escenario2() throws Exception {
        var datosRegistro = new DatosRegistroMedico(
                "Medico",
                "medico@voll.med",
                "976080015",
                "12345678-K",
                Especialidad.CARDIOLOGIA,
                datosDireccion());

        when(repository.save(any())).thenReturn(new Medico(datosRegistro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(datosRegistroMedicoJson.write(datosRegistro).getJson()))
                .andReturn().getResponse();

        var datosDetalle= new DatosDetalleMedico(
                null,
                datosRegistro.nombre(),
                datosRegistro.telefono(),
                datosRegistro.email(),
                datosRegistro.documento(),
                datosRegistro.especialidad(),
                new Direccion(datosRegistro.direccion())
        );
        var jsonEsperado = datosDetalleMedicoJson.write(datosDetalle).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
    private DatosDireccion datosDireccion() {
        return new DatosDireccion(
                "calle falsa",
                "123",
                "casa",
                "barrio",
                "ciudad",
                "1234567",
                "provincia"
        );
    }
}