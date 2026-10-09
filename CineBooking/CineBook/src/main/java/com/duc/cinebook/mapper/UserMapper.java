package com.duc.cinebook.mapper;

import com.duc.cinebook.dto.request.UserCreationRequest;
import com.duc.cinebook.dto.response.UserResponse;
import com.duc.cinebook.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users UserCreationRequesttoUsers(UserCreationRequest request);
    UserResponse toUserResponse(Users user);
}
