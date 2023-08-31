package com.douglas.validationform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.douglas.validationform.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    public UserModel getByCpf(String cpf);
}
