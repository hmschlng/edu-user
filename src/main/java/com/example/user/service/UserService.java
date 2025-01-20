package com.example.user.service;

import com.example.user.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.example.user.service
 * fileName       : UserService
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@Service
public class UserService {

    String appRunType;

    public UserService(@Value("${app.run.type}") String appRunType) {
        this.appRunType = appRunType;
    }

    public UserResponseDto getUserByUserNo(String userNo) {

        return UserResponseDto.builder()
                .userNo(userNo)
                .userName("prod-" + userNo)
                .goodsNo(userNo)
                .goodsName("goods-prod-" + userNo)
                .build();
    }
}
