package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.telefone.DadosTelefone;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        DadosTelefone telefone,
        DadosEndereco endereco) {
}
