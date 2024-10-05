package com.example.kitchensink.controller;

import com.example.kitchensink.entity.MemberEntity;
import com.example.kitchensink.repository.MemberRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/members")
public class MemberController {

  private final MemberRepository repository;

  public MemberController(MemberRepository repository) {
    this.repository = repository;
  }

  // Get a list of all members
  @GetMapping
  public List<MemberEntity> listAllMembers() {
    return repository.findAll();
  }

  // Get member by ID
  @GetMapping("/{id}")
  public ResponseEntity<MemberEntity> lookupMemberById(@PathVariable("id") String id) {
    MemberEntity memberEntity = repository.findById(id).orElse(null);
    if (memberEntity == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(memberEntity);
  }

  // Create a new member
  /* @PostMapping
  public ResponseEntity<?> createMember(@Valid @RequestBody Member member) {
    try {
      // Register the new member
      registration.registerMember(member);

      // Return success response
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      // Handle generic exceptions
      Map<String, String> responseObj = new HashMap<>();
      responseObj.put("error", e.getMessage());
      return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
    }
  }*/
}
