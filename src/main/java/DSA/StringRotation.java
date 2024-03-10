package DSA;

import java.util.HashSet;
import java.util.Scanner;

//String Rotation: Given two strings, check if one string is a rotation of the other. For example, “waterbottle” is a rotation of “erbottlewat”.
public class StringRotation {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String A="bottlewater";
        String B="retawelttob";
        checkRotation(A,B);
    }
    public static void checkRotation(String A,String B){

        HashSet<String> hs=new HashSet<>();
//        hs.add(A);

        for(int i=0;i<A.length();i++){
            rotate(hs,A,i);
        }

        if(hs.contains(B)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void rotate(HashSet<String> hs, String A,int i){
        StringBuilder sb=new StringBuilder();
        for(int x=A.length()-i;x<A.length();x++){
            sb.append(A.charAt(x));
//            System.out.println("Suffix String: "+sb);
        }
        for(int x=0;x<A.length()-i;x++){
            sb.append(A.charAt(x));
//            System.out.println("Prefix String: "+sb);
        }
        hs.add(sb.toString());
//        System.out.println("Added to hs");
    }

}
