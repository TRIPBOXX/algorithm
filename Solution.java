class Solution {
  public String solution(String s, int n) {
    char[] input = s.toCharArray();
      String answer = "";
      //1.���ĺ� a~z (A~Z):  ���� �� 26�� 
      //2.������ ����� ����ϴ� ����(x = y *z + gama)
     //���ĺ� ������ : A / a ��  ����� ��ġ , ������ ��ġ�� ���� ����ġ 
    
      
        for(int i = 0 ; i < input.length ; i++) {
            if(input[i] != ' ') {//i�迭�� ���
                if(input[i] >= 'a') { // ������: a���� 26��~
                    //  ������ ��ġ  ���� ����� ��ġ��  ����ġ 
                   //n��ŭ �а� %ó�� -> �ٽ� ������� ���� 
                    answer += (char)((input[i] - 'a' + n) % 26 +'a');
                    // ������ a�������� ���� n��ŭ �̵���Ų�� %ó�� �� �ٽ� ������� ��
                }else { //������: A�������� ���� n��ŭ �̵���Ų�� %ó�� �� �ٽ� ������� ��
                    answer += (char)((input[i] - 'A' + n) % 26 +'A');
                }
                }else {
                answer += " ";
            }
        }
            return answer;
    }
}