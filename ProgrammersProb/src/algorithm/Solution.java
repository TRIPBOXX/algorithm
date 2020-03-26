package algorithm;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int [] STU = new int[n+1];
        //�л��� ���ٷ� �� ������ ��, �������� �迭�� �Ҵ��ϰ� 
        for(int i = 0; i < reserve.length; i++) { // �⺻�л�(ü���� ���� 1���� �ִ� �л�)
          
			STU[reserve[i]] = STU[reserve[i]] + 1;
        }
        
        for(int i = 0; i < lost.length; i++) {//  �������� �л� : -1 
          STU[lost[i]]  =STU[lost[i]]-1; 
        }
        
        for(int i = 1; i < n; i++) {
            if(STU[i] == -1) {//  ��� �л��� ���� ���� ���¿��� 
                if(STU[i-1] == 1) { //���� ���� �л� �� �л��� �Ѱ� ������ �ִٸ�, 
                    STU[i-1] -STU[i] = 0;
                }//ù ��° , ��� �л��� ü���� ������ ���� �տ� �ִ� �л� �ڿ��ִ� �л� ���� �� ���� ü������ �԰Ե�.
                else if(STU[i+1] == 1) {
                    STU[i+1] = STU[i] = 0;
                }// �ǵڿ� �ִ� �л��� �� �� ������ �ְ�  ��� �л��� 
            }
		}
        return answer;
    }
}