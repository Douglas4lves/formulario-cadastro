package com.douglas.validationform.message;

import com.douglas.validationform.model.UserModel;

public class Messages {

    public static String createTitle(UserModel user){
        return user.getName() + ", seu cadastro foi recebido!";
    }

    public static String createTitleDeleteUSer (UserModel user){
        return user.getName() + ", sua solicitação foi recebida!";
    }

    public static String messageToNewUser(UserModel user){
        return "Olá, " + user.getName()
        +"! Seja bem-vindo(a), se você recebeu esse e-mail, "
        +"significa que a api ainda está em funcionamento!";
    }

    public static String messageDeleteUser(UserModel user){
        return "Olá, " + user.getName()
        +", soube que deseja apagar seu cadastro! "
        +"Não se preocupe, seus dados foram deletados com sucesso!";
    }
    
}
