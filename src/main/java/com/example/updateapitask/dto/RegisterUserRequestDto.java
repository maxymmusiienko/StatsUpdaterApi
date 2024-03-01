package com.example.updateapitask.dto;

import com.example.updateapitask.annotations.FieldMatch;
import com.example.updateapitask.annotations.ValidPassword;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@FieldMatch(first = "password", second = "repeatPassword",
    message = "Can`t register a user: password and repeated password are not equals")
public class RegisterUserRequestDto {
  @Email
  @Length(max = 100)
  private String email;
  @ValidPassword
  private String password;
  @ValidPassword
  private String repeatPassword;
}
