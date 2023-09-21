package com.vincent.clinic.domain.user.service;

import com.vincent.clinic.domain.user.entity.User;

public interface UserService {

    User findById(Long id);
}
