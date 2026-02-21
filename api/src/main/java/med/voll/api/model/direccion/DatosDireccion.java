package med.voll.api.model.direccion;

public record DatosDireccion(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String ciudad,
        String codigo_postal,
        String provincia){
}
