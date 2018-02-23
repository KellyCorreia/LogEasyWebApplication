package com.br.ifma.logeasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.DisciplinaService;

@Controller
public class CursoController {

    private CursoService cursoService;
    private DisciplinaService disciplinaService;

    @Autowired
    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @Autowired
    public void setDisciplinaService(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("cursos", cursoService.listAllCursos());
        return "cursos";
    }

    @RequestMapping("curso/show/{id}")
    public String showCurso(@PathVariable Integer id, Model model){
        model.addAttribute("curso", cursoService.getCursoById(id));
        return "curso-show";
    }

    @RequestMapping("curso/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("disciplinas", disciplinaService.listAllDisciplinas());
        return "curso-form";
    }

    @RequestMapping("curso/new")
    public String newCurso(Model model){
    	Curso curso = new Curso();
    	curso.setCodigo("TESTE-XXX");
        model.addAttribute("curso", curso);
        model.addAttribute("disciplinas", disciplinaService.listAllDisciplinas());
        return "curso-form";
    }

    @RequestMapping(value = "curso", method = RequestMethod.POST)
    public String saveCurso(Curso curso){
        cursoService.saveCurso(curso);
        
        return "redirect:/curso/show/" + curso.getId();
    }

    @RequestMapping("curso/delete/{id}")
    public String delete(@PathVariable Integer id){
        cursoService.deleteCurso(id);
        return "redirect:/cursos";
    }
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
*/
}
