package com.example.updateapitask.dto;

import com.example.updateapitask.annotations.ValidPassword;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserLoginRequestDto {
  @Length(max = 100)
  @Email
  private String email;
  @ValidPassword
  private String password;
}
