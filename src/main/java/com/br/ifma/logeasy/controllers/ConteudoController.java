package com.br.ifma.logeasy.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.domain.Disciplina;
import com.br.ifma.logeasy.services.ConteudoService;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.DisciplinaService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.ProfessorService;
import com.mysql.jdbc.StringUtils;

@Controller
public class ConteudoController {

    private ConteudoService conteudoService;
    private ProfessorService professorService;
    private CursoService cursoService;
    private NivelService nivelService;
    private DisciplinaService disciplinaService;

    @Autowired
    public void setConteudoService(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }
    
    @Autowired
    public void setDisciplinaService(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
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
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("conteudos", conteudoService.listConteudosByProfessor(professorService.findByUsername(name)));
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
        model.addAttribute("cursos", cursoService.listAllCursos());
        model.addAttribute("niveis", nivelService.listAllNiveis());
        model.addAttribute("disciplinas", new ArrayList<Disciplina>());
        model.addAttribute("curso", new Curso());
        return "conteudo-form";
    }

    @RequestMapping(value = "conteudo", params={"save"}, method = RequestMethod.POST)
    public String saveConteudo(Conteudo conteudo){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        conteudo.setProfessor(professorService.findByUsername(name));
        conteudoService.saveConteudo(conteudo);
        
        return "redirect:/conteudo/show/" + conteudo.getId();
    }

    @RequestMapping("conteudo/delete/{id}")
    public String delete(@PathVariable Integer id){
        conteudoService.deleteConteudo(id);
        return "redirect:/conteudos";
    }
    
    @RequestMapping("/iniciaBuscaConteudo")
    public String iniciaBuscaConteudo(Model model){
        model.addAttribute("disciplinas", disciplinaService.listAllDisciplinas());
        model.addAttribute("cursos", new ArrayList<Curso>());
        model.addAttribute("curso", new Curso());
        return "conteudo-form :: modalSearchCurso";
    }
    
    @RequestMapping(value = "/buscaCursos")
    public String searchCursos(Curso curso, Model model){
    	if(!(curso.getDisciplina() == null)) {
    		model.addAttribute("cursos", cursoService.listCursosByDisciplina(curso.getDisciplina()));
    	}else if(!StringUtils.isEmptyOrWhitespaceOnly(curso.getCodigo())) {
    		model.addAttribute("cursos", cursoService.listCursosByCodigo(curso.getCodigo()));
    	}else if(!StringUtils.isEmptyOrWhitespaceOnly(curso.getNome())) {
    		model.addAttribute("cursos", cursoService.listCursosByNome(curso.getNome()));
    	}        
        return "conteudo-form :: modalSearchCurso";
    }
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
*/
}
