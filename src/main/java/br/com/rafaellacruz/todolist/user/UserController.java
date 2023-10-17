package br.com.rafaellacruz.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController indica para o framework que se trata de um controlador Rest, voltado para o 
// desenvolvimento de aplicações web Restful e facilita que nós lidemos com requisições web.

// O objetivo do @RequestMapping é associar um método de controlador a um URL ou a um padrão de URL 
// específico, permitindo que o framework encaminhe solicitações HTTP para o método apropriado com 
// base na URL da solicitação.
@RestController
@RequestMapping("/users")
public class UserController {

    // @Autowired é usada para injetar automaticamente dependências.
    @Autowired
    private IUserRepository userRepository;

    // @PostMapping define uma rota que responde a requisições HTTP POST
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            // @ResponseEntity é uma abstração feita pela String utilizando a classe HttpEntity , 
            // com ela conseguimos customizar códigos de resposta, cabeçalhos (headers) entre diversas 
            // outras possibilidades. Retornos: 
            // Mensagem de erro
            // Status Code (200+, 400+, 500+)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }  
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }   
}
