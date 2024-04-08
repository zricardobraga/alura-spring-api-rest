package med.voll.api.paciente;

public record DadosListagemPacientes(String nome, String email) {
    public DadosListagemPacientes (Paciente paciente){
        this(paciente.getNome(), paciente.getEmail());
    }
}
