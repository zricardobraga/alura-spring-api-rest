package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagemPacientes;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
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

    @GetMapping("/listar-pacientes")
    public Page<DadosListagemPacientes> listar(@PageableDefault(size = 10, sort = "nome") Pageable page) {
        var listaPacientes = this.pacienteRepository.findAll(page).map(DadosListagemPacientes::new);
        return listaPacientes;
    }

}
