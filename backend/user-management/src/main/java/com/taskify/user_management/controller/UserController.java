package com.taskify.user_management.controller;

import com.taskify.user_management.dto.responses.GlobalResponse;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.enums.RoleType;
import com.taskify.user_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/user-management/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping("DeleteUser/{id}")
    public ResponseEntity<GlobalResponse<UserResponse>> deleteUserById(@PathVariable("id") long id){
        UserResponse user= userService.deleteUserById(id);
        GlobalResponse<UserResponse> response= new GlobalResponse<>(HttpStatus.OK.value(),user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<UserResponse>>> getAllUsers() {
        List<UserResponse> user= userService.getAllUsers();
        GlobalResponse<List<UserResponse>> response= new GlobalResponse<>(HttpStatus.OK.value(),user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<UserResponse>> getUserById(@PathVariable Long id) {
        UserResponse user= userService.getUserById(id);
        GlobalResponse<UserResponse> response= new GlobalResponse<>(HttpStatus.OK.value(),user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<GlobalResponse<UserResponse>> getUserByEmail(@PathVariable String email) {
        UserResponse user= userService.getUserByEmail(email);
        GlobalResponse<UserResponse> response= new GlobalResponse<>(HttpStatus.OK.value(),user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @GetMapping("Role/{id}")
    public ResponseEntity<GlobalResponse<RoleType>> getRoleByUserId(@PathVariable Long id) {
        RoleType roleType= userService.getRoleByUserId(id);
        GlobalResponse<RoleType> response= new GlobalResponse<>(HttpStatus.OK.value(),roleType);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
