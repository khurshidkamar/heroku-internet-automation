package com.khurshid.automation.testdata;

public class LoginTestData {

    // Valid credentials
    public static final String VALID_USERNAME = "tomsmith";
    public static final String VALID_PASSWORD = "SuperSecretPassword!";

    // Invalid credentials
    public static final String INVALID_USERNAME = "wrongUser";
    public static final String INVALID_PASSWORD = "wrongPass";

    // Expected messages
    public static final String INVALID_LOGIN_ERROR =
            "Your username is invalid!";
}
