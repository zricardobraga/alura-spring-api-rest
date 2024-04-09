package med.voll.api.medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicos(Medico medico) {
        //esse this abaixo significa que estou chamando o construtor principal (o da linha 3) e definindo aqueles parametros com os
        //dados do objeto Medico recebido como parametro desse construtor
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
