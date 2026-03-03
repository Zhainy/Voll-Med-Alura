package med.voll.api.domain.consulta.cancelacion;

import med.voll.api.domain.consulta.DatosCancelamientoConsulta;

public interface ValidadorCancelamientoDeConsulta {
    void validar(DatosCancelamientoConsulta datos);
}