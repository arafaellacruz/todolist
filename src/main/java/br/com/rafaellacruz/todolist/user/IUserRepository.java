package br.com.rafaellacruz.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// Contrato do projeto onde representamos os métodos mas não suas implementações
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
}
