package com.azish.generic;


import java.util.List;

public class CustomList<T,K extends Integer> {

    private final K defaultCount;

    public CustomList(K defaultCount) {
        this.defaultCount = defaultCount;
    }

    public Integer count(T input){
        if(input instanceof String str1){
            return str1.length();
        }
        else if(input instanceof Number num1){
            return String.valueOf(num1).length();
        }
        else if(input instanceof List<?> list){
            return list.size();
        }
        else if(input instanceof Object[] array){
            return array.length;
        }
        return this.defaultCount;

    }
}
