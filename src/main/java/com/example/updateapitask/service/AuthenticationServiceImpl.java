package com.example.updateapitask.service;

import com.example.updateapitask.dto.UserLoginRequestDto;
import com.example.updateapitask.dto.UserLoginResponseDto;
import com.example.updateapitask.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private final JwtUtil jwtUtil;
  private final AuthenticationManager authenticationManager;

  @Override
  public UserLoginResponseDto authenticate(UserLoginRequestDto requestDto) {
    final Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(requestDto.getEmail(),
            requestDto.getPassword())
    );

    String token = jwtUtil.generateToken(authentication.getName());
    return new UserLoginResponseDto(token);
  }
}
