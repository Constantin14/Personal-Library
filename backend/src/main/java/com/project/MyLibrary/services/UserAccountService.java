package com.project.MyLibrary.services;

import com.project.MyLibrary.dtos.RegisterAccountDTO;
import com.project.MyLibrary.dtos.UserAccountDTO;
import com.project.MyLibrary.models.UserAccount;

public interface UserAccountService {
    UserAccountDTO getUserDetails(String username);

    UserAccount getUserAccountByUsername(String username);

    void registerUser(RegisterAccountDTO registerAccountDTO);

    void logoutUser();
}
