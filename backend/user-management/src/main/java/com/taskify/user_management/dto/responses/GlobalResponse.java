package com.taskify.user_management.dto.responses;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponse<T>{
    private int statusCode;
    private T data;
}
