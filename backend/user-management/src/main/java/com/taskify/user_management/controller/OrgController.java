package com.taskify.user_management.controller;

import com.taskify.user_management.dto.responses.GlobalResponse;
import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.dto.responses.UserResponse;
import com.taskify.user_management.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OrgController {

    private final OrganizationService organizationService;

    public OrgController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @PutMapping("update-org-name/{id}")
    public ResponseEntity<GlobalResponse<OrgRes>> updateName(@PathVariable Long id, @RequestBody String name) {

       OrgRes orgRes= organizationService.updateOrgName(id,name);
       GlobalResponse<OrgRes> response= new GlobalResponse<>(HttpStatus.OK.value(), orgRes);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}/users")
    public ResponseEntity<GlobalResponse<List<UserResponse>>> getUsers(@PathVariable Long id) {
        List<UserResponse> users = organizationService.findAllUsers();
        GlobalResponse<List<UserResponse>> response = new GlobalResponse<>(HttpStatus.OK.value(), users);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
