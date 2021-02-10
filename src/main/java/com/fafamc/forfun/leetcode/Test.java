package com.fafamc.forfun.leetcode;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

   public static  void printFiles(String path){
       File file = new File(path);
       if(!file.exists()){
           return ;
       }

       List<File> directorys = new ArrayList<>();
       directorys.add(file);
       dof(directorys);
   }

   public static void dof (List<File> parentFiles){
       if(CollectionUtils.isEmpty(parentFiles)){
           return ;
       }
       List<File> newList = new ArrayList<>();
       for(File parentFile : parentFiles){
           File [] fs = parentFile.listFiles();
           for(File f : fs){
               if(f.isDirectory()){
                   newList.add(f);
                   continue;
               }
               System.out.println(f.getName());
           }
       }
       dof(newList);
   }


    public static void main(String[] args) {
        printFiles("F:\\建行项目资料");
    }
}
