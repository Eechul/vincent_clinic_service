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
    public User findByNo(Long no) {
        return userRepository.findById(no)
                .orElseThrow(() -> new UserNotFoundException("user primary no: " + no + " / Not found"));
    }

    @Override
    public User findByUserId(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException("user id : " + userId + " / Not found"));
        return null;
    }

}
