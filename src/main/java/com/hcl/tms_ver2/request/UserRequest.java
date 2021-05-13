package com.hcl.tms_ver2.request;

import com.hcl.tms_ver2.common.utils.UserRoleEnum;
import com.hcl.tms_ver2.common.validation.FieldMatch;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@FieldMatch(first = "password", second = "confirmPassword", message = "{user.password.match}")
public class UserRequest {

    @NotEmpty(message = "user.username.notEmpty")
    private String username;

    @NotEmpty(message = "user.password.notEmpty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;

    private Set<UserRoleEnum> roles;

    @NotEmpty(message = "user.email.notEmpty")
    private String email;

    @NotEmpty(message = "user.createdDate.notEmpty")
    private String createdDate;

    @NotEmpty(message = "user.createdBy.notEmpty")
    private String createdBy;

    @NotEmpty
    private Long id;

    private String oldUserName;

    private String avatar;

}
