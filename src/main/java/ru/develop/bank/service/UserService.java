package ru.develop.bank.service;

import ru.develop.bank.dto.NewUserDto;
import ru.develop.bank.dto.UpdatedUserDto;

public interface UserService {

    NewUserDto create(NewUserDto newUserDto);

    UpdatedUserDto addPhoneNumber(Long userId, String phoneNumber);

    UpdatedUserDto updatePhoneNumber(Long userId, String previousPhoneNumber, String newPhoneNumber);

    void deletePhoneNumber(Long userId, String phoneNumber);

    UpdatedUserDto addEmail(Long userId, String email);

    UpdatedUserDto updateEmail(Long userId, String previousEmail, String newEmail);

    void deleteEmail(Long userId, String email);


}
