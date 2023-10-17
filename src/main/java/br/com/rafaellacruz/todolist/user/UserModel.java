package br.com.rafaellacruz.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// @Data define ambos getters e setters dos atributos
// @Getter define apenas os getters dos atributos
// @Setter define apenas os setters dos atributos
@Data
@Entity(name="tb_users")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private  UUID ID;

    // Modificadores de acesso:
    // Public deixa visível tudo onde ele está aplicado para todas as classes em qualquer pacote
    // Private deixa tudo invisível a tudo que está fora da classe
    // Protected deixa visível para o todas as classes dentro do mesmo pacote  
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Getters e setters são usados para proteger seus dados, especialmente na criação de classes. 
    // Para cada instância de variável, um método getter retorna seu valor, enquanto um método setter o define ou atualiza.

}
