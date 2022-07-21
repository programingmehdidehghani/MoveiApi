package com.example.movieapi;

public class AppExcutors {

    private static AppExcutors instance;

    public static AppExcutors getInstance(){
        if (instance == null){
            instance = new AppExcutors();
        }
        return instance;
    }

}
