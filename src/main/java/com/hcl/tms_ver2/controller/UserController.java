package com.hcl.tms_ver2.controller;

import com.hcl.tms_ver2.common.utils.Constants;
import com.hcl.tms_ver2.persistent.domain.ApplicationUserDetails;
import com.hcl.tms_ver2.persistent.domain.User;
import com.hcl.tms_ver2.request.UserRequest;
import com.hcl.tms_ver2.response.ErrInfo;
import com.hcl.tms_ver2.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.ObjectUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasPermission('ADMIN')")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/list")
    public ModelAndView getAllUser() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("userList", userService.getAllUser());
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        long id = ((ApplicationUserDetails) principal).getUser().getId();
        mav.addObject("loginId", id);
        mav.setViewName("user/list");
        return mav;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
        List<ErrInfo> errInfoList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()
            ) {
                errInfoList.add(new ErrInfo(fieldError.getDefaultMessage(), fieldError.getField()));
            }
        }

        if (userService.checkExistedUserName(userRequest.getUsername(), userRequest.getUsername())) {
            errInfoList.add(new ErrInfo("Username is already existed", "username"));
        }

        if (CollectionUtils.isEmpty(errInfoList)) {
            userService.updateUser(userRequest);
            map.put("status", Constants.OK);
        } else {
            map.put("status", Constants.CONTINUE);
        }
        map.put("message", errInfoList);

        return map;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        User user = userService.findById(id);

        mav.addObject("user", user);
        mav.setViewName("user/edit");

        return mav;
    }

}
