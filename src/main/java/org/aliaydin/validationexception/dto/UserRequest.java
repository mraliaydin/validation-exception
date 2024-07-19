package org.aliaydin.validationexception.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    //Field cannot be null
    @NotNull(message = "Username cannot be null")
    //Field cannot be empty "name":""
    @NotEmpty
    private String name;

    @Email
    private String email;

    //Regex pattern. It says that there should be 10 numbers.
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobile;

    private String gender;

    //min value of age can be 18 and max can be 60
    @Min(18)
    @Max(60)
    private int age;

    private String nationality;
}
