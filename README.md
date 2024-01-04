# 코딩테스트 학습 레포지토리

## <이것이 취업을 위한 코딩테스트다> 도서를 통해 학습한 내용들을 정리.


---
## 97 Things Every Programmer Should Know
1. Act with Prudence: 신중하게 행동하기. Technical debt(미룬 일들)를 최대한 빠르게 해결해내자. 시간이 지날수록 겉잡을 수 없이 해결하기 어려워진다.
2. Apply Functional Programming Priciples: 함수형 프로그래밍의 적용으로 고차원의 referential transparency를 적용할 수 있다.
   > ## Referential Transparency
   >
   > 어디에던, 어느때건 함수가 같은 입력값에 대해 일관되게 같은 결과를 보여줌을 암시한다. 즉 변화하는 상태에 부작용에 강하다는 의미이기도 하다. Mock Roles, not Objects.
3. Ask "What Would the User Do?": 개발자들은 다른 사람들도 우리와 같이 생각한다고 착각한다(false consensus bias). 사용자들의 생각을 읽기 위해서는 그들을 관찰하는 것이 중요하다.
4. Automate Your Coding Standard: 코드 포맷팅(Code Formatting)은 과제 진행 중 가장 포기하기 쉬운 문제이다. 코드를 표준화 하는 것은 다른 개발자들과 소통하기 위함이며, 안티패턴을 빠르게 찾고 방지하기 위함이니, 이를 자동화 하고 동적으로 적용할 수 있도록 하자.
5. Beauty Is in Simplicity: Readability, Maintainability, Speed of development, The elusive quality of beauty의 목표를 달성하기 위해 궁극적으로 Simple하게 작성하는 것이 중요하다. 각각의 파트가 간단한 responsibility와 간단한 relationship을 맺고 있어야한다.
6. Before You Refactor: 기존 코드를 점검하고 테스트를 재작성하기. 모든 것을 재작성 하지 않기. 한번에 확 변화시키기보다는 조금씩 여러번 변화하기. 테스트에 통과하는지 지속 점검하기. 새로운 기술이라고 무조건적으로 적용하지 않기.
7. Beware the Share: 문맥(Context)를 확인하자. 적절치 못한 의존성의 남용은 가치가 떨어진다. (솔직히 그렇게 이해 안됨...)