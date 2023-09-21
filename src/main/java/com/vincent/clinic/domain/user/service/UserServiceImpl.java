package com.vincent.clinic.domain.user.service;

import com.vincent.clinic.domain.user.entity.User;
import com.vincent.clinic.domain.user.exception.UserNotFoundException;
import com.vincent.clinic.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user id: " + id + " / Not found"));
    }

}
