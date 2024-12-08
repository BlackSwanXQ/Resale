package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.IncorrectPasswordException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.security.CustomUserDetailsManager;
import ru.skypro.homework.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public boolean setNewPassword(String userName, NewPasswordDto newPassword) {
        User user = userRepository.findByEmail(userName).orElseThrow(()-> new UsernameNotFoundException(String.format("Пользователь %s не найден!", userName)));
        if (!passwordEncoder.matches(newPassword.getCurrentPassword(), user.getPassword())) {
            throw new IncorrectPasswordException("Неверный пароль!");
        };
        user.setPassword(passwordEncoder.encode(newPassword.getNewPassword()));
        return true;
    }

    @Override
    public UserDto getUser(String userName) {
        User user = userRepository.findByEmail(userName).orElseThrow(()-> new UsernameNotFoundException(String.format("Пользователь %s не найден!", userName)));
        return userMapper.userToUserDto(user);
    }

    @Transactional
    @Override
    public UpdateUserDto updateUser(String userName, UpdateUserDto userDto) {
        User user = userRepository.findByEmail(userName).orElseThrow(()-> new UsernameNotFoundException(String.format("Пользователь %s не найден!", userName)));
        userMapper.updateUserDtoToUser(user, userDto);
        return userMapper.userToUpdateUserDto(user);
    }
}
