package ru.skypro.homework.service;

import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.User;

public interface UserService {
    boolean setNewPassword(String userName, NewPasswordDto newPassword);

    UserDto getUserDto(String userName);
    User getUser(String userName);
    UpdateUserDto updateUser(String userName, UpdateUserDto userDto);
    void createUser(RegisterDto dto);

}
