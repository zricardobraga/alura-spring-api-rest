package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
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

      //lista todos os médicos
//    @GetMapping("/listar-medicos")
//    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
//        //esse método retorna uma lista de médicos paginada
//        //o método findAll recebe o atributo page e automaticamente sabe que tem de retornar uma lista paginada
//        var listaMedicos = this.medicoRepository.findAll(page).map(DadosListagemMedicos::new);
//        return listaMedicos;
//    }

    // lista os médicos ativos
    @GetMapping("/listar-medicos")
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        var listaMedicosAtivos = this.medicoRepository.findAllByAtivoTrue(page).map(DadosListagemMedicos::new);
        return listaMedicosAtivos;
    }


    @PutMapping("/atualizar-medico")
    @Transactional
    public void atulizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformações(dados);
    }

    //exclusão física
//    @DeleteMapping("/excluir-medico/{id}")
//    public void excluir(@PathVariable Long id){
//        medicoRepository.deleteById(id);
//    }

    //Exclusão lógica
    @DeleteMapping("/excluir-medico/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }



}
