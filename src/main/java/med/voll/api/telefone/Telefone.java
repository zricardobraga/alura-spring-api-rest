package med.voll.api.telefone;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {
    Integer ddd;
    Integer numero_telefone;

    public Telefone(DadosTelefone dados) {
        this.ddd = dados.ddd();
        this.numero_telefone = dados.numero_telefone();
    }

    public void atualizarInformacoes(DadosTelefone dados) {
        if (dados.ddd() != null) {
            this.ddd = dados.ddd();
        }
        if (dados.numero_telefone() != null) {
            this.numero_telefone = dados.numero_telefone();
        }
    }
}
