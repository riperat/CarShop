package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Role;
import com.example.carshop.data.entity.User;
import com.example.carshop.data.repository.RoleRepository;
import com.example.carshop.data.repository.UserRepository;
import com.example.carshop.security.PasswordEncoder;
import com.example.carshop.services.interfaces.UserService;
import com.example.carshop.web.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(userDto.getPassword()));

        Role role = roleRepository.findByAuthority("USER");
        if (role == null) {
            role = checkRoleExist();
        }

        user.setAuthorities(Set.of(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setAuthority("USER");
        return roleRepository.save(role);
    }
}
