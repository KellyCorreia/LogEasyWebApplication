package com.br.ifma.logeasy.bootstrap;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.br.ifma.logeasy.domain.Disciplina;
import com.br.ifma.logeasy.domain.Product;
import com.br.ifma.logeasy.domain.Professor;
import com.br.ifma.logeasy.domain.Role;
import com.br.ifma.logeasy.domain.User;
import com.br.ifma.logeasy.repositories.DisciplinaRepository;
import com.br.ifma.logeasy.repositories.ProductRepository;
import com.br.ifma.logeasy.services.ProfessorService;
import com.br.ifma.logeasy.services.RoleService;
import com.br.ifma.logeasy.services.UserService;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private DisciplinaRepository disciplinaRepository;
    private UserService userService;
    private ProfessorService professorService;
    private RoleService roleService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        //loadDisciplinas();
        //loadUsers();
        //loadProfessores();
        //loadRoles();
        //assignUsersToUserRole();
        //assignUsersToAdminRole();
    }

    private void loadProducts() {
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
    }
    
    private void loadDisciplinas() {
        Disciplina discip1 = new Disciplina();
        discip1.setCodigo("Math0001");
        discip1.setDescricao("Matemática Basica - do 6º ao 9º ano");
        discip1.setNome("Matemática Basica");
        
        disciplinaRepository.save(discip1);

        log.info("Disciplina Salva - id: " + discip1.getId());

        Disciplina discip2 = new Disciplina();
        discip2.setCodigo("Logi0001");
        discip2.setDescricao("Lógica de Programação Básica");
        discip2.setNome("Lógica de Programação");
        
        disciplinaRepository.save(discip2);

        log.info("Disciplina Salva - id: " + discip2.getId());
    }

    private void loadUsers() {
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

    }
    
   private void loadProfessores() {
        /*User user1;
        user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);
        Professor prof1*/
        
        User user2;
        user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        //userService.saveOrUpdate(user2);
        Professor professor = new Professor();
        professor.setCodigo("PRF0001");
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
    }
    
    @SuppressWarnings("unchecked")
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
}


