package com.taskify.project_management.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalResponse<T>{
    private int statusCode;
    private T data;
}
