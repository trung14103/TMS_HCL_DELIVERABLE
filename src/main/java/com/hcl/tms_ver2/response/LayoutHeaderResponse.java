package com.hcl.tms_ver2.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LayoutHeaderResponse {
    private String username;

    private String avatar;

    private boolean isAdmin;

    private boolean isUser;

    private long id;
}
