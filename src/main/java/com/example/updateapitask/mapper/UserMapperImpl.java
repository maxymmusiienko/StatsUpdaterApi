package com.example.updateapitask.mapper;

import com.example.updateapitask.dto.RegisterUserRequestDto;
import com.example.updateapitask.dto.UserResponseDto;
import com.example.updateapitask.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl {
  public UserResponseDto toDto(User user) {
    if (user == null) {
      return null;
    }
    UserResponseDto userResponseDto = new UserResponseDto();
    if (user.getId() != null) {
      userResponseDto.setId(user.getId());
    }
    if (user.getEmail() != null) {
      userResponseDto.setEmail(user.getEmail());
    }
    return userResponseDto;
  }

  public User toModel(RegisterUserRequestDto requestDto) {
    if (requestDto == null) {
      return null;
    }
    User user = new User();
    if (requestDto.getEmail() != null) {
      user.setEmail(requestDto.getEmail());
    }
    if (requestDto.getPassword() != null) {
      user.setPassword( requestDto.getPassword() );
    }
    return user;
  }
}
