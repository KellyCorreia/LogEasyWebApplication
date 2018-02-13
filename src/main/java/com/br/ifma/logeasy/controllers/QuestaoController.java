package com.br.ifma.logeasy.controllers;

import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.ifma.logeasy.domain.Alternativa;
import com.br.ifma.logeasy.domain.Conteudo;
import com.br.ifma.logeasy.domain.Questao;
import com.br.ifma.logeasy.services.AlternativaService;
import com.br.ifma.logeasy.services.ConteudoService;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.QuestaoService;

@Controller
public class QuestaoController {

    private QuestaoService questaoService;
    private ConteudoService conteudoService;
    private CursoService cursoService;
    private NivelService nivelService;
    private AlternativaService alternativaService;
    private Iterable<Conteudo> listaConteudos;

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
    
    @Autowired
    public void setAlternativaService(AlternativaService alternativaService) {
        this.alternativaService = alternativaService;
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
    	Questao questao = new Questao();
    	Random rand = new Random();
    	questao.setId(-1 * ((int) rand.nextInt(1000)));
        model.addAttribute("questao", questao);
        this.listaConteudos = conteudoService.listAllConteudos();
        model.addAttribute("conteudos", this.getListaConteudos());
        return "questao-form";
    }

    @RequestMapping(value="/questao", params={"save"}, method = RequestMethod.POST)
    public String saveQuestao(Questao questao){
    	/*if (questao.getAlternativas() != null) {
    		questao.setAlternativas(
    				questao.getAlternativas().stream().map(Alternativa::new).collect(Collectors.toList()));
    	}*/
    	//System.out.println("Alternativa: " + questao.getAlternativas().get(0).getTexto());
        questaoService.saveQuestao(questao);
        
        return "redirect:/questao/show/" + questao.getId();
    }
    
    @RequestMapping(value="/questao", params={"addRow"})
    public String addRow(final Questao questao, final BindingResult bindingResult, Model model) {
    	Alternativa alt = new Alternativa();
    	Random rand = new Random();
    	alt.setId(-1 * ((int) rand.nextInt(1000)));
    	alt.setQuestao(questao);
    	questao.getAlternativas().add(alt);
    	model.addAttribute("conteudos", this.getListaConteudos());
        return "questao-form";
    }
    
    
    @RequestMapping(value="/questao", params={"removeRow"})
    public String removeRow(final Questao questao, final BindingResult bindingResult, final HttpServletRequest req, Model model) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        questao.getAlternativas().remove(rowId.intValue());
        model.addAttribute("conteudos", this.getListaConteudos());
        return "questao-form";
    }
    
 /*   @RequestMapping(value = "alternativa/update/{id}", method = RequestMethod.POST)
	public String addRow(final Questao questao) {
		Alternativa alternativa = new Alternativa();
		alternativa.setQuestao(questao);
		alternativa.setTexto(null);
		alternativa.setValor(false);
		Random rand = new Random();
		alternativa.setId(-1 * ((int) rand.nextInt(1000)));
		questao.getAlternativas().add(alternativa);
		System.out.println("Passou");
		return "questao-form";
	}
    
	@RequestMapping(value = "/alternativa/update/{id}", params = {"removeAlternativa" }, method = RequestMethod.POST)
	public String removeRow(final Questao questao, final HttpServletRequest req) throws Exception {
		final int alternativaId = Integer.parseInt(req.getParameter("removeContactPhone"));
		
		for (Alternativa alternativa : questao.getAlternativas()) {
			if (alternativa.getId().equals(alternativaId)) {
				questao.getAlternativas().remove(alternativa);
				break;
			}
		}
		if (alternativaId > 0)
			
			alternativaService.deleteAlternativa(alternativaId);
		
		return "questao-form";
	}*/

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

	public Iterable<Conteudo> getListaConteudos() {
		return listaConteudos;
	}
    
}
