package com.taskify.user_management.controller;

import com.taskify.user_management.dto.responses.GlobalResponse;
import com.taskify.user_management.dto.responses.OrgRes;
import com.taskify.user_management.entity.User;
import com.taskify.user_management.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class OrgController {

    private final OrganizationService organizationService;

    public OrgController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("Organization/{email}")
    public ResponseEntity<GlobalResponse<OrgRes>> getOrgByOwnerEmail(@PathVariable String email) {
        OrgRes organization= organizationService.getOrgByOwnerEmail(email);
        GlobalResponse<OrgRes> response= new GlobalResponse<OrgRes>(HttpStatus.OK.value(),organization);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//    @GetMapping("/{id}/users")
//    public ResponseEntity<GlobalResponse<List<User>>> getUsers(@PathVariable Long id) {
//        return organizationService.getAllUsers(id);
//    }








}
