package com.weiran.studentmanager.service;

import com.weiran.studentmanager.util.AjaxResult;

public interface UserService {

    AjaxResult login(String username, String password);
}
