package com.example.carshop.registration;

import com.example.carshop.data.entity.User;
import com.example.carshop.registration.token.ConfirmationToken;
import com.example.carshop.registration.token.ConfirmationTokenService;
import com.example.carshop.services.implementations.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService appUserService;

    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {

        String token = appUserService.signUpUser(
                new User(request.getUsername(), request.getPassword())
        );

        return token;
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getUser().getUsername());
        return "confirmed";
    }
}
