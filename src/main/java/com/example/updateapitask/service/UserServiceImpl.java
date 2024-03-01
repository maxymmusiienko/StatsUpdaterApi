package com.example.updateapitask.service;

import com.example.updateapitask.dto.RegisterUserRequestDto;
import com.example.updateapitask.dto.UserResponseDto;
import com.example.updateapitask.exception.RegistrationException;
import com.example.updateapitask.mapper.UserMapperImpl;
import com.example.updateapitask.model.User;
import com.example.updateapitask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapperImpl userMapper;

  @Override
  public UserResponseDto register(RegisterUserRequestDto requestDto)
      throws RegistrationException {
    if (userRepository.findUserByEmail(requestDto.getEmail()).isPresent()) {
      throw new RegistrationException("Can`t register user: email is already used");
    }
    User user = new User();
    user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
    user.setEmail(requestDto.getEmail());
    User userEntity = userRepository.save(user);
    return userMapper.toDto(userEntity);
  }
}