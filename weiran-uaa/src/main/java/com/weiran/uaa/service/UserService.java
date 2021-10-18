package com.weiran.uaa.service;

import com.weiran.uaa.util.AjaxResult;

public interface UserService {

    AjaxResult login(String username, String password);
}
