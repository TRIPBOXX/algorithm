class Solution {
  public String solution(String s, int n) {
    char[] input = s.toCharArray();
      String answer = "";
      //1.알파벳 a~z (A~Z):  까지 총 26개 
    // 2.1 일정한 자리씩 민다.  
    //2.나머지 연산과 비슷하다 생각(x = y *z + gama):알파벳 총 갯수 (26개)로 나누어 자릿수 세팅 가능
     //알파벳 시작점 : A / a 를  상대적 위치 , 절대적 위치로 서로 스위치 :'4' a->> e
    // s  n   result   n = 1, (a) -> (b) / (a,b) -> (b,c)/ (c,B,z)-> (d,C,a) : 자릿 수를 절대(26)을 기준으로 상대적인 위치 n만큼 이동 가능! 
    //
      
        for(int i = 0 ; i < input.length ; i++) {
            if(input[i] != ' ') {//i배열에 담고
                if(input[i] >= 'a') { // 시작점: a부터 26개~
                    //  절대적 위치  에서 상대적 위치로  스위치 
                   //n만큼 밀고 %처리 -> 다시 원래대로 돌림 
                    answer += (char)((input[i] - 'a' + n) % 26 +'a');
                    // 시작점 a기준으로 들어온 n만큼 이동시킨후 %처리 후 다시 원래대로 백
                }else { //시작점: A기준으로 들어온 n만큼 이동시킨후 %처리 후 다시 원래대로 백
                    answer += (char)((input[i] - 'A' + n) % 26 +'A');
                }
                }else {
                answer += " ";
            }
        }
            return answer;
    }
}
