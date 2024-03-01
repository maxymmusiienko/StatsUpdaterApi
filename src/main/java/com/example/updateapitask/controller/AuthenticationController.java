package com.example.updateapitask.controller;

import com.example.updateapitask.dto.RegisterUserRequestDto;
import com.example.updateapitask.dto.UserLoginRequestDto;
import com.example.updateapitask.dto.UserLoginResponseDto;
import com.example.updateapitask.dto.UserResponseDto;
import com.example.updateapitask.exception.RegistrationException;
import com.example.updateapitask.service.AuthenticationService;
import com.example.updateapitask.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
  private final UserService userService;
  private final AuthenticationService authenticationService;

  @PostMapping("/login")
  public UserLoginResponseDto login(@RequestBody
                                    @Valid UserLoginRequestDto requestDto) {
    return authenticationService.authenticate(requestDto);
  }

  @PostMapping("/registration")
  public UserResponseDto register(@RequestBody
                                  @Valid RegisterUserRequestDto requestDto)
      throws RegistrationException {
    return userService.register(requestDto);
  }
}
