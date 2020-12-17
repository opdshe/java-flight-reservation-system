# 👨🏻‍💻 항공 예약 시스템

### 초기 정보 세팅 기능
- 원하는 데이터로 초기 정보를 세팅할 수 있어야 한다

### 항공편 예약 기능
- 모든 항공편을 조회할 수 있다
- 출발지, 목적지 도시 이름으로 항공편을 조회할 수 있다
- 항공편 구매는 항공편 ID를 입력받아 진행한다
- 구매 목록에 있는 항공편의 도착시간과 새로 구매하려는 항공편의 출발시간의 시간 차이가 48시간 이하이면 구매 불가
 
### 마이 페이지 기능
- 구매한 항공편을 취소할 수 있다
- 잔고를 확인할 수 있다
- 잔고에 돈을 입금할 수 있다
 
### 관리자 기능
- 도시를 추가할 수 있다
    - 하나의 도시는 여러개의 공항을 가질 수 있다
- 도시를 삭제할 수 있다
- 공항을 추가할 수 있다
- 공항을 삭제할 수 있다
- 항공편을 추가할 수 있다
- 항공편을 삭제할 수 있다
<br>

## 🎱 프로그래밍 요구사항
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 `[ERROR]` 로 시작해야 한다.
<br>


## 구현해야 할 기능 목록
[항공편 관련 기능]
- 모든 공편 조회 기능
    - [x] 모든 항공편을 조회할 수 있다
 
- 출발지 목적지 기반 항공편 조회기능
    - [x] 출발지와 목적지를 기반으로 항공편을 조회할 수 있다
    - [x] 조건에 맞는 항공편이 없으면 예외 발생
 
- 항공편 구매 기능
    - [x] 티켓 저장소에 티켓을 추가할 수 있다
    - [x] 항공편 ID를 기반으로 항공편을 구매할 수 있다
    - [x] 일치하는 항공편이 없으면 예외 발생해야 한다
    - [x] 내가 구매한 항공편의 도착시간과의 시간차이가 48시간 이하인 티켓은 구매할 수 없다
    - [x] 항공편 구매 시 금액 만큼 잔고에서 돈이 출금되어야 함
    - [x] 내 잔고를 초과하는 티켓은 구매할 수 없다
 
[마이 페이지 기능]
- 구매한 항공편 취소 기능
    - [x] 내가 구매한 목록에서 취소한 항공편이 사라져야 함
    - [ ] 항공편 취소 기능이 실행되면 내가 구매한 항공편 목록을 출력해야한다
    - [x] 취소는 항공편 ID를 기반으로 진행한다
    - [x] 구매 목록에 없는 항공편 ID 입력시 예외 발생해야 함

- 통장 잔고 확인 기능
    - [x] 내 통장 잔고를 조회할 수 있다

- 입금 기능
    - [x] 입력받은 금액만큼 통장에 돈을 입금할 수 있다
 
[관리자 기능]
- 도시 추가 기능
    - [x] 도시 저장소에 도시를 추가할 수 있다
    - [x] 사용자가 입력한 공항을 추가할 수 있다
    - [ ] 이미 존재하는 공항이면 예외 발생
    
- 도시 삭제 기능
    - [ ] 도시 저장소에서 도시를 삭제할 수 있다.
    - [ ] 사용자가 입력한 도시를 삭제할 수 있다
    - [ ] 존재하지 않는 도시는 예외 발생
    
- 공항 추가 기능
    - [x] 공항 저장소에 공항을 추가할 수 있다 
    - [ ] 사용자가 입력한 공항을 추가할 수 있다
    - [ ] 이미 존재하는 공항이면 예외 발생

- 공항 삭제 기능
    - [ ] 공항 저장소에서 공항을 삭제할 수 있다
    - [ ] 축약어(ICN) 기반으로를 공항을 삭제할 수 있다
    - [ ] 공항 삭제 기능이 실행되면 현재 존재하는 공항 목록을 출력해야 함
    - [ ] 존재하지 않는 공항이면 예외 발생

- 항공편 추가 기능
    - [x] 항공편 저장소에서 항공편을 추가할 수 있다
    - [ ] 사용자가 입력한 값을 기반으로 항공편을 추가할 수 있다
    - [ ] 항공편 ID는 세자리 랜덤숫자를 배정한다
    - [ ] 이미 존재하는 항공편이면 예외 발생해야함 (항공편 ID가 같으면)

- 항공편 삭제 기능
    - [ ] 항공편 저장소에서 항공편을 삭제할 수 있다
    - [ ] 항공편 ID를 기반으로 항공편을 삭제할 수 있다
    - [ ] 해당 항공편을 내가 구매했으면 삭제할 수 없다
 
 


 
