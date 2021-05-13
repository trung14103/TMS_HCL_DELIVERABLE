//package com.hcl.tms_ver2.repository;
//
//import com.hcl.tms_ver2.common.utils.UserRoleEnum;
//import com.hcl.tms_ver2.persistent.domain.User;
//import com.hcl.tms_ver2.persistent.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Profile;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.HashSet;
//
//@DataJpaTest
//@ExtendWith(SpringExtension.class)
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository repository;
//
//    @Test
//    @DisplayName("Create User Test Successful")
//    public void testCreateUser() {
//        HashSet<UserRoleEnum> roles = new HashSet<>();
//        roles.add(UserRoleEnum.EMPLOYEE);
//
//        Assertions.assertEquals(repository.count(), 1L);
//    }
//
//    @Test
//    public void testCreateUser2() {
//        HashSet<UserRoleEnum> roles = new HashSet<>();
//        roles.add(UserRoleEnum.EMPLOYEE);
//        roles.add(UserRoleEnum.ADMIN_WAREHOUSE);
//
//        repository.save(User.builder()
//                .id(2L)
//                .email("ngotrung1@gmail.com")
//                .name("trung")
//                .password("123456")
//                .status(0)
//                .phoneNumber("0943434872")
//                .build());
//
//        Assertions.assertNotNull(repository.findByNameIgnoreCase("trung"));
//    }
//
//    @Test
//    public void testSelectUser() {
//        User user = repository.findByNameIgnoreCase("cadang1303").orElse(null);
//        assert user != null;
//        Assertions.assertEquals(1, user.getGender());
//    }
//
//}
