package com.weiran.uaa.service;

import com.weiran.uaa.obj.AjaxResult;

public interface UserService {

    AjaxResult login(String username, String password);
}
