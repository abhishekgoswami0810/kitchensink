package com.example.kitchensink.controller;

import com.example.kitchensink.model.Member;
import com.example.kitchensink.service.MemberRegistrationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ThymeleafController {

  private final MemberRegistrationService memberRegistrationService;

  @Autowired
  public ThymeleafController(MemberRegistrationService memberRegistrationService) {
    this.memberRegistrationService = memberRegistrationService;
  }

  /** Displays the registration form and the list of registered members. */
  @GetMapping("/members")
  public String showRegistrationForm(Model model) {
    model.addAttribute("member", new Member());
    model.addAttribute("members", memberRegistrationService.getAllMembers());
    return "index";
  }

  /** Handles the registration of a new member. */
  @PostMapping("/register")
  public String registerMember(
      @Valid @ModelAttribute("member") Member member,
      BindingResult bindingResult,
      Model model,
      RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      // If validation errors exist, return to the registration form with error messages
      model.addAttribute("members", memberRegistrationService.getAllMembers());
      return "index";
    }

    try {
      // Register the member using the service
      memberRegistrationService.registerMember(member);

      // Set flash attributes for success message
      redirectAttributes.addFlashAttribute("registrationSuccess", true);
      redirectAttributes.addFlashAttribute("successMessage", "Member successfully registered!");

    } catch (Exception e) {
      String errorMessage = getRootErrorMessage(e);
      log.error(errorMessage);

      // Add an error message to the model
      redirectAttributes.addFlashAttribute("registrationError", true);
      redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
    }
    return "redirect:/members";
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
