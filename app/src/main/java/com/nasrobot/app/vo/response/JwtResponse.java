package com.nasrobot.app.vo.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String username;
    private String email;
    private List<String> roles;


}
