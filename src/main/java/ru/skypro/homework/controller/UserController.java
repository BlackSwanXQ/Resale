package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.enums.Role;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.service.UserService;

import java.security.Principal;

@Slf4j
@RequestMapping("/users")
@RestController
@CrossOrigin("http://localhost:3000")
@Tag(name = "Пользователи")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Обновление пароля", responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content()),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content())
    })
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(Principal principal, @RequestBody NewPasswordDto newPassword) {
        userService.setNewPassword(principal.getName(), newPassword);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получение информации об авторизованном пользователе", responses = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserDto.class)
                    )),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content())
    })
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        UserDto user = userService.getUser(principal.getName());
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Обновление информации об авторизованном пользователе",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UpdateUserDto.class),
                                    examples = @ExampleObject(
                                            description = "Информация о пользователе обновлена"
                                    )
                            )),
                    @ApiResponse(responseCode = "401",
                            description = "Unauthorized",
                            content = @Content())
            })
    @PatchMapping("/me")
    public ResponseEntity<UpdateUserDto> updateUser(@RequestBody UpdateUserDto userPatch, Principal principal){
        UpdateUserDto userDto = userService.updateUser(principal.getName(), userPatch);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Обновление аватара авторизованного пользователя" , responses = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = @Content()),
            @ApiResponse(responseCode = "401",
                    description = "Unauthorized",
                    content = @Content())
    })
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateImage(@RequestParam MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}
