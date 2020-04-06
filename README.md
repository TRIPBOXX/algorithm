# algorithm
# 알고리즘 스터디


## 수박수박수박수박수박수박수박수박수박수박수박수박수박수박수
   
<pre>
https://programmers.co.kr/learn/courses/30/lessons/12922?language=java
</pre>

<pre>
홀수 1부터 수 , 2 : 박 , 3: 수 , 4: 박 ,..이런식으로 값을 할당.
i값 도는만큼 수박수..찍히게 로직
</pre>
<details><summary>[코드보기]</summary>
	

	
```java

class SuBak {
  public String solution(int n) {
     String answer = "";
      for(int i = 1 ; i <= n ; i ++){
          if(i%2!=0){
              answer += "수";
          }else
              answer += "박";
      }
      return answer;
  }
}
 ```
 
 
 </details>
 
 예제는 https://programmers.co.kr/ 의 문제를 사용하였습니다. 예제의 저작권은 (주)그랩에 있습니다

