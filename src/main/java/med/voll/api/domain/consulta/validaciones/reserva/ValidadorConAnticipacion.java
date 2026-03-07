package med.voll.api.domain.consulta.validaciones.reserva;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;

import java.time.LocalDateTime;

public class ValidadorConAnticipacion implements ValidadorDeConsultas {

    public void validar(DatosReservaConsulta datos) {
        var fechaConsulta = datos.fecha();
        var fechaActual = LocalDateTime.now();

        if (fechaConsulta.isBefore(fechaActual.plusMinutes(30))) {
            throw new ValidacionException("Las consultas deben ser agendadas con al menos 30 minutos de anticipación.");
        }
    }
}
