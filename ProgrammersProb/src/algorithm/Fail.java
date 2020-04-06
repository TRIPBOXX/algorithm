import java.util.*;// list import���ؼ�

class Solution {
    class Fail{
        int stage;
        double rate;
        Fail(int stage, double rate ) {
            this.stage = stage;
            this.rate =rate;
        }
    }
    Comparator<Fail> comp = new Comparator<Fail>(){// comprator��ü����
        //compare �޼ҵ� ������
        public int compare(Fail a, Fail b) {
            if(a.rate<b.rate)  
                return 1; // ������ Ŭ���� �տ��´�.(����1) 
            else if(a.rate>b.rate)
                return -1; // �׷��������� ���� -1
            else {// ������ �������
                if(a.stage>b.stage)
                    return 1;  //�������� ��ȣ�� ������ ������ �ð�� 
                else if(a.stage<b.stage)// ����������ȣ�� Ŭ���� -1����
                    return -1;
                else // �׿� ������ ���
                    return 0;
            }//���ĿϷ�!
        }
    };
    
    public int[] solution(int N, int[] stages) {
        int[] answer =  new int[N];
        List<Fail> fails = new ArrayList<Fail>();//fail type list ����
        int total = stages.length;// �Է¹��� stage�迭ũ��� ����
        
        //user�� �ε��� = stage�� ��ȣ -> �� ���� �������� ��ȣ�� ������ �����
        // stage ��ȣ �� �־ �������� ������ Ŭ���� �ѻ���� 
// stage  ��ȣ ���� �Ѵܰ� �Ʒ� (�۴�)
        int [] users = new int[N+1 ]; // ��, N+1�� ������ �������� Ŭ�����ѻ��Ť��ڸ���Ÿ����.
            for(int s : stages)//  ������������ ������ users ī��Ʈ
                users[s-1 ] ++ ;//stage �ε��� �ϳ�������( 1�� stage�� 0���ε����� ����)
   
    //���������� ����ڼ�: users array��ȸ�� �ϸ鼭
   //������ �������� ���Ѵ�.

             for ( int i = 0; i < N; ++i ) {
                 if(users[i] ==0)//0�϶� �����ǽ���
                     fails.add(new Fail(i+1,0));//������ 0���� �ؼ� �߰�
             else{
                     fails.add(new Fail(i+1, (double)users[i]/total));
        // ���� ���������� ������ ����ڼ�(Ŭ�������) ��ü����ڼ�-> double�� �Ǽ�  Ÿ��ĳ������
            total = total - users[i];// ���� �������� �ӹ����ִ� ����ڴ� ������������ ���� ������ ���
    }
}
        Collections.sort(fails, comp);       //������ ���� coparator���� �Ϸ�����Ƿ�
        for(int i =0; i<N; ++i )   //answer array�� ���� ���ִ°���
            answer[i]   = fails.get(i).stage;  //stage�� answer�� �־���
                return answer;//return!
    }
}