package com.br.ifma.logeasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.services.ConteudoService;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.ProfessorService;

@Controller
public class ConteudoController {

    private ConteudoService conteudoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private NivelService nivelService;

    @Autowired
    public void setConteudoService(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }
    
    @Autowired
    public void setProfessorService(ProfessorService professorService) {
        this.professorService = professorService;
    }
    
    @Autowired
    public void setNivelService(NivelService nivelService) {
        this.nivelService = nivelService;
    }
    
    @Autowired
    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @RequestMapping(value = "/conteudos", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("conteudos", conteudoService.listAllConteudos());
        return "conteudos";
    }

    @RequestMapping("conteudo/show/{id}")
    public String showConteudo(@PathVariable Integer id, Model model){
        model.addAttribute("conteudo", conteudoService.getConteudoById(id));
        return "conteudo-show";
    }

    @RequestMapping("conteudo/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("conteudo", conteudoService.getConteudoById(id));
        model.addAttribute("professores", professorService.listAllProfessors());
        model.addAttribute("cursos", cursoService.listAllCursos());
        model.addAttribute("niveis", nivelService.listAllNiveis());
        return "conteudo-form";
    }

    @RequestMapping("conteudo/new")
    public String newConteudo(Model model){
        model.addAttribute("conteudo", new Conteudo());
        model.addAttribute("professores", professorService.listAllProfessors());
        model.addAttribute("cursos", cursoService.listAllCursos());
        model.addAttribute("niveis", nivelService.listAllNiveis());
        return "conteudo-form";
    }

    @RequestMapping(value = "conteudo", method = RequestMethod.POST)
    public String saveConteudo(Conteudo conteudo){
        conteudoService.saveConteudo(conteudo);
        return "redirect:/conteudo/show/" + conteudo.getId();
    }

    @RequestMapping("conteudo/delete/{id}")
    public String delete(@PathVariable Integer id){
        conteudoService.deleteConteudo(id);
        return "redirect:/conteudos";
    }
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
*/
}
