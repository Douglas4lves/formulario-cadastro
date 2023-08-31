package com.douglas.validationform;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.douglas.validationform.model.UserModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GeradorCpf geradorCpf;
    
    @Test
    public void createUser(){
        UserModel user = new UserModel();
        user.setName("teste");
        user.setEmail("douglas.alves9905@gmail.com");
        user.setCpf(geradorCpf.gerarCpf(true));
        user.setContact("37999995500");

        Object newUser = restTemplate.postForObject("/cadastro", user, Object.class);

        assertNotNull(newUser);
    }

}
