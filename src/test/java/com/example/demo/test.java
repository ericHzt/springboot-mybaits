package com.example.demo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
   private static List test1 = new ArrayList();
   public static void main(String[] args){
      /*  int i = 10;
       System.out.println(Integer.toBinaryString(i));
       i = i<<1;
       System.out.println(Integer.toBinaryString(i));
       i=i>>1;
       System.out.println(Integer.toBinaryString(i));
       i=i>>>3;
       System.out.println(Integer.toBinaryString(i));

       int j = -5;
       System.out.println(Integer.toBinaryString(j));
       j = j>>>1;
       System.out.println(Integer.toBinaryString(j));*/

      /*try{
          int number = Integer.parseInt("a123");
          if(number > 100){
              throw new Exception("out of bound");
          }
      }catch(NumberFormatException e){
           System.out.println("===");
       }catch (Exception e){
          System.out.println(e.getMessage());
      }finally{
          System.out.println("done");
      }*/
     /* String a = new String("2");
      Object[] element = new Object[]{"1",a};
      for(Object o: element){

      }
      Object[] element2 = element.clone();
      a=new String("3");
      System.out.println(element[1]);
      System.out.println(element2[1]);
       System.out.println(a);
      BigInteger test  = new BigInteger("2");

      String[] strings = {"A","B","C"};
      Arrays.asList(strings);
      new ArrayList<String>(Arrays.asList(strings));*/
     test1.add("test");

     test1.add(new test());
     for(int i = 0 ; i < test1.size();i++){
        System.out.println(test1.get(i));
     }
   }
}

