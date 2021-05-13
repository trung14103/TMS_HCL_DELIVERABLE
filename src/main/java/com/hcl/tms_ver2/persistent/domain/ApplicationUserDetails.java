package com.hcl.tms_ver2.persistent.domain;

import com.hcl.tms_ver2.common.utils.UserRoleEnum;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {
    private static final String ROLE_PREFIX = "ROLE_";

    private User user;

    public ApplicationUserDetails(User user) {
        super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
        this.user = user;
    }

    private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRoleEnum> userRoleEnums) {
        return userRoleEnums.stream().map(userRoleEnum -> new SimpleGrantedAuthority(ROLE_PREFIX + userRoleEnum.getText())).collect(Collectors.toSet());
    }

    public User getUser() { return this.user;}
}
