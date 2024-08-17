package com.azish.mocking;

public class MemberRepositoryFactory {

    private MemberRepositoryFactory() {
    }

    public static MemberRepository create(String host, String port){
        return new MemberRepository(host, port);
    }
}
