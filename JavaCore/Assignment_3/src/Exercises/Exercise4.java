package Exercises;

import Entities.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Exercise4 {
    static Scanner sc = new Scanner(System.in);

    public static int question1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static String question2(String s1, String s2) {
        return s1.concat(s2);
    }

    public static String question3(String name) {
        if (Objects.isNull(name) || name.equals("")) return null;
        name = name.trim().toLowerCase();
        String[] subStrings = name.split("\\s+");
        name = "";
        for (String subString : subStrings) {
//            String firstLetter = String.valueOf(Character.toUpperCase(subString.charAt(0)));
//            subString = firstLetter + subString.substring(1);
            StringBuilder sb = new StringBuilder(subString);
            sb.replace(0,1,String.valueOf(Character.toUpperCase(sb.charAt(0))));
            name += sb + " ";
        }
        return name.trim();
    }

    public static void question4(String name) {
        if (Objects.isNull(name) || name.equals("") || name.equals(" ")) {
            System.out.println("nhap loi");
            return;
        }
        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
        }
    }

    public static void question5() {
        String ho, ten;
        System.out.println("Nhap ho:");
        ho = sc.nextLine();
        System.out.println("Nhap ten: ");
        ten = sc.nextLine();
        System.out.println("Ho va ten: " + ho + " " + ten);
    }

    public static void question6(String name) {
        if (Objects.isNull(name) || name.equals("") || name.equals(" ")) return;
        List<String> subName = List.of(name.split(" "));
        if (subName.size() == 1) {
            System.out.println("Ten: " + subName.get(0));
        } else if (subName.size() == 2) {
            System.out.println("Ho: " + subName.get(0));
            System.out.println("Ten: " + subName.get(1));
        } else {
            System.out.println("Ho: " + subName.get(0));
            System.out.print("Ten dem: ");
            for (int i = 1; i < subName.size() - 1; i++) {
                System.out.print(subName.get(i) + " ");
            }
            System.out.println();
            System.out.println("Ten: " + subName.get(subName.size() - 1));
        }
    }

    public static void question8(List<Group> groups) {
        if (groups.isEmpty()) return;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().contains("Java"))
                System.out.println(groups.get(i));
        }
    }

    public static void question9(List<Group> groups) {
        if (groups.isEmpty()) return;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equals("Java"))
                System.out.println(groups.get(i));
        }
    }
    public static boolean question10(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1.trim().toLowerCase());
        return sb1.reverse().toString().equals(s2.trim().toLowerCase());
    }

    public static int question11(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals("a")) count++;
        }
        return count;
    }

    public static void question12(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }

    public static boolean question13(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) return false;
        }
        StringBuilder sb = new StringBuilder();
        return true;
    }

    public static String question14(String s, char replaceLetter, char letter) {
        if (Objects.isNull(s) || s.equals("") || s.equals(" ")) return null;
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for (int i = 0; i < sb.length(); i++) {
            if (String.valueOf(sb.charAt(i)).equalsIgnoreCase((String.valueOf(replaceLetter)))) {
                sb.setCharAt(i, letter);
            }
        }
        return sb.toString();
    }

    public static void question15(String s) {
        if (Objects.isNull(s) || s.equals("") || s.equals(" ")) return;
        String[] subString = s.trim().split("\\s+");
        for (int i = subString.length -1; i >= 0 ; i--) {
            System.out.print(subString[i] + " ");
        }
    }
    public static List<String> question16(String s, int n){
        if (Objects.isNull(s) || s.equals("") || s.equals(" ")) return null;
        List<String> subString = new ArrayList<>();
        if(s.length()%n != 0) return null;
        for(int i = 0; i < s.length(); i+=n){
            System.out.println(s.substring(i,i+n));
        }
        return subString;
    }
}
