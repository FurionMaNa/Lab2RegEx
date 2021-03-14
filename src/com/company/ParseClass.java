package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseClass {

    public static boolean parsing(String str){
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я0-9_]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
