package com.Lab01;


public class LoginModel {
    private static String _adminLogin = "admin";
    private static String _adminPassword = "admin";

    public boolean isValidData(String login, String pass) {
        return login.equals(_adminLogin) && pass.equals(_adminPassword);
    }
}
