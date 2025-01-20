package com.example.demo.controller;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.example.demo.controller
 * fileName       : UserRestController
 * author         : doong2s
 * date           : 2025. 1. 12.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 1. 12.        doong2s       최초 생성
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{goodsNo}")
    public ResponseEntity<? extends UserResponseDto> getUserByuserNo(@PathVariable String goodsNo) {
        UserResponseDto userResponseDto = userService.getUserByUserNo(goodsNo);
        return ResponseEntity
                .ok()
                .body(userResponseDto);
    }
}
