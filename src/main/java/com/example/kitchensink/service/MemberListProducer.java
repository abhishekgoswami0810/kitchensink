package com.example.kitchensink.service;

import com.example.kitchensink.mapper.MemberMapper;
import com.example.kitchensink.model.Member;
import com.example.kitchensink.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.Getter;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Getter
public class MemberListProducer {

  private final MemberRepository memberRepository;

  private List<Member> members;

  private final MemberMapper memberMapper = MemberMapper.INSTANCE;

  public MemberListProducer(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @PostConstruct
  public void retrieveAllMembersOrderedByName() {
    members = memberMapper.memberEntityListToMemberList(memberRepository.findAll());
  }

  @EventListener
  public void onMemberListChanged(Member member) {
    retrieveAllMembersOrderedByName();
  }
}
