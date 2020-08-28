package com.fafamc.forfun.stringtest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ForString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "abc,1234,55,123";
//        System.out.println(Arrays.toString(str.getBytes("UTF-8")));
//        System.out.println(Arrays.toString( str.toCharArray()));

//        System.out.println(Arrays.toString( ForString.split(str,",1")));
        System.out.println(ForString.indexOf(str,"bc,1"));
    }


    public static String[] split(String oldString, String splitChar){
        List<String> returnList = new ArrayList<String>();
        while(oldString.indexOf(splitChar)>-1){
            if(oldString.indexOf(splitChar) == 0){
                oldString = oldString.substring(splitChar.length(),oldString.length());
            }else{
                returnList.add(oldString.substring(0,oldString.indexOf(splitChar)));
                oldString = oldString.substring(oldString.indexOf(splitChar),oldString.length());
            }
        }
        returnList.add(oldString);
        String[] result = new String[returnList.size()];
        return returnList.toArray(result);
    }
    //TODO
    public static int indexOf(String source,String target){
        char sources[] = source.toCharArray();
        char targets[] = target.toCharArray();
        if(targets.length > sources.length){
            return -1;
        }else{
            for(int i = 0 ; i < sources.length - targets.length ; i ++){
                boolean flag = true;
                A : for(int j = 0 ; j < targets.length ; j++){
//                    System.out.println(sources[i+j]);
//                    System.out.println(targets[j]);
                    if(sources[i+j] != targets[j]){
                        flag = false;
                        break A;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}
