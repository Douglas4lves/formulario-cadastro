package com.douglas.validationform.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.douglas.validationform.message.Messages;
import com.douglas.validationform.model.UserModel;
import com.douglas.validationform.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SendEmailService sendEmailService;

    public UserModel create(UserModel user){
        listUsers().forEach(userValid ->{
            if(userValid.getCpf().equals(user.getCpf())){
                throw new PersistenceException("CPF já cadastrado");
            };
        });
        LocalDateTime dateTime = LocalDateTime.now();
        user.setCreation_date(dateTime);
        userRepository.save(user);
        sendEmailService.toSend(user.getEmail(), Messages.createTitle(user), Messages.messageToNewUser(user));
        return user;  
        
    }

    public List<UserModel> listUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserId(long id){
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("ID não encontrado: " + id));
    }

    public String deleteUser(String cpf){
        UserModel user = getUserCpf(cpf);

        String emailTemporario = user.getEmail();
        UserModel userTemporario = user;
        userRepository.deleteById(user.getId());
        sendEmailService.toSendDeleteUser(emailTemporario, Messages.createTitleDeleteUSer(userTemporario) , Messages.messageDeleteUser(userTemporario));
        return "Usuario deletado com sucesso";

        
    }

    public Boolean cpfExists(String cpf){
        boolean cpfExists = listUsers().stream()
            .anyMatch(user -> user.getCpf().equals(cpf));
        if(!cpfExists){
            return false;
        }else{
            return true;
        }
    }

    public UserModel getUserCpf(String cpf){
        UserModel user = userRepository.getByCpf(cpf);
        if(user != null){
            return user;
        }else{
            throw new EntityNotFoundException("CPF não encontrado: " + cpf);
        }
    }

}
