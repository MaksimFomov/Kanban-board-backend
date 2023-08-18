package com.fomov.kanbanboardbackend.service.impl;

import com.fomov.kanbanboardbackend.repository.UserRepository;
import com.fomov.kanbanboardbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;


}
