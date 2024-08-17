package com.azish.mocking;

import com.azish.exceptions.MemberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private static Logger logger;

    @Test
    void register_Success(@Mock MemberRepository memberRepository, @Mock Member member) {

        Integer id = 1;
        String name = "Maryam";


        when(memberRepository.findById(anyInt())).thenReturn(null);
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        MemberService memberService = new MemberService(memberRepository, logger);
        Member newMember = memberService.register(id, name);

        //verify(memberRepository,times(2)).findById(id);
        //verify(memberRepository).findById(id);
        //verify(memberRepository,never()).delete(id);
        verify(logger).log(Level.INFO,"is registering ...");

        ArgumentCaptor<Level> acLevel = ArgumentCaptor.forClass(Level.class);
        ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);

        assertNotNull(newMember);
        assertEquals(member , newMember);

    }

    @Test
    void register_Fails(@Mock MemberRepository memberRepository,  @Mock Member member) {

        Integer id = 1;
        String name = "Maryam";


        when(memberRepository.findById(anyInt())).thenReturn(member);
        MemberService memberService = new MemberService(memberRepository, logger);
        assertThrows(MemberException.class,()->memberService.register(id, name));

        verify(logger).log(Level.WARNING,"Id existed ...");
    }

    @Test
    void register_ConnectionException_Fails(@Mock MemberRepository memberRepository,  @Mock Member member) {

        Integer id = 1;
        String name = "Maryam";

        when(memberRepository.findById(anyInt())).thenThrow(new RuntimeException("connection failed"));
        MemberService memberService = new MemberService(memberRepository, logger);
        assertThrows(RuntimeException.class,()->memberService.register(id, name));

        //ArgumentCaptor
        verify(logger).log(Level.SEVERE,"connection exception ...");
    }

    @Test
    void spyTest() {

        Integer id = 1;
        String host = "localhost";
        String port = "3306";

        MemberRepository memberRepository =spy(new MemberRepository(host,port));

        when(memberRepository.findById(id)).thenReturn(null);

        MemberService memberService = new MemberService(memberRepository, logger);
        Member newMember = memberService.register(id, "spy test");


        assertNotNull(newMember);

    }


    @Captor
    ArgumentCaptor<Member> acMember;
    @Test
    void register_Success1(@Mock MemberRepository memberRepository,  @Mock Member member) {

        Integer id = 1;
        String name = "Maryam";


        when(memberRepository.findById(anyInt())).thenReturn(null);
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        MemberService memberService = new MemberService(memberRepository, logger);
        memberService.register1(id, name);

        //روش انوتیشن دار کپچر
        acMember = ArgumentCaptor.forClass(Member.class);
        verify(memberRepository).save(acMember.capture());//ورودی واقعی متد سیو را برمیگرداند نه آبجکت ماک داده شده به متد سیو
        Member newMember = acMember.getValue();

        assertNotNull(newMember);
        assertEquals(id , newMember.id());
        assertEquals(name , newMember.name());



        //روش غیرانوتیشن کپچر
        logger.log(Level.INFO,"is registering ...");
        ArgumentCaptor<Level> acLevel = ArgumentCaptor.forClass(Level.class);
        ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);
        verify(logger,times(2)).log(acLevel.capture(),acString.capture());
        Level level = acLevel.getValue();
        assertEquals(Level.INFO,level);

    }
}
