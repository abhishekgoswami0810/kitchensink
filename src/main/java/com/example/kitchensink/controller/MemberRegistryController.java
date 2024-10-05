package com.example.kitchensink.controller;

import com.example.kitchensink.model.Member;
import com.example.kitchensink.service.MemberRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MemberRegistryController {

  private final MemberRegistrationService memberRegistrationService;

  public MemberRegistryController(MemberRegistrationService memberRegistrationService) {
    this.memberRegistrationService = memberRegistrationService;
  }

  public void register(Member member) {
    try {
      memberRegistrationService.registerMember(member);
      //member.initNewMember();
    } catch (Exception e) {
      String errorMessage = getRootErrorMessage(e);
      log.error(errorMessage);
    }
  }

  // Utility method to extract the root cause message from an exception
  private String getRootErrorMessage(Exception e) {
    String errorMessage = "Registration failed. See server log for more information";
    if (e == null) {
      return errorMessage;
    }
    Throwable t = e;
    while (t.getCause() != null) {
      t = t.getCause();
    }
    return t.getLocalizedMessage();
  }
}
