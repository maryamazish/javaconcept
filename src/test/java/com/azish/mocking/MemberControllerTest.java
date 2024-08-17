package com.azish.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {
    @Test
    void signup_Success(@Mock Member member, @Mock MemberRepository memberRepository) {

        Integer id = 1;
        String name = "Jan";

        try (var factory = mockStatic(MemberRepositoryFactory.class);
             var ignored = mockConstruction(MemberService.class, (mock, context) -> {
                         when(mock.register(id, name)).thenReturn(member);
                     }
             )) {
            factory.when(() -> MemberRepositoryFactory.create(anyString(), anyString())).thenReturn(memberRepository);

            MemberController memberController = new MemberController();
            Member newMember = memberController.signup(id, name);

            assertEquals(member,newMember);

        }
    }

    @Test
    void signup_FactoryException_Failed() {

        Integer id = 1;
        String name = "Jan";

        try (var factory = mockStatic(MemberRepositoryFactory.class)) {
            factory.when(() -> MemberRepositoryFactory.create(anyString(), anyString())).thenThrow(RuntimeException.class);

            MemberController memberController = new MemberController();

            assertThrows(RuntimeException.class,()->memberController.signup(id, name));

        }
    }

    @Test
    void signup_RegisterException_Failed( @Mock MemberRepository memberRepository) {

        Integer id = 1;
        String name = "Jan";

        try (var factory = mockStatic(MemberRepositoryFactory.class);
             var ignored = mockConstruction(MemberService.class, (mock, context) -> {
                         when(mock.register(id, name)).thenThrow(RuntimeException.class);
                     }
             )) {
            factory.when(() -> MemberRepositoryFactory.create(anyString(), anyString())).thenReturn(memberRepository);

            MemberController memberController = new MemberController();

            assertThrows(RuntimeException.class,()->memberController.signup(id, name));

        }
    }

}
