package com.duc.cinebook.dto.request;

import com.duc.cinebook.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserCreationRequest {
    private String name;
    private String email;
    private String password;
    private List<Role> role;
    private String phone;
}
