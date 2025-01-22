package com.example.user.controller;

import com.example.user.dto.UserResponseDto;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : com.example.user.controller
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
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{userNo}")
    public ResponseEntity<? extends UserResponseDto> getUserInfo(@PathVariable String userNo) {

        var userInfo = userService.getUserByUserNo(userNo);

        return ResponseEntity
                .ok()
                .body(userInfo);
    }
}
