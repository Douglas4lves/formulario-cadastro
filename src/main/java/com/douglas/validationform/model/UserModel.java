package com.douglas.validationform.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class UserModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Schema(example = "Rodrigo Goes")
    @NotBlank(message = "Campo nome não pode ser vazio")
    @Column(nullable = false)
    String name;

    @Schema(example = "Rodrigo@gmail.com")
    @Email(message = "E-mail não é válido")
    @Column(nullable = false)
    String email;

    @Schema(example = "04727095009")
    @CPF(message = "CPF não é válido")
    @Column(nullable = false, unique = true)
    String cpf;

    @Schema(example = "37999552626")
    @NotBlank(message = "Campo contato não pode ser vazio")
    @Column(nullable = false)
    String contact;

    @Column(nullable = false)
    LocalDateTime creation_date;

    public UserModel(@NotBlank(message = "Campo nome não pode ser vazio") String name,
            @Email(message = "E-mail não é válido") String email, @CPF(message = "CPF não é válido") String cpf,
            @NotBlank(message = "Campo contato não pode ser vazio") String contact) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.contact = contact;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public LocalDateTime getCreation_date() {
        return creation_date;
    }
    public void setCreation_date(LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }




    

    
}
