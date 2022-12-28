package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.User;
import com.example.carshop.web.dto.UserDto;

import java.util.List;

public interface UserService {
	void saveUser(UserDto userDto);

	User findUserByUsername(String username);

	List<UserDto> findAllUsers();
}
