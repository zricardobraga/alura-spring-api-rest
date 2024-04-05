package med.voll.api.telefone;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosTelefone(
        @NotNull
        Integer ddd,
        @NotNull
        Integer numeroTelefone) {

}
