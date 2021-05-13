package com.hcl.tms_ver2.persistent.domain;

import com.hcl.tms_ver2.common.utils.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "dbo_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dbo_user")
public class User {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "dbo_user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<UserRoleEnum> roles;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "status")
    private int status;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private int gender;

    @Column(name = "avatar")
    private String avatar;
}
