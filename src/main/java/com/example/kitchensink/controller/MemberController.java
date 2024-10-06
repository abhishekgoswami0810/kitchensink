package com.example.kitchensink.controller;

import com.example.kitchensink.controller.strategy.RegistrationContext;
import com.example.kitchensink.model.Member;
import com.example.kitchensink.service.MemberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class MemberController {

  private final MemberService memberService;

  private final RegistrationContext registrationContext;

  @Autowired
  public MemberController(MemberService memberService, RegistrationContext registrationContext) {
    this.memberService = memberService;
    this.registrationContext = registrationContext;
  }

  /**
   * Displays the registration form and the list of registered members.
   */
  @GetMapping("/members")
  public String showRegistrationForm(Model model, Authentication authentication) {
    model.addAttribute("member", new Member());
    model.addAttribute("members", memberService.getAllMembers());
    return "index";
  }

  /**
   * Handles the registration of a new member.
   */
  @PostMapping("/register")
  public String registerMember(
      @Valid @ModelAttribute("member") Member member,
      @RequestParam(value = "sourcePage", required = false) String source,
      RedirectAttributes redirectAttributes) {

    registrationContext.setStrategy(source);
    return registrationContext.register(member, redirectAttributes);
  }


  /**
   * Displays the login page.
   */
  @GetMapping("/login")
  public String showLoginPage() {
    return "login";
  }


}
