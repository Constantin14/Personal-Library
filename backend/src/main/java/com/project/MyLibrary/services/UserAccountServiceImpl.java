package com.project.MyLibrary.services;

import com.project.MyLibrary.dtos.RegisterAccountDTO;
import com.project.MyLibrary.dtos.UserAccountDTO;
import com.project.MyLibrary.exception.ResourceNotFoundException;
import com.project.MyLibrary.models.UserAccount;
import com.project.MyLibrary.repositories.UserAccountRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService{
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserAccountDTO getUserDetails(String username) {
        UserAccount byUsername = userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found, " + username));
        return new UserAccountDTO()
                .setUsername(byUsername.getUsername())
                .setAuthorities(byUsername.getAuthorities());
    }

    public UserAccount getUserAccountByUsername(String username) {
        return userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found, " + username));
    }

    public void registerUser(RegisterAccountDTO registerAccountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerAccountDTO.getUsername());
        userAccount.setPassword(passwordEncoder.encode(registerAccountDTO.getPassword()));
        userAccountRepository.save(userAccount);
    }

    public void logoutUser() {
        SecurityContextHolder.clearContext();
    }
}
