package com.santanu.service;

import com.santanu.model.PasswordResetToken;

public interface PasswordResetTokenService {

    public PasswordResetToken findByToken(String token);

    public void delete(PasswordResetToken resetToken);

}
