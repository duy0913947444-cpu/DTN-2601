package com.vti.Common;

public class StringCommon {
    public static final String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String nameRegex = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$";
    public static final String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+!])[A-Za-z\\d@#$%^&+!]{8,20}$";
}
