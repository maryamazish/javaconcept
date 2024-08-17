package com.azish.mocking;

import com.azish.exceptions.MemberException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberService {

    private final MemberRepository memberRepository;
    private final Logger logger;

    public MemberService(MemberRepository memberRepository, Logger logger) {
        this.memberRepository = memberRepository;
        this.logger = logger;
    }

    public Member register(Integer id, String name) {
        try {
            if (this.memberRepository.findById(id) != null) {
                this.logger.log(Level.WARNING, "Id existed ...");
                throw new MemberException("Id is existed ...");
            }
            this.logger.log(Level.INFO, "is registering ...");
            return this.memberRepository.save(new Member(id, name));
        } catch (Exception exception) {
            this.logger.log(Level.SEVERE, "connection exception ...",exception);
            throw exception;
        }
    }

    public void register1(Integer id, String name) {
        try {
            if (this.memberRepository.findById(id) != null) {
                this.logger.log(Level.WARNING, "Id existed ...");
                throw new MemberException("Id is existed ...");
            }
            this.logger.log(Level.INFO, "is registering ...");
            this.memberRepository.save(new Member(id, name));
        } catch (Exception exception) {
            this.logger.log(Level.SEVERE, "connection exception ...",exception);
            throw exception;
        }
    }
}
