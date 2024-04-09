package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/cadastrar-paciente")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
      this.pacienteRepository.save(new Paciente(dados));
    }

    //Listar pacientes ativos
    @GetMapping("/listar-pacientes")
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 10, sort = "id") Pageable page) {
        var listaPacientes = this.pacienteRepository.findAllByAtivoTrue(page).map(DadosListagemPacientes::new);
        return listaPacientes;
    }

    @PutMapping("/atualizar-paciente")
    @Transactional
    public void atulizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformações(dados);
    }

    //Exclusão lógica
    @DeleteMapping("/excluir-paciente/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }

}
