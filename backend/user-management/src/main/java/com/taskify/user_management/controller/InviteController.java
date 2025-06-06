package com.taskify.user_management.controller;

import com.taskify.user_management.dto.requests.InviteRequest;
import com.taskify.user_management.service.InviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invite")
public class InviteController {

    private final InviteService inviteService;

    public InviteController(InviteService inviteService) {
        this.inviteService = inviteService;
    }

    @PostMapping
    public ResponseEntity<String> invite(@RequestBody InviteRequest request) {
        inviteService.sendInvite(request);
        return ResponseEntity.ok("Invite initiated.");
    }

    @GetMapping("/accept/{token}")
    public ResponseEntity<String> acceptInvite(@PathVariable String token,
                                               @RequestHeader("Authorization") String tokenHeader) throws Exception {
        inviteService.acceptInvite(token, tokenHeader);
        return ResponseEntity.ok("Invite accepted.");
    }
}

