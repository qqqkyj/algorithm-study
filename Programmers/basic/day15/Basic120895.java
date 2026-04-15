public class Basic120895 {
    public String solution(String my_string, int num1, int num2) {
        String[] arr = my_string.split("");
        String tmp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = tmp;
        
        StringBuilder sb = new StringBuilder();
        for(String s: arr) sb.append(s);
        return sb.toString();
    }
}