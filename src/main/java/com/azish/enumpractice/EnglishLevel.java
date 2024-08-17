package com.azish.enumpractice;

public enum EnglishLevel {
    BEGINNER(1 ,"beginner",true),
    PRE_INTERMEDIATE(2,"pre intermediate",false),
    INTERMEDIATE(3,"intermediate",true),
    ADVANCED(4,"advanced",false)

    ;

    private final int  key;
    private final String  value;
    private final Boolean active;

    EnglishLevel(int key, String value, Boolean active) {
        this.key = key;
        this.value = value;
        this.active = active;
    }


    public int getKey(){
        return this.key;
    }

    public String getValue(){
        return this.value;
    }

    public Boolean getActive(){
        return this.active;
    }
}
