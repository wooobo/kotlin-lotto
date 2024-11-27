# kotlin-lotto

# 1단계 - 문자열 덧셈 계산기
## 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 
  - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다. 
  - 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 요구사항 정리
- 입력값
  - 구분자를 가진다
    - `,` 또는 `:`
    - 구분자로 구분된 숫자를 합 할 수 있다.
    - ex) `1,2` => 3, `1,2,3` => 6, `1,2:3` => 6, `` => 0
  - 커스텀 구분자
    - 시작: `//`, 끝:`\n` 사이에 위치하는 문자를 커스텀 구분자이다.
    - ex)  “//;\n1;2;3” => 
      - 구분자 : `;`
      - 결과 : 6
  - 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

## 기능 구현
- [X] 입력값을 구분자로 나눈다.
- [X] 나눈 값을 숫자 리스트로 변환한다.
- [X] 숫자 리스트의 합을 구한다.
- [X] 커스텀 구분자를 사용할 수 있다.
- [X] 숫자 이외의 값 또는 음수s를 전달하는 경우 RuntimeException 예외를 throw 한다.
    
## 1차 피드백
- [X] main 함수 만들기
- [X] 패키지 명 적절하게 변경
- 행동이 아닌 객체가 무엇인지 그 자체의 존재 이유를 명확하게 알 수 있도록 클래스명 만들도록 노력하기

---

# 2단계 - 로또(자동)

## 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

## 요구사항 정리
- 입력값
  - 로또 구입 금액
    - 숫자만 가능
  - 지난주 당첨 금액
    - `,` 로 구분
- 로또
  - 1장의 가격은 1000원
- 로또 구입
  - 구입 금액에 해당하는 로또를 발급한다.
- 통계
  - 3,4,5,6개 일치 통계
  - 수익률 계산
    - 수익률 = (당첨금액 - 로또 구입 금액) / 로또 구입 금액 * 100

## 기능 구현
- [X] 금액
  - [X] 숫자를 받는다
  - [X] 음수 불가
  - [X] 숫자를 받는다
  - [X] 나누기 가능
- [X] Lotto
  - [X] LottoNumber 6개 가짐
  - [X] LottoNumber 중복 불가
  - [X] 일치갯수 알 수 있다
  - [X] 1-45 사이의 숫자 객체
- [X] Lottos
  - [X] Lotto 여러개 가짐
  - [X] Rank를 알 수 있다
- [X] Rank
  - [X] 3,4,5,6개 일치 통계
  - [X] 수익률 계산

### 2차 피드백
- [operator overloading](https://kotlinlang.org/docs/operator-overloading.html) 적용하기
- [https://kotlinworld.com/420](object의 초기화 시점)
- [https://kotlinworld.com/421](data class)
- 객체지향에 대해 고민하기 
- [Initializer functions for lists](https://kotlinlang.org/docs/constructing-collections.html#initializer-functions-for-lists)
- [functional interface](https://kotlinlang.org/docs/fun-interfaces.html)


## 3단계 - 로또(2등)

### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다.
- 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구 사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- Enum 클래스를 적용해 프로그래밍을 구현한다.
- 일급 컬렉션을 쓴다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

### 기능 구현
- [X] 2등
  - [X] 2등은 추가번호가 있다
  - [X] 2등은 보너스번호를 추가 확인한다
  - [X] 당첨은 일치갯수와 추가번호 일치여부로 판단한다

### 3차 피드백
- [typealiases](kotlinlang.org/docs/type-aliases.html)
  - "모든 원시값과 문자열을 포장한다."
- [Kotest For All](https://kotest.io/docs/proptest/property-test-functions.html#for-all)
- [named-arguments](https://kotlinlang.org/docs/functions.html#named-arguments)
  - Rank.kt

## 4단계 - 로또(수동)
### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 기능 구현
#### 로또 번호 입력
- [ ] 수동 번호 구매 가능
  - [ ] 수동 구매 수량 지정 가능
  - [ ] 금액 보다 수동 수량이 많으면 예외 발생
- [ ] 잔여 금액 로또 모두 자동 구매
- [ ] 수동 번호와 자동 번호 조합 하여 최종 로또 목록을 알 수 있다

