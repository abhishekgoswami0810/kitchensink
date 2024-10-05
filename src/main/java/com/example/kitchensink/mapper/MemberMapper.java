package com.example.kitchensink.mapper;

import com.example.kitchensink.entity.MemberEntity;
import com.example.kitchensink.model.Member;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

  MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

  MemberEntity memberToMemberEntity(Member member);

  // Method to map List<MemberEntity> to List<Member>
  List<Member> memberEntityListToMemberList(List<MemberEntity> memberEntities);

  Member memberEntityToMember(MemberEntity memberEntity);
}
