package com.azish.generic;

import java.util.List;

public class StringUtils {

    public static <S extends String, K extends Integer, N> S print(K input,N input2) {
        System.out.println(input2);
        return (S) String.valueOf(input);
    }

//    public static List<? extends String> printListWildCard(List<? extends Number> list){
//        System.out.println(list);
//    }

    public static <S extends String, K extends Integer, N> S print(K input,N input2,K input3 , K input4) {
        System.out.println(input2);
        return (S) String.valueOf(input);
    }
//
//    public static <S extends String, ? extends Integer, N> S print(? input,N input2,? input3 , ? input4) {
//        System.out.println(input2);
//        return (S) String.valueOf(input);
//    }
}
