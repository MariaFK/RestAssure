package model;

import utils.FakerMessageGenerator;

public class PrepareRegisterUserDate {

    public static RegisterUserModel getValidData(){
        return RegisterUserModel.builder()
                .email("eve.holt@reqres.in")
                .password(FakerMessageGenerator.generatePassword())
                .build();
    }
}

