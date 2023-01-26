# Object 클래스
* 모든 클래스의 최고 조상
* 11개의 메서드만을 가지고 있음
  * notify(), wait() 등은 쓰레드와 관련된 메서드  
<br>
### `equals(Object obj)`
* 객체 자신(this)과 주어진 객체(obj)를 비교
* Object 클래스의 equals()는 객체의 주소(참조변수 값)를 비교
* 같으면 true, 다르면 false 반환
```java
    public boolean equals(Object obj) {
        return (this == obj);
    }
```
* equals(Object obj)의 오버라이딩
  * 인스턴스 변수(iv) 값을 비교하도록 equals()를 오버라이딩  
<br/>

### `hashCode()`
* 객체의 해시코드를 반환하는 메서드
* 객체의 주소를 int로 변환해서 반환
* equals()를 오버라이딩하면, hashCode()도 오버라이딩 해야함
  * equals()의 결과가 true인 두 객체의 해시코드는 같아야하기 때문
* System.identityHashCode(Object obj)는 Object 클래스의 hashCode()와 동일  

<br/>

### `toString()`
* 객체를 문자열(String)로 변환하기 위한 메서드
<br/>
<br/>
# String 클래스
* 데이터(char[]) + 메서드(문자열 관련)
* 내용을 변경할 수 없는 불변(immutable) 클래스
* 덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐
* 문자열의 결합이나 변경이 잦다면, 내용을 변경 가능한 StringBuffer 사용

### `문자열 리터럴`
* 문자열 리터럴은 프로그램 실행 시 자동으로 생성 (constanct pool에 저장)  
<br/>
### `빈 문자열 ("", empty string)`
* 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열
* 크기가 0인 배열을 생성하는 것은 어느 타입이나 가능  
 <br/>

### `join()과 StringJoiner` 
* join()은 여러 문자열 사이에 구분자를 넣어서 결합  
<br/>

### `문자열과 기본형 간의 변환`
* 숫자를 문자열로 바꾸는 방법
```java
    int i = 100;
    String str1 = i + "";               // 100을 "100"으로 변환하는 방법1
    String str2 = String.valueOf(i);    // 100을 "100"으로 변환하는 방법2
```
* 문자열을 숫자로 바꾸는 방법
```java
    int i = Integer.parseInt("100");     // "100"을 100으로 변환하는 방법1
    int i2 = Integer.valueOf("100");     // "100"을 100으로 변환하는 방법2
    Integer i2 = Integer.valueOf("100"); // 원래는 반환 타입이 Integer
```  
<br/>
<br/>

# StringBuffer 클래스
* String처럼 문자형 배열(char[])을 내부적으로 가지고 있음
* String과 달리 내용을 변경할 수 있음 (mutable)
* 배열은 길이 변경불가하므로 공간이 부족하면 새로운 배열 생성해야 함
* StringBuffer는 저장한 문자열의 길이를 고려해서 적절한 크기로 생성해야 함
* append()는 지정된 내용을 StringBuffer에 추가 후, StringBuffer의 참조를 반환
* StringBuffer는 equals()가 오버라이딩 되어있지 않음 (주소비교)
  * String으로 변환 후 equals()로 비교해야 함  
    <br/>
    <br/>

# StringBuilder 클래스
* StringBuffer는 동기화 되어있어 멀티 쓰레드에 안전(thread-safe)
* 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능 저하
  * 이럴 때 StringBuffer 대신 StringBuilder를 사용하면 성능 향상  
    <br/>
    <br/>

# Math 클래스
* 수학 관련 static 메서드의 집합 
 <br/>
  <br/>

# 래퍼(Wrapper) 클래스
* 8개의 기본형을 객체로 다뤄야 할 때 사용하는 클래스
  * 기본형 - 래퍼클래스
    * boolean - Boolean
    * char - Character
    * byte - Byte
    * short - Short
    * int - Integer
    * long - Long
    * float - Float
    * double - Double  

<br/>
<br/>

# Number 클래스
* 모든 숫자 래퍼클래스의 조상  
<br/>
 <br/>

# 변환
### `문자열 -> 숫자`
```java
    int i = new Integer("100").intValue();
    int i2 = Integer.parseInt("100"); // 가장 많이 사용하는 방법
    int i3 = Integer.valueOf("100");
    
    // n진법 문자열 변환
    int i4 = Integer.parseInt("100", 2);     // 100(2) -> 4
    int i5 = Integer.parseInt("100", 8);     // 100(8) -> 64
    int i6 = Integer.parseInt("100", 16);    // 100(16) -> 256 
    int i7 = Integer.parseInt("FF", 16);     // FF(16) -> 25
    int i8 = Integer.parseInt("FF");         // Error. NumberFormatException 
```  
<br/>
<br/>

# 오토박싱 & 언박싱
* JDK1.5 이전에는 기본형과 참조형간의 연산 불가능
* 기본형의 값을 객체로 자동 변환하는 것을 오토박싱, 반대는 언박싱