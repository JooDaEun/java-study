# 프로그램 오류
### `종류`
* 컴파일 에러(compile-time error) : 컴파일 할 때 발생하는 에러  
<br/>
* 런타임 에러(runtime error) : 실행할 때 발생하는 에러
  * 에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
  * 예외(exception) : 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
    * Exception 클래스 + 자손 클래스 : 사용자의 실수와 같은 외적인 요인에 의해 발생
    * RuntimeException 클래스 + 자손 클래스 : 프로그래머의 실수로 발생  
<br/>  
* 논리적 에러(logical error) : 작성 의도와 다르게 동작 

<br/>
<br/>
 
# 예외처리
### `정의`
* 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성
### `목적`
* 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
### `종류`
* checked 예외
  * 컴파일러가 예외 처리 여부를 체크 (예외 처리 필수)
  * Exception 클래스 + 자손 클래스  
  <br/>
* unckecked 예외
  * 컴파일러가 예외 처리 여부를 체크하지 않음 (예외 처리 선택)
  * RuntimeException 클래스 + 자손 클래스  
<br/>

### `예외처리방법1 - try-catch문`
```java
    try {
        // 예외가 발생할 가능성이 있는 문장
    } catch (Exception1 e1) {
        // Exception1이 발생했을 경우, 처리할 문장
    } catch (Exception2 e1) {
        // Exception2가 발생했을 경우, 처리할 문장
    } catch (ExceptionN eN) {
        // ExceptionN이 발생했을 경우, 처리할 문장
    }
```
* try블럭 내에서 예외 발생한 경우
  * 발생한 예외와 일치하는 catch 블럭이 존재하는지 확인
  * 일치하는 catch 블럭 내의 문장을 수행하고 전체 try-catch문을 빠져나감
  * 일치하는 catch 블럭을 찾지 못하면 예외 처리 불가능  
  <br/>

* try블럭 내에서 예외가 발생하지 않은 경우
  * catch 블럭을 거치지 않고 전체 try-catch문을 빠져나감  
<br/>

### `printStackTrace()와 getMessage()`  
* printStackTrace() 
  * 예외 발생 당시의 호출 스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력  
<br/>
* getMessage() 
  * 발생한 예외클래스의 인스턴스에 저장된 메세지를 얻을 수 있음  
<br/>
  
### `멀티 catch 블럭`
* 내용이 같은 catch블럭을 하나로 합친 것
* 부모 자식 관계인 exception인 경우 부모만 작성
* 선언된 여러개 중 하나의 exception에 선언된 method는 호출 불가능
  * 선언된 여러개의 공통멤버만 사용
  * if문으로 instanceof 체크해서 사용하면 가능  

<br/>

### `예외처리방법2 - 예외 선언하기`
* 메서드가 호출시 발생가능한 예외를 호출한 쪽에 알리는 것
 ```java
    void method() throws Exception1, Exception2, ... , ExceptionN {
        // 메서드의 내용
    }
    
    void method() throws Exception {
        // 메서드의 내용
    }
```  
<br/>

### `finally 블럭`
* 예외 발생여부와 관계없이 수행되어야 하는 코드를 넣음
* 코드의 중복을 줄일 수 있음
* try블럭 내에 return문이 있어서 try 블럭을 벗어날 때에도 실행
```java
    try {
           // 예외 발생할 가능성이 있는 문장
    } catch (Exception1 e1) {
           // 예외처리를 위한 문장
    } finally {
           // 예외의 발생여부에 관계없이 항상 수행되어야 하는 문장
           // try-catch문의 마지막에 위치
    }
```  
<br/>

### `사용자 정의 예외 만들기`
* 직접 예외 클래스를 정의할 수 있음
* 조상은 Exception과 RuntimeException 중에서 선택
```java
  class MyException extends Exception {
        MyException (String msg) {   // 문자열을 매개변수로 받는 생성자
            super(msg);              // 조상인 Exception 클래스의 생성자 호출
        }  
  }
```   

<br/>

### `예외 되던지기 (Exception re-throwing)`
* 예외를 처리한 후에 다시 예외를 발생시키는 것
* 호출한 메서드와 호출된 메서드 양쪽 모두에서 예외처리하는 것  
<br/>

### `연결된 예외 (Chained Exception)`
* 한 예외가 다른 예외를 발생시킬 수 있음
* 예외 A가 예외 B를 발생시키면 A는 B의 원인 예외(Cause Exception)
* 여러 예외를 하나로 묶어서 다루기 위해 사용
* checked 예외를 unchecked 예외로 변경하기 위해 사용
```java
  Throwable initCause(Throwable cause)   지정한 예외를 원인 예외로 등록
  Throwable getCause()                   원인 예외를 반환
```