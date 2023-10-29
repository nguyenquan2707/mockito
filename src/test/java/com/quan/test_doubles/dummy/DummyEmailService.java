package com.quan.test_doubles.dummy;

import com.quan.dummy.EmailService;

public class DummyEmailService implements EmailService {
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method not implemented");
    }
}
