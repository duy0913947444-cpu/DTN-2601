package com.vti.Utils;

import java.util.Objects;

import static com.vti.Common.StringCommon.emailRegex;

public class Utils {
    public static boolean checkEmail(String email){
        return email.matches(emailRegex);
    }
    public static boolean checkString(String s){
        return Objects.isNull(s) || s.trim().isEmpty();
    }
}
