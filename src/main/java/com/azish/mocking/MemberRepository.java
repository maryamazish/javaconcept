package com.azish.mocking;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    Map<Integer, Member> db = new HashMap<>();

    public MemberRepository(String host, String port) {
        //try to connect
        if (host.isBlank() || port.isBlank())
            throw new RuntimeException("Connection failed to " + host + ":" + port);
    }

    public Member findById(Integer id) {
        return db.get(id);
    }

    public Member save(Member member) {
        db.put(member.id(), member);
        return member;
    }

    public void delete(Integer id){

    }
}
