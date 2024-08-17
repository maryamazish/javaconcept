package com.azish.enumpractice;

public class EnumPractice {
    public static void main(String[] args) {
        EnglishLevel englishLevel = EnglishLevel.BEGINNER;
        System.out.println(englishLevel.getKey());
        System.out.println(englishLevel.getValue());
        englishLevel =EnglishLevel.valueOf("PRE_INTERMEDIATE");
        System.out.println("-------------");
        System.out.println(englishLevel.getKey());
        System.out.println(englishLevel.getValue());
        System.out.println(englishLevel.getActive());
        System.out.println(EnglishLevel.ADVANCED.getActive());
    }
    public void main() {

    }
}
