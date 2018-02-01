package com.br.ifma.logeasy.bootstrap;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.br.ifma.logeasy.domain.Ambiente;
import com.br.ifma.logeasy.domain.Curso;
import com.br.ifma.logeasy.domain.Disciplina;
import com.br.ifma.logeasy.domain.Nivel;
import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.domain.Role;
import com.br.ifma.logeasy.domain.User;
import com.br.ifma.logeasy.repositories.DisciplinaRepository;
import com.br.ifma.logeasy.repositories.ProductRepository;
import com.br.ifma.logeasy.services.CursoService;
import com.br.ifma.logeasy.services.NivelService;
import com.br.ifma.logeasy.services.ProfessorService;
import com.br.ifma.logeasy.services.RoleService;
import com.br.ifma.logeasy.services.UserService;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private DisciplinaRepository disciplinaRepository;
    private NivelService nivelService;
    private UserService userService;
    private CursoService cursoService;
    private ProfessorService professorService;
    private RoleService roleService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Autowired
    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @Autowired
    public void setNivelService(NivelService nivelService) {
        this.nivelService = nivelService;
    }
    
    @Autowired
    public void setProfessorService(ProfessorService professorService) {
        this.professorService = professorService;
    }
    
    @Autowired
    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProfessores();
        loadRoles();
        assignUsersToAdminRole();
        loadDisciplinas();
        loadAmbientesNiveis();
        loadCursos();
    }
    
    private void loadProfessores() {
    	User user1;
        user1 = new User();
        user1.setUsername("camilaprof");
        user1.setPassword("camilaprof");
        Professor prof1 = new Professor();
        prof1.setCodigo("PROF001");
        prof1.setNome("Camila Prof");
        prof1.setUsuario(user1);
        professorService.saveProfessor(prof1);
        
        User user2;
        user2 = new User();
        user2.setUsername("mariaprof");
        user2.setPassword("mariaprof");
        Professor professor = new Professor();
        professor.setCodigo("PROF002");
        professor.setNome("Maria Prof");
        professor.setUsuario(user2);
        professorService.saveProfessor(professor);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }
    
    @SuppressWarnings("unchecked")
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().endsWith("prof")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
    
    private void loadDisciplinas() {
        
        Disciplina discip2 = new Disciplina();
        discip2.setCodigo("MATH001");
        discip2.setDescricao("Matemática Básica - 6º ao 9º ano");
        discip2.setNome("Matemática 01");
        
        disciplinaRepository.save(discip2);

        log.info("Disciplina Salva - id: " + discip2.getId());
    }
    
    private void loadAmbientesNiveis() {
    	Ambiente amb = new Ambiente();
    	amb.setDescricao("Dominação do Ar: Poder dos Ventos");
    	amb.setElemento("Ar");
    	amb.setObjetivo("Conquistar o poder dos ventos");
    	Nivel niv = new Nivel();
    	niv.setOrdem(1);
    	niv.setDescricao("Nível 01");
    	niv.setPontosQuestaoDefault(10);
    	niv.setQtdPontosInicial(0);
    	niv.setQtdPontosFinal(50);
    	niv.setAmbiente(amb);
    	nivelService.saveNivel(niv);
    	
    	
    	Ambiente amb2 = new Ambiente();
    	amb2.setDescricao("Dominação do Ar: Poder do Som");
    	amb2.setElemento("Ar");
    	amb2.setObjetivo("Conquistar o poder do Som");
    	Nivel niv2 = new Nivel();
    	niv2.setOrdem(2);
    	niv2.setDescricao("Nível 02");
    	niv2.setPontosQuestaoDefault(10);
    	niv2.setQtdPontosInicial(50);
    	niv2.setQtdPontosFinal(100);
    	niv2.setAmbiente(amb2);
    	nivelService.saveNivel(niv2);
    	
    	
    	Ambiente amb3 = new Ambiente();
    	amb3.setDescricao("Dominação da Terra: Poder do Metal");
    	amb3.setElemento("Terra");
    	amb3.setObjetivo("Conquistar o poder do Metal");
    	Nivel niv3 = new Nivel();
    	niv3.setOrdem(3);
    	niv3.setDescricao("Nível 03");
    	niv3.setPontosQuestaoDefault(10);
    	niv3.setQtdPontosInicial(100);
    	niv3.setQtdPontosFinal(150);
    	niv3.setAmbiente(amb3);
    	nivelService.saveNivel(niv3);
    	
    	
    	Ambiente amb4 = new Ambiente();
    	amb4.setDescricao("Dominação da Terra: Poder da Areia");
    	amb4.setElemento("Terra");
    	amb4.setObjetivo("Conquistar o poder da Areia");
    	Nivel niv4 = new Nivel();
    	niv4.setOrdem(4);
    	niv4.setDescricao("Nível 04");
    	niv4.setPontosQuestaoDefault(10);
    	niv4.setQtdPontosInicial(150);
    	niv4.setQtdPontosFinal(200);
    	niv4.setAmbiente(amb4);
    	nivelService.saveNivel(niv4);
    	
    	
      	Ambiente amb5 = new Ambiente();
    	amb5.setDescricao("Dominação da Àgua: Poder da Neve");
    	amb5.setElemento("Agua");
    	amb5.setObjetivo("Conquistar o poder da Neve");
       	Nivel niv5 = new Nivel();
    	niv5.setOrdem(5);
    	niv5.setDescricao("Nível 05");
    	niv5.setPontosQuestaoDefault(10);
    	niv5.setQtdPontosInicial(200);
    	niv5.setQtdPontosFinal(250);
    	niv5.setAmbiente(amb5);
    	nivelService.saveNivel(niv5);
    	
    	
      	Ambiente amb6 = new Ambiente();
    	amb6.setDescricao("Dominação da Terra: Poder das Plantas");
    	amb6.setElemento("Agua");
    	amb6.setObjetivo("Conquistar o poder das Plantas");
       	Nivel niv6 = new Nivel();
    	niv6.setOrdem(6);
    	niv6.setDescricao("Nível 06");
    	niv6.setPontosQuestaoDefault(10);
    	niv6.setQtdPontosInicial(250);
    	niv6.setQtdPontosFinal(300);
    	niv6.setAmbiente(amb6);
    	nivelService.saveNivel(niv6);
    	
    	
      	Ambiente amb7 = new Ambiente();
    	amb7.setDescricao("Dominação do Fogo: Poder do Relâmpago");
    	amb7.setElemento("Fogo");
    	amb7.setObjetivo("Conquistar o poder do Relâmpago");
       	Nivel niv7 = new Nivel();
    	niv7.setOrdem(7);
    	niv7.setDescricao("Nível 07");
    	niv7.setPontosQuestaoDefault(10);
    	niv7.setQtdPontosInicial(300);
    	niv7.setQtdPontosFinal(350);
    	niv7.setAmbiente(amb7);
    	nivelService.saveNivel(niv7);
    	
    	
      	Ambiente amb8 = new Ambiente();
    	amb8.setDescricao("Dominação do Fogo: Poder da Lava");
    	amb8.setElemento("Fogo");
    	amb8.setObjetivo("Conquistar o poder da Lava");
       	Nivel niv8 = new Nivel();
    	niv8.setOrdem(8);
    	niv8.setDescricao("Nível 08");
    	niv8.setPontosQuestaoDefault(10);
    	niv8.setQtdPontosInicial(350);
    	niv8.setQtdPontosFinal(400);
    	niv8.setAmbiente(amb8);
    	nivelService.saveNivel(niv8);
    	
    	
      	Ambiente amb9 = new Ambiente();
    	amb9.setDescricao("Elementos em Ação: Cidade das Sombras");
    	amb9.setElemento("Todos");
    	amb9.setObjetivo("Usar os poderes para defender sua cidade");
       	Nivel niv9 = new Nivel();
    	niv9.setOrdem(9);
    	niv9.setDescricao("Nível 9");
    	niv9.setPontosQuestaoDefault(10);
    	niv9.setQtdPontosInicial(400);
    	niv9.setQtdPontosFinal(450);
    	niv9.setAmbiente(amb9);
    	nivelService.saveNivel(niv9);
    	
    	
      	Ambiente amb10 = new Ambiente();
    	amb10.setDescricao("Elementos em Ação: Salve o Mundo");
    	amb10.setElemento("Todos");
    	amb10.setObjetivo("Usar os poderes para salvar o mundo");
    	Nivel niv10 = new Nivel();
    	niv10.setOrdem(10);
    	niv10.setDescricao("Nível 10");
    	niv10.setPontosQuestaoDefault(10);
    	niv10.setQtdPontosInicial(450);
    	niv10.setQtdPontosFinal(500);
    	niv10.setAmbiente(amb10);
    	nivelService.saveNivel(niv10);
    	
    }
    
    private void loadCursos() {
    	Disciplina discip1 = new Disciplina();
        discip1.setCodigo("LOG001");
        discip1.setDescricao("Introdução à Lógica e Algoritmos");
        discip1.setNome("Lógica e Algoritmos");
        
    	Curso curso1 = new Curso();
    	curso1.setCodigo("LOG001");
    	curso1.setNome("Lógica Proposicional");
    	curso1.setDescricao("Curso básico de Lógica Proposicional");
    	curso1.setDisciplina(discip1);
    	cursoService.saveCurso(curso1);
    }

 /*   private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }*/

 /*   private void loadUsers() {
        User user1;
        user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2;
        user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

    }*/
    
/*    @SuppressWarnings("unchecked")
	private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }*/
    
}


