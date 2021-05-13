package com.hcl.tms_ver2.controller;

import com.hcl.tms_ver2.common.utils.Constants;
import com.hcl.tms_ver2.request.UserRequest;
import com.hcl.tms_ver2.response.ErrInfo;
import com.hcl.tms_ver2.response.UserResponse;
import com.hcl.tms_ver2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService service) {
        this.userService = service;
    }

    @GetMapping(value = "/sign-in")
    public ModelAndView signIn() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("sign-in");
        mav.addObject("vm", new UserResponse());

        return mav;
    }

    @GetMapping(value ="/sign-up")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", new UserRequest());
        modelAndView.setViewName("sign-up");

        return modelAndView;
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> createUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
        List<ErrInfo> errInfoList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()
            ) {
                errInfoList.add(new ErrInfo(fieldError.getDefaultMessage(), fieldError.getField()));
            }
        }

        if (userService.checkExistedUserName(userRequest.getUsername(), null)) {
            errInfoList.add(new ErrInfo("Username is already existed", "username"));
        }

        if (CollectionUtils.isEmpty(errInfoList)) {
            userService.createUser(userRequest);
            map.put("status", Constants.OK);
        } else {
            map.put("status", Constants.CONTINUE);
        }
        map.put("message", errInfoList);

        return map;
    }

}
