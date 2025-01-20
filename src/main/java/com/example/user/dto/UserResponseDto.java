package com.example.user.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    String userNo;
    String userName;
    String goodsNo;
    String goodsName;
}
