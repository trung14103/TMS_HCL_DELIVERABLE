package com.hcl.tms_ver2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String username;

    private String email;

    private String createdDate;
}
