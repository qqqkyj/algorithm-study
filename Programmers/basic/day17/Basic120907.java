public class Basic120907{
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int j=0; j<quiz.length; j++){
            String[] p = quiz[j].split(" ");
            int result = Integer.parseInt(p[0]);
            for(int i=1; i<p.length; i+=2){
                if("+".equals(p[i])){
                    result+=Integer.parseInt(p[i+1]);
                }
                else if("-".equals(p[i])){
                    result-=Integer.parseInt(p[i+1]);
                }
                else{
                    int total = Integer.parseInt(p[i+1]);
                    answer[j] = result == total ? "O" : "X";
                }
            }
        }
        return answer;
    }
}