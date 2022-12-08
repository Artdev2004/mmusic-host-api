package com.etec.mmusic.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequest {

    @NotBlank(message = "Field username not should be blank")
    @Size(min = 3, max = 20)
    public String username;

    @NotBlank(message = "Field email not should be blank" )
    @Size(max = 50)
    @Email
    public String email;

    @NotBlank(message = "Field password not should be blank" )
    @Size(min = 6, max = 40)
    public String password;

    @NotBlank(message = "Field status can't should be blank, should be attendant or requester")
    public String status;

}
