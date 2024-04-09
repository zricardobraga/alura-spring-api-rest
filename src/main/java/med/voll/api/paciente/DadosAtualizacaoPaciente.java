package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.telefone.DadosTelefone;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        DadosTelefone telefone,
        DadosEndereco endereco) {
}
