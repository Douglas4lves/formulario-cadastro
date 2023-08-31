package com.douglas.validationform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.douglas.validationform.model.UserModel;
import com.douglas.validationform.service.UserService;

import jakarta.persistence.PersistenceException;

@SpringBootTest
public class UserServiceTest {
    
    @Autowired
    private UserService userService;

    @Autowired
    private GeradorCpf geradorCpf;

    @Test
    public void createUser_ReturnUsers(){
        UserModel user = new UserModel();
        user.setName("teste");
        user.setEmail("teste@gmail.com");
        user.setCpf(geradorCpf.gerarCpf(true));
        user.setContact("37999995500");
        
        UserModel newUser = userService.create(user);

        //JUNIT
        assertNotNull(user, "Usuário não pode ser null");
        assertEquals(user.getName(), newUser.getName(), "Nome não é igual a nome criado");
        assertEquals(user.getEmail(), newUser.getEmail(), "Email não é igual a Email criado");
        assertEquals(user.getCpf(), newUser.getCpf(), "CPF não é igual a CPF criado");
        assertEquals(user.getContact(), newUser.getContact(), "Contato não é igual a contato criado");
    }

    @Test
    public void createUser_ThrowsPersistenceException(){
        UserModel user = new UserModel();
        user.setName("teste");
        user.setEmail("teste@gmail.com");
        user.setCpf("40674766040");
        user.setContact("37999995500");

        //JUNIT
        assertThrows(PersistenceException.class , () -> userService.create(user));
    }
}
