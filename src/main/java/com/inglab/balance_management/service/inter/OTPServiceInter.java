package com.inglab.balance_management.service.inter;


import com.inglab.balance_management.model.User;

public interface OTPServiceInter {

    String generateAndSendOTP(User user);


}