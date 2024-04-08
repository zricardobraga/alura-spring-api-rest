package med.voll.api.telefone;

import jakarta.validation.constraints.NotNull;

public record DadosTelefone(
        @NotNull
        Integer ddd,
        @NotNull
        Integer numero_telefone) {

}
