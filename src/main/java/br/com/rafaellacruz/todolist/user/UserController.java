package br.com.rafaellacruz.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* Modificadores:
* public: qualquer parte da api pode acessar
* private: algumas restrições
* protected: precisa estar na mesma estrutura de pacote
 **/ 
@RestController
@RequestMapping("/users")
public class UserController {
    // tipo, retorno
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
    System.out.println(userModel.username);
    }   
}
