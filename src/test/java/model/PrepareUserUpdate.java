package model;

import utils.FakerMessageGenerator;

public class PrepareUserUpdate {

    public static UpdateUserModel getValidData(){
        return UpdateUserModel.builder()
                .name(FakerMessageGenerator.generateName())
                .job(FakerMessageGenerator.generateJob())
                .build();
    }
}
