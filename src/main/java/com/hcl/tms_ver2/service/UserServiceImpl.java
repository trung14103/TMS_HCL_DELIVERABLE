package com.hcl.tms_ver2.service;

import com.hcl.tms_ver2.common.utils.DateUtils;
import com.hcl.tms_ver2.common.utils.UserRoleEnum;
import com.hcl.tms_ver2.persistent.domain.User;
import com.hcl.tms_ver2.persistent.repository.UserRepository;
import com.hcl.tms_ver2.request.UserRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LogManager.getLogger(UserService.class) ;

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequest userRequest) {
        logger.info("RegisterNewUser");

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setAvatar("/link/avatar.jpg");

        if (userRequest.getRoles().isEmpty()) {
            Set<UserRoleEnum> userRoleEnums = new HashSet<>();
            UserRoleEnum userRoleEnum = UserRoleEnum.EMPLOYEE;

            userRoleEnums.add(userRoleEnum);
            user.setRoles(userRoleEnums);
        }

        if (ObjectUtils.isEmpty(userRequest.getCreatedDate())) {
            user.setCreatedDate(new Date(System.currentTimeMillis()));
        } else {
            user.setCreatedDate(DateUtils.convertStringToDate(userRequest.getCreatedDate()));
        }

        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("User with id %d could not be found", id)));
        userRepository.delete(user);
    }

    @Override
    public void updateUser(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        user.setEmail(userRequest.getEmail());
        user.setRoles(userRequest.getRoles());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setCreatedDate(new Date());
        user.setName(userRequest.getUsername());

        userRepository.save(user);
    }

    @Override
    public boolean checkExistedUserName(String username, String oldUsername) {
        User user = userRepository.findByName(username).orElse(null);

        if (oldUsername != null) {
            return user == userRepository.findByName(oldUsername).orElse(null);
        }

        return user != null;
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username).orElse(null);
    }
}
