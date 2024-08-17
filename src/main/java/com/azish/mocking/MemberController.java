package com.azish.mocking;

import java.util.logging.LogManager;

public class MemberController {

    public Member signup(Integer id, String name) {

        MemberRepository memberRepository = MemberRepositoryFactory.create("localhost", "3306");

        MemberService memberService = new MemberService(memberRepository, LogManager.getLogManager().getLogger("Member"));
        return memberService.register(id, name);

    }
}
