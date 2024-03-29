package ru.develop.bank.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.develop.bank.dto.UpdatedUserDto;
import ru.develop.bank.dto.UserDto;
import ru.develop.bank.model.Email;
import ru.develop.bank.model.PhoneNumber;
import ru.develop.bank.model.User;
import ru.develop.bank.sequrity.dto.RegisterUserDto;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserDto toUserDto(RegisterUserDto registerUserDto) {
        return UserDto.builder()
                .login(registerUserDto.getLogin())
                .password(registerUserDto.getPassword())
                .name(registerUserDto.getName())
                .birthday(registerUserDto.getBirthday())
                .accountBalance(registerUserDto.getAccountBalance())
                .limitOfInterestAccrual(registerUserDto.getAccountBalance() * 207 / 100)
                .phoneNumbers(registerUserDto.getPhoneNumbers())
                .emails(registerUserDto.getEmails())
                .build();
    }

    public static UserDto toUserDto(User user, List<String> phoneNumbers, List<String> emails) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .name(user.getName())
                .birthday(user.getBirthday())
                .accountBalance(user.getAccountBalance())
                .limitOfInterestAccrual(user.getLimitOfInterestAccrual())
                .phoneNumbers(phoneNumbers.stream().toList())
                .emails(emails.stream().toList())
                .build();
    }

    public static UpdatedUserDto toUpdatedUserDtoByPhone(Long userId, List<PhoneNumber> phoneNumbers) {
        return UpdatedUserDto.builder()
                .id(userId)
                .phoneNumbers(phoneNumbers.stream().map(PhoneNumber::getPhoneNumber).toList())
                .build();

    }

    public static UpdatedUserDto toUpdatedUserDtoByEmail(Long userId, List<Email> emails) {

        List<String> emailsList = new ArrayList<>();
        for (Email email : emails) {
            emailsList.add(email.getEmail());
        }
        return UpdatedUserDto.builder()
                .id(userId)
                .emails(emailsList)
                .build();

    }
}
