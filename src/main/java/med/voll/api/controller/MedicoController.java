package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/cadastrar-medico")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        this.medicoRepository.save(new Medico(dados));
    }

//    @GetMapping("/listar-medicos")
//    public List<DadosListagemMedicos> listar(){
//        //O operador "::" é usado para referenciar o método construtor sem precisar criar uma instância da classe DadosListagemMedicos
//        //É o equivalente a (medico) -> new DadosListagemMedicos(medico);
//        var listaMedicos = medicoRepository.findAll().stream().map(DadosListagemMedicos::new).toList();
//        return listaMedicos;
//
//    }

    @GetMapping("/listar-medicos")
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        //esse método retorna uma lista de médicos paginada
        //o método findAll recebe o atributo page e automaticamente sabe que tem de retornar uma lista paginada
        var listaMedicos = this.medicoRepository.findAll(page).map(DadosListagemMedicos::new);
        return listaMedicos;
    }



}
