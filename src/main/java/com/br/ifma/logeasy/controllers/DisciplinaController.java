package com.br.ifma.logeasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Disciplina;
import com.br.ifma.logeasy.services.DisciplinaService;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.ProfessorService;

@Controller
public class DisciplinaController {

    private DisciplinaService disciplinaService;

    @Autowired
    public void setDisciplinaService(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }
    
    @RequestMapping(value = "/disciplinas", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("disciplinas", disciplinaService.listAllDisciplinas());
        return "disciplinas";
    }

    @RequestMapping("disciplina/show/{id}")
    public String showDisciplina(@PathVariable Integer id, Model model){
        model.addAttribute("disciplina", disciplinaService.getDisciplinaById(id));
        return "disciplina-show";
    }

    @RequestMapping("disciplina/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("disciplina", disciplinaService.getDisciplinaById(id));
        return "disciplina-form";
    }

    @RequestMapping("disciplina/new")
    public String newDisciplina(Model model){
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina-form";
    }

    @RequestMapping(value = "disciplina", method = RequestMethod.POST)
    public String saveDisciplina(Disciplina disciplina){
        disciplinaService.saveDisciplina(disciplina);
        
        return "redirect:/disciplina/show/" + disciplina.getId();
    }

    @RequestMapping("disciplina/delete/{id}")
    public String delete(@PathVariable Integer id){
        disciplinaService.deleteDisciplina(id);
        return "redirect:/disciplinas";
    }
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
*/
}
