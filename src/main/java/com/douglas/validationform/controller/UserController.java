package com.douglas.validationform.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.douglas.validationform.model.UserModel;
import com.douglas.validationform.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cadastro")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> listUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable(value = "id") long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserId(id));
    }

    @PostMapping
    public ResponseEntity<Object> newRegister(@RequestBody @Valid UserModel user, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
            List<String> erros = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
                    return ResponseEntity.badRequest().body(erros);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
        }catch(PersistenceException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
 
    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletarCadastro(@PathVariable(value = "cpf") String cpf){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(cpf));
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        
    }

    

}
