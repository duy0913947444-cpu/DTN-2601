package com.vti.Utils;

import java.util.Objects;

public class Utils {
    public static boolean checkString(String s){
        return Objects.isNull(s) || s.isEmpty() || " ".equals(s);
    }
}
