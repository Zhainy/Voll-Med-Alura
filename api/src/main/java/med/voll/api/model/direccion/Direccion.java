package med.voll.api.model.direccion;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.medico.DatosActualizacionMedico;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String ciudad;
    private String codigo_postal;
    private String provincia;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.ciudad = datosDireccion.ciudad();
        this.codigo_postal = datosDireccion.codigo_postal();
        this.provincia = datosDireccion.provincia();
    }

    public void actualizarDireccion(DatosDireccion datos) {
        if (datos.calle() != null) {
            this.calle = datos.calle();
        }
        if (datos.numero() != null) {
            this.numero = datos.numero();
        }
        if (datos.complemento() != null) {
            this.complemento = datos.complemento();
        }
        if (datos.barrio() != null) {
            this.barrio = datos.barrio();
        }
        if (datos.ciudad() != null) {
            this.ciudad = datos.ciudad();
        }
        if (datos.codigo_postal() != null) {
            this.codigo_postal = datos.codigo_postal();
        }
        if (datos.provincia() != null) {
            this.provincia = datos.provincia();
        }
    }
}
