package com.etec.mmusic.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonDeserialize(builder = UserResponse.UserResponseBuilder.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendantWithListOrderResponse {

    public AttendantResponse attendant;
    public List<OrderDetailResponse> listOfOrders;
}
