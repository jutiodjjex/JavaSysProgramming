package com.github.jutiodjjex.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{

    static Pattern pattern = Pattern.compile("[:][)]");

    public static void main(System[] args){

        String baobabA = "meme =) asdf";
        smileReplacer(baobabA);
        System.out.println(baobabA);

    }

    public static String smileReplacer(String stringForReplace){
        Matcher matcher = pattern.matcher(stringForReplace);
        String replacedString = null;
        pattern.matcher(stringForReplace);
        if(matcher.lookingAt()){
            replacedString = stringForReplace.replaceAll(pattern.toString(), "=-)");
        } else {
            System.out.println("Matches not found");
        }
        return replacedString;
    }
}
