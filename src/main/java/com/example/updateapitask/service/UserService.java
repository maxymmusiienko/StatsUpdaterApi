package com.example.updateapitask.service;

import com.example.updateapitask.dto.RegisterUserRequestDto;
import com.example.updateapitask.dto.UserResponseDto;

public interface UserService {
  UserResponseDto register(RegisterUserRequestDto requestDto);
}
