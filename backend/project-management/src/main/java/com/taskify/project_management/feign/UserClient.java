package com.taskify.project_management.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-management")
public interface UserClient {

    @GetMapping("/api/user-management/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);

    class UserDTO {
        public Long id;
        public String name;
        public String email;
    }
}
