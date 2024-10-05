package com.example.kitchensink.repository;

import com.example.kitchensink.entity.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<MemberEntity, String> {

}
