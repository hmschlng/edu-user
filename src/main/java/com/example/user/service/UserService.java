package com.example.user.service;

import com.example.user.dto.GoodsResponseDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Value("${app.run.type}")
    private String appRunType;

    @Value("${api.url}")
    private String goodsServiceUrl;

    private final RestTemplate restTemplate;


    public UserResponseDto getUserByUserNo(String userNo) {
        String url = goodsServiceUrl + userNo;

        UserResponseDto.UserResponseDtoBuilder builder = UserResponseDto.builder()
                .userNo(userNo)
                .userName(appRunType + "-" + userNo);

        try {

            GoodsResponseDto response = restTemplate.getForObject(url, GoodsResponseDto.class);
            if (response != null) {
                builder.goodsNo(response.getGoodsNo())
                        .goodsName(response.getGoodsName());
            }

        } catch (RestClientException e) {
            log.error("Error fetching user data for userNo: {}", userNo, e);
            throw new UserNotFoundException("Goods not found for userNo: " + userNo, e);
        } catch (Exception e) {
            log.error("Unexpected error occurred for userNo: {}", userNo, e);
        }

        return builder.build();
    }

}
