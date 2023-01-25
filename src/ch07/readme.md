# * 상속 (Inheritance)
   * 기존의 클래스로 새로운 클래스를 작성하는 것 (코드의 재사용)
   * 두 클래스를 부모와 자식으로 관계를 맺어주는 것
   * 자손은 조상의 모든 멤버를 상속받음 (생성자, 초기화블럭 제외)
   * 자손의 멤버 개수는 조상보다 같거나 많음
   * 자손의 변경은 조상에 영향을 미치지 않음
   ``` java
   class 자식클래스 extends 부모클래스 { }
   class Child extends Parent { }
   ```
<br/>
<br/>

# * 포함 (Composite)
 * 클래스의 멤버로 참조변수를 선언하는 것 
``` java
class Point {
    int x;
    int y;
}

class Circle {
    Point c = new Point();
    int r;
}    
```
<br/>
<br/>

# * 클래스간의 관계 설정하기
 * 상속관계 : ~은 ~이다 (is-a)
 * 포함관계 : ~은 ~을 가지고 있다 (has-a)
   <br/>
   <br/>

# * 단일 상속(Single Inheritance)
 * Java는 단일 상속(하나의 부모)만을 허용
 * C++은 다중상속을 허용
   <br/>
   <br/>
# * Object Class
 * 모든 클래스의 조상
 * 부모가 없는 클래스는 자동적으로 Object 클래스를 상속 받음
 * 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속 받음
   * toString(), equals(Object obj), hashCode(), ...
     <br/>
     <br/>

# * 오버라이딩 (Overriding)
* 상속받은 조상의 메서드를 자신에 맞게 변경하는 것
* 선언부 변경 불가, 구현부만 변경

### `조건`
1. 선언부가 조상 클래스의 메서드와 일치해야 함
2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경 불가
3. 예외는 조상 클래스의 메서드보다 많이 선언 불가

### `오버로딩 vs 오버라이딩`
* 오버로딩(Overloading) : 기존에 없는 새로운 메서드를 정의 (new)
* 오버라이딩(Overriding) : 상속받은 메서드의 내용을 변경 (modify)
  <br/>
  <br/>

# * super
### `참조변수 super`
* 객체 자신을 가리키는 참조변수
* 인스턴스 메서드(생성자)내에서만 존재
* static 메서드에 사용 불가
* 조상의 멤버를 자신의 멤버와 구별할 때 사용

### `조상의 생성자 super()`
* 조상의 생성자를 호출할 때 사용
* 조상의 멤버는 조상의 생성자를 호출해서 초기화
* 추가 조건
  * 생성자의 첫 줄에 반드시 생성자를 호출해야 함
  * 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super(); 를 삽입
    <br/>
    <br/>

# * 패키지 (Package)
### `개념`
* 서로 관련된 클래스의 묶음
* 클래스는 클래스 파일(*.class), 패키지는 폴더
* 클래스의 실제 이름은 패키지를 포함 (java.lang.String)
* rt.jar은 클래스들을 압축한 파일 (경로 : `JDK 설치 경로\jre\lib`) 

### `선언`
* 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
* 같은 소스 파일의 클래스들은 모두 같은 패키지에 속함
* 패키지 선언이 없다면 이름 없는(unnamed) 패키지에 속하게 됨
  <br/>
  <br/>

# * 클래스 패스(Class Path)
* 클래스 파일의(*.class)의 위치를 알려주는 경로
* 환경변수 classpath로 관리하며, 경로간 구분자는 세미콜론(;) 사용
* 환경변수(classpath)에 패키지의 루트를 등록해 주어야 함
  <br/>
  <br/>

# * import문
### `개념`
* 클래스를 사용할 때 패키지 이름 생략 가능
* 컴파일러에게 클래스가 속한 패키지를 알려줌
* java.lang 패키지의 클래스는 import 하지 않고도 사용할 수 있음
  * String, Object, System, Thread, ...
  
### `선언`
* 패키지문과 클래스 선언 사이에 선언되어야 함
  * `import 패키지명.클래스명;`
  * `import 패키지명.*;`

* 컴파일 시에 처리되므로 프로그램의 성능에 영향 없음
* 이름이 같은 클래스가 속한 두 패키지를 import할 때에는 클래스 앞에 패키지명을 붙여야 함

### `static import문`
* static 멤버를 사용할 때 클래스 이름을 생략할 수 있게 해줌
``` java
  import static java.lang.Integer.*;   // Integer 클래스의 모든 static 메서드
  import static java.lang.Math.random; // Math.random()만. 괄호 안붙임
  import static java.lang.System.out;  // System.out을 out만으로 참조 가능
  
  out.println(random());
```
<br/>
<br/>

# * 제어자 (Modifier)
* 클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여
* 하나의 대상에 여러 제어자를 함께 사용 가능 (접근 제어자는 가장 왼쪽에 하나만 사용)
### 접근제어자
  * public, protected, (default), private  
    * `public` : 접근 제한 전혀 없음  
    * `protected` : 같은 패키지 내에서, 다른 패키지의 자손클래스에서 접근 가능  
    * `(default)` : 같은 패키지 내에서만 접근 가능  
    * `private` : 같은 클래스 내에서만 접근 가능  
<br/>

  
### 그 외 제어자
  * static, final, abstract, native, transient, synchronized, volatile, strictfp  
#### `static` - 클래스의, 공통적인
   * 멤버변수에 붙는 경우
     * 모든 인스턴스에 공통적으로 사용하는 클래스 변수가 됨
     * 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능
     * 클래스가 메모리에 로드될 때 생성  
     <br/>
   * 메서드에 붙는 경우
      * 인스턴스를 생성하지 않고도 호출 가능한 static 메서드가 됨
      * static 메서드 내에서는 인스턴스 멤버들을 직접 사용 가능  
     ```java
     class StaticTest {
        static int width = 200;             // 클래스 변수 (static 변수)
        static int height = 120;            // 클래스 변수 (static 변수)
     
        static {                            // 클래스 초기화 블럭
                    ...                     // static 변수의 복잡한 초기화 수행
        }
     
        static int max(int a, int b) {      // 클래스 메서드 (static 메서드)
            return a > b ? a : b;
        }
     }
     ```
<br/>

#### `final` - 마지막의, 변경될 수 없는
  * 클래스에 붙는 경우
    * 변경될 수 없는 클래스, 확장할 수 없는 클래스가 됨
    * final로 지정된 클래스는 다른 클래스의 조상이 될 수 없음  
    <br/>
  * 메서드에 붙는 경우
    * 변경될 수 없는 메서드
    * final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없음  
    <br/>
  * 멤버변수/지역변수에 붙는 경우
    * 변수 앞에 final이 붙으면 상수가 됨
```java
  final class FinalTest {             // 조상이 될 수 없는 클래스
      final int MAX_SIZE = 10;        // 값을 변경할 수 없는 클래스
      
      final void getMaxSize() {       // 오버라이딩 할 수 없는 메서드 (변경불가)
          final int LV = MAX_SIZE;    // 값을 변경할 수 없는 지역변수 (상수)
          return MAX_SIZE;
      }
  }
```  
<br/>

#### `abstract` - 추상의, 미완성의
  * 클래스에 붙는 경우 - `추상 클래스`
    * 클래스 내에 추상 메서드가 선언되어 있음을 의미  
    * 다른 클래스 작성에 도움을 주기 위한 것으로 인스턴스 생성 불가 
    * 상속을 통해 추상 메서드를 완성해야 인스턴스 생성 가능  
    * 여러 클래스에 공통으로 사용될 수 있는 추상클래스를 바로 작성하거나,  
    기존 클래스의 공통 부분을 뽑아서 추상 클래스를 생성  
<br/>
  * 메서드에 붙는 경우 - `추상 메서드`
    * 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알림
    * 미완성 메서드로 구현부(몸통 { })가 없음 `abstract 리턴타입 메서드이름();`
    * 꼭 필요하지만 자손마다 다르게 구현될 것으로 예상되는 경우 사용
    * 추상 메서드 호출 가능 (호출할때는 선언부만 필요)
```java
    abstrct class AbstractTest {            // 추상 클래스 (추상 메서드를 포함한 클래스)
        abstract void move();               // 추상 메서드 (구현부가 없는 메서드)
}

    AbstractTest a = new AbstractTest();    // 에러. 추상 클래스의 인스턴스 생성 불가
```  
<br/>
<br/>

# * 캡슐화 
* 접근제어자를 사용하는 이유 
  * 외부로부터 데이터를 보호하기 위해
  * 내부적으로만 사용되어 외부에 노출이 불필요한 부분을 감추기 위해
```java
  public class Time {
        // 접근제어자를 private으로 하여 외부 접근을 막음
        private int hour;
        private int minute;
        private int second;
        
        // 메서드는 public으로 하여 간접 접근을 허용
        public int getHour() { return hour; }
        public void setHour(int hour) {
                if (hour < 0 || hour > 23) return;
                this.hour = hour;
        }
}
```  
<br/>
<br/>

# * 다형성(Polymorphism)
* 여러 가지 형태를 가질 수 있는 능력
* 조상 타입의 참조변수로 자손 타입 객체를 다루는 것
* 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 없음  
  ```java
  SmartTv s = new SmartTv();   // 참조 변수와 인스턴스 타입이 일치
  Tv t = new SmartTv();        // 조상 타입 참조변수로 자손 타입 인스턴스 참조
  ```

  <br/>
### `참조변수의 형변환`
* 사용할 수 있는 멤버의 개수를 조절하는 것
* 조상 자손 관계의 참조변수는 서로 형변환 가능  
  <br/>

### `instanceof 연산자`
* 참조변수의 형변환 가능 여부 확인에 사용, 가능하면 true 반환
* 형변환 전에 반드시 instanceof로 확인해야 함
    ```java
        void doWork(Car c) {
            if (c instanceof FireEngine) {       // 1. 형변환이 가능한지 확인
                FireEngine fe = (FireEngine)c;   // 2. 형변환
                fe.water();
            }                 
        } 
    ```  
  <br/>

### `다형성의 장점`
1. 다형적 매개변수
    * 참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있음

   
2. 하나의 배열에 여러 종류의 객체 저장 가능
    * 조상타입의 배열에 자손들의 객체를 담을 수 있음
   ```java
    Product p[] = new Product[3];
    p[0] = new Tv();
    p[1] = new Computer();
    p[2] = new Audio();
    ```  
   <br/>
   <br/>
# 인터페이스 (Interface)
### `개념`
* 추상 메서드의 집합
* 구현된 것이 전혀 없는 설계도. 껍데기 (모든 멤버가 public)
* 추상클래스와 달리 iv를 가질 수 없음
```java
    interface 인터페이스이름 {
        public static final 타입 상수이름 = 값;
        public abstract 메서드이름(매개변수목록);    
    }   
    
    interface PlayingCard {
        // 상수는 항상 public static final이므로 생략도 가능
        public static final int SPADE = 4;
        final int DIAMOND = 3;
        static int HEART = 2;
        int CLOVER = 1;
        
        public abstract String getCardNumber();
        String getCardKind();   // public abstract String getCardKind();
                                // 메서드는 항상 public abstract이므로 생략 가능
    }
```
### `상속`
* 인터페이스의 조상은 인터페이스만 가능 (Object가 최고 조상이 아님)
* 다중 상속 가능 (추상메서드는 충돌해도 문제 없음)  

### `구현`
* 인터페이스에 정의된 추상 메서드를 완성하는 것
* 일부만 구현하는 경우, 클래스 앞에 `abstract`를 붙여야 함
```java
    class 클래스이름 implements 인터페이스이름 {    
        // 인터페이스에 정의된 추상메서드를 모두 구현해야 함
}
```  
### `인터페이스를 이용한 다형성`
* 인터페이스도 구현 클래스의 부모와 비슷한 역할
* 인터페이스 타입 매개변수는 인터페이스 구현한 클래스의 객체만 가능
* 인터페이스를 메서드의 리턴타입으로 지정할 수 있음  

### `장점`
* 두 대상(객체)간의 연결을 돕는 중간 역할
* 선언(설계)과 구현을 분리
* 개발 시간 단축
* 변경에 유리한 유리한 설계 가능
* 표준화 가능
* 서로 관계 없는 클래스들의 관계를 맺어줄 수 있음  


### `디폴트 메서드와 static 메서드`
* 인터페이스에 디폴트 메서드, static 메서드 추가 가능
* 인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움 (디폴트 메서드로 해결)ㅣ
* 디폴트 메서드는 인스턴스 메서드(인터페이스 원칙 위반)
* 디폴트 메서드가 기존의 메서드와 충돌할 때 해결책
  * 여러 인터페이스의 디폴트 간의 충돌 
    *  인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩
  * 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
    * 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시됨
<br/>
<br/>

# 내부 클래스 (Inner class)
* 클래스 안의 클래스
* 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근 가능
* 코드의 복잡성을 줄일 수 있음 (캡슐화)  
<br/>
<br/>
# 익명 클래스 (Anonymous class)
* 이름이 없는 일회용 클래스
* 정의와 생성을 동시에 진행
