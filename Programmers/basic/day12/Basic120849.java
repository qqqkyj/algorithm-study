package day12;

public class Basic120849 {
  class Solution {
    public String solution(String my_string) {
        String[] arr = {"a", "e", "i", "o", "u"};
        for(String s: arr){
            my_string = my_string.replace(s,"");
        }
        
        return my_string;
    }
}
}
