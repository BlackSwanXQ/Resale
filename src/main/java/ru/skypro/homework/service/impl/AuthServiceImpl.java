package ru.skypro.homework.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder encoder;


    @Override
    public boolean login(String userName, String password) {
        try {
            User user = userService.getUser(userName);
            return encoder.matches(password, user.getPassword());
        } catch (UsernameNotFoundException ex) {
            return false;
        }
    }

    @Override
    public boolean register(RegisterDto register) {
        userService.createUser(register);
        return true;
    }
}
