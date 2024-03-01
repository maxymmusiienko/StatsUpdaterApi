package com.example.updateapitask.service;

import com.example.updateapitask.dto.UserLoginRequestDto;
import com.example.updateapitask.dto.UserLoginResponseDto;

public interface AuthenticationService {
  UserLoginResponseDto authenticate(UserLoginRequestDto requestDto);
}
