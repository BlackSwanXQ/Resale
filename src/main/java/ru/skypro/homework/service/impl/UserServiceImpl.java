package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean setNewPassword(NewPassword newPassword) {
        return false;
    }
}
