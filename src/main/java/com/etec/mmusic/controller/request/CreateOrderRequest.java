package com.etec.mmusic.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderRequest {

    @NotEmpty(message = "Field attendant can't should empty")
    public String attendant;
    @NotEmpty(message = "Field requester can't should empty")
    public String requester;
    @NotEmpty(message = "Field description can't should empty")
    public String description;

}
