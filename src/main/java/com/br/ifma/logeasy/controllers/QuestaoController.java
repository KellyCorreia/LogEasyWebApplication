package com.br.ifma.logeasy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Questao;
import com.br.ifma.logeasy.services.QuestaoService;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.ConteudoService;

@Controller
public class QuestaoController {

    private QuestaoService questaoService;
    private ConteudoService conteudoService;
    private CursoService cursoService;
    private NivelService nivelService;

    @Autowired
    public void setQuestaoService(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }
    
    @Autowired
    public void setConteudoService(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }
    
    @Autowired
    public void setNivelService(NivelService nivelService) {
        this.nivelService = nivelService;
    }
    
    @Autowired
    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @RequestMapping(value = "/questoes", method = RequestMethod.GET)
    public String list(Model model){
    	//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //String name = auth.getName();
        model.addAttribute("questoes", questaoService.listAllQuestoes());
        return "questoes";
    }

    @RequestMapping("questao/show/{id}")
    public String showQuestao(@PathVariable Integer id, Model model){
        model.addAttribute("questao", questaoService.getQuestaoById(id));
        return "questao-show";
    }

    @RequestMapping("questao/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("questao", questaoService.getQuestaoById(id));
        model.addAttribute("conteudos", conteudoService.listAllConteudos());
        return "questao-form";
    }

    @RequestMapping("questao/new")
    public String newQuestao(Model model){
        model.addAttribute("questao", new Questao());
        model.addAttribute("conteudos", conteudoService.listAllConteudos());
        return "questao-form";
    }

    @RequestMapping(value = "questao", method = RequestMethod.POST)
    public String saveQuestao(Questao questao){
        questaoService.saveQuestao(questao);
        
        return "redirect:/questao/show/" + questao.getId();
    }

    @RequestMapping("questao/delete/{id}")
    public String delete(@PathVariable Integer id){
        questaoService.deleteQuestao(id);
        return "redirect:/questoes";
    }
    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
         return "login";
    }
*/
}
