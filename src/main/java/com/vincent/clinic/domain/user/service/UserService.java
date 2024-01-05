package com.vincent.clinic.domain.user.service;

import com.vincent.clinic.domain.user.entity.User;

public interface UserService {

    User findByNo(Long no);
    User findByUserId(String userId);
}
