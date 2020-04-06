import java.util.*;// list import위해서

class Solution {
    class Fail{
        int stage;
        double rate;
        Fail(int stage, double rate ) {
            this.stage = stage;
            this.rate =rate;
        }
    }
    Comparator<Fail> comp = new Comparator<Fail>(){// comprator객체생성
        //compare 메소드 구현부
        public int compare(Fail a, Fail b) {
            if(a.rate<b.rate)  
                return 1; // 실패율 클수록 앞에온다.(리턴1) 
            else if(a.rate>b.rate)
                return -1; // 그렇지않으면 리턴 -1
            else {// 실패율 같은경우
                if(a.stage>b.stage)
                    return 1;  //스테이지 번호가 작은게 앞으로 올경우 
                else if(a.stage<b.stage)// 스테이지번호가 클수록 -1리턴
                    return -1;
                else // 그외 나머지 경우
                    return 0;
            }//정렬완료!
        }
    };
    
    public int[] solution(int N, int[] stages) {
        int[] answer =  new int[N];
        List<Fail> fails = new ArrayList<Fail>();//fail type list 선언
        int total = stages.length;// 입력받은 stage배열크기와 같음
        
        //user의 인덱스 = stage의 번호 -> 그 값은 스테이지 번호에 도달한 사용자
        // stage 번호 에 있어서 스테이지 마지막 클리어 한사람은 
// stage  번호 보다 한단계 아래 (작다)
        int [] users = new int[N+1 ]; // 단, N+1은 마지막 스테이지 클리어한사요ㅕㅇ자를나타낸다.
            for(int s : stages)//  각스테이지에 도달한 users 카운트
                users[s-1 ] ++ ;//stage 인덱스 하나씩증가( 1번 stage는 0번인덱스에 저장)
   
    //각스테이지 사용자수: users array순회를 하면서
   //각각의 실패율을 구한다.

             for ( int i = 0; i < N; ++i ) {
                 if(users[i] ==0)//0일때 무조건실패
                     fails.add(new Fail(i+1,0));//실패율 0으로 해서 추가
             else{
                     fails.add(new Fail(i+1, (double)users[i]/total));
        // 현재 스테이지에 도달한 사용자수(클리어못한) 전체사용자수-> double로 실수  타입캐스팅함
            total = total - users[i];// 지금 스테이지 머물고있는 사용자는 다음스테이지 못간 실패한 사람
    }
}
        Collections.sort(fails, comp);       //실패율 정렬 coparator에서 완료됏으므로
        for(int i =0; i<N; ++i )   //answer array에 값을 써주는과정
            answer[i]   = fails.get(i).stage;  //stage를 answer에 넣어줌
                return answer;//return!
    }
}