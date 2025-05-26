package com.taskify.project_management.feign;

import com.taskify.project_management.dto.responses.GlobalResponse;
import com.taskify.project_management.feign.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-management")
public interface UserClient {

    @GetMapping("/api/user-management/email/{email}")
    GlobalResponse<UserDto> getUserByEmail(@PathVariable("email") String email);
}
