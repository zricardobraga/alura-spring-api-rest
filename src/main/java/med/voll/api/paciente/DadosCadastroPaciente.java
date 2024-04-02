package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.telefone.Telefone;

public record DadosCadastroPaciente(String nome, String email, Telefone telefone, String cpf, DadosEndereco endereco) {
}
