package com.azish.generic;


public class StringMapper<S extends String, K extends Integer> {


    public S toString(K input) {
        return (S) String.valueOf(input);
    }

    public K fromString(S input) {
        return (K) Integer.valueOf(input);
    }

    public Boolean check(S input, K input2, Object input3) {
        return (input == null && input2 == null) ? false : true;
    }

}
