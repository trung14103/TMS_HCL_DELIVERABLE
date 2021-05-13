package com.hcl.tms_ver2.service;

import com.hcl.tms_ver2.persistent.domain.User;
import com.hcl.tms_ver2.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
     void createUser(UserRequest userRequest);

     List<User> getAllUser();

     User findById(Long id);

     void deleteUser(Long id);

     void updateUser(UserRequest userRequest);

     boolean checkExistedUserName(String username, String oldUsername);

     User findByName(String username);

}
