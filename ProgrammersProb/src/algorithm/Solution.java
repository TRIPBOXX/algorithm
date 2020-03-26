package algorithm;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int [] STU = new int[n+1];
        //학생을 한줄로 쭉 세웠을 때, 번짓수를 배열로 할당하고 
        for(int i = 0; i < reserve.length; i++) { // 기본학생(체육복 원래 1개씩 있는 학생)
          
			STU[reserve[i]] = STU[reserve[i]] + 1;
        }
        
        for(int i = 0; i < lost.length; i++) {//  도난당한 학생 : -1 
          STU[lost[i]]  =STU[lost[i]]-1; 
        }
        
        for(int i = 1; i < n; i++) {
            if(STU[i] == -1) {//  가운데 학생이 도난 당한 상태에서 
                if(STU[i-1] == 1) { //도난 당한 학생 앞 학생이 한개 가지고 있다면, 
                    STU[i-1] -STU[i] = 0;
                }//첫 번째 , 가운데 학생의 체육복 갯수를 맞춤 앞에 있는 학생 뒤에있는 학생 각각 한 개씩 체육복을 입게됨.
                else if(STU[i+1] == 1) {
                    STU[i+1] = STU[i] = 0;
                }// 맨뒤에 있는 학생이 한 개 가지고 있고  가운데 학생이 
            }
		}
        return answer;
    }
}