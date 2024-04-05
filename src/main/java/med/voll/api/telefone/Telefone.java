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
    Integer numeroTelefone;

    public Telefone(DadosTelefone dados) {
        this.ddd = dados.ddd();
        this.numeroTelefone = dados.numeroTelefone();
    }
}
