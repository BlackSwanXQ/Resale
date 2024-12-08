package ru.skypro.homework.service;

import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

public interface UserService {
    boolean setNewPassword(String userName, NewPasswordDto newPassword);

    UserDto getUser(String userName);

    UpdateUserDto updateUser(String userName, UpdateUserDto userDto);

}
