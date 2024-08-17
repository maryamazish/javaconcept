package com.azish.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberRepositoryTest {



    @Test
    void findById_Success(@Mock Member member) {

        Integer id = 1;
        String host = "localhost";
        String port = "3306";

        MemberRepository memberRepository = new MemberRepository(host,port);

        when(member.id()).thenReturn(id);
        memberRepository.save(member);
        Member newMember = memberRepository.findById(id);

        assertEquals(member , newMember);

    }


    @Test
    void save_Success(@Mock Member member) {

        Integer id = 1;
        String host = "localhost";
        String port = "3306";

        MemberRepository memberRepository = new MemberRepository(host,port);

        when(member.id()).thenReturn(id);
        Member newMember = memberRepository.save(member);

        assertEquals(member , newMember);

    }

}
