package com.example.kitchensink.service;

import com.example.kitchensink.entity.MemberEntity;
import com.example.kitchensink.mapper.MemberMapper;
import com.example.kitchensink.model.Member;
import com.example.kitchensink.repository.MemberRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberRegistrationService {

  private final MemberMapper memberMapper = MemberMapper.INSTANCE;

  private final MemberRepository memberRepository;

  private final ApplicationEventPublisher eventPublisher;

  public MemberRegistrationService(
      MemberRepository memberRepository, ApplicationEventPublisher eventPublisher) {
    this.memberRepository = memberRepository;
    this.eventPublisher = eventPublisher;
  }

  public void registerMember(Member member) {
    log.info("Registering {}", member);
    MemberEntity memberEntity = memberMapper.memberToMemberEntity(member);
    memberRepository.save(memberEntity);
    eventPublisher.publishEvent(member);
  }

  public List<Member> getAllMembers() {
    return memberMapper.memberEntityListToMemberList(memberRepository.findAll());
  }
}
