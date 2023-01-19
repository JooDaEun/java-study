# Chapter7. 객체지향개념 2


## 상속 (Inheritance)
 ### 개념
   * 기존의 클래스로 새로운 클래스를 작성하는 것 (코드의 재사용)
   * 두 클래스를 부모와 자식으로 관계를 맺어주는 것
   * 자손은 조상의 모든 멤버를 상속받음 (생성자, 초기화블럭 제외)
   * 자손의 멤버 개수는 조상보다 같거나 많음
   * 자손의 변경은 조상에 영향을 미치지 않음
   ```
   class 자식클래스 extends 부모클래스 { }
   class Child extends Parent { }
   ```


## 포함 (Composite)
### 개념
 * 클래스의 멤버로 참조변수를 선언하는 것 
```
class Point {
    int x;
    int y;
}

class Circle {
    Point c = new Point();
    int r;
}    
```


## 클래스간의 관계 설정하기
 * 상속관계 : ~은 ~이다 (is-a)
 * 포함관계 : ~은 ~을 가지고 있다 (has-a)


## 단일 상속(Single Inheritance)
 * Java는 단일 상속(하나의 부모)만을 허용
 * C++은 다중상속을 허용

## Object Class
 * 모든 클래스의 조상
 * 부모가 없는 클래스는 자동적으로 Object 클래스를 상속 받음
 * 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속 받음
   * toString(), equals(Object obj), hashCode(), ...


## 오버라이딩 (Overriding)
* 상속받은 조상의 메서드를 자신에 맞게 변경하는 것
* 선언부 변경 불가, 구현부만 변경

### 조건
1. 선언부가 조상 클래스의 메서드와 일치해야 함
2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경 불가
3. 예외는 조상 클래스의 메서드보다 많이 선언 불가

### 오버로딩 vs 오버라이딩
* 오버로딩(Overloading) : 기존에 없는 새로운 메서드를 정의 (new)
* 오버라이딩(Overriding) : 상속받은 메서드의 내용을 변경 (modify) 


## super
### 참조변수 super
* 객체 자신을 가리키는 참조변수
* 인스턴스 메서드(생성자)내에서만 존재
* static 메서드에 사용 불가
* 조상의 멤버를 자신의 멤버와 구별할 때 사용

### 조상의 생성자 super() 
* 조상의 생성자를 호출할 때 사용
* 조상의 멤버는 조상의 생성자를 호출해서 초기화
* 추가 조건
  * 생성자의 첫 줄에 반드시 생성자를 호출해야 함
  * 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super(); 를 삽입


## 패키지 (Package)
### 개념
* 서로 관련된 클래스의 묶음
* 클래스는 클래스 파일(*.class), 패키지는 폴더
* 클래스의 실제 이름은 패키지를 포함 (java.lang.String)
* rt.jar은 클래스들을 압축한 파일 (경로 : `JDK 설치 경로\jre\lib`) 

### 선언
* 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
* 같은 소스 파일의 클래스들은 모두 같은 패키지에 속함
* 패키지 선언이 없다면 이름 없는(unnamed) 패키지에 속하게 됨


## 클래스 패스(Class Path)
* 클래스 파일의(*.class)의 위치를 알려주는 경로
* 환경변수 classpath로 관리하며, 경로간 구분자는 세미콜론(;) 사용
* 환경변수(classpath)에 패키지의 루트를 등록해 주어야 함


## import문
### 개념
* 클래스를 사용할 때 패키지 이름 생략 가능
* 컴파일러에게 클래스가 속한 패키지를 알려줌
* java.lang 패키지의 클래스는 import 하지 않고도 사용할 수 있음
  * String, Object, System, Thread, ...
  
### 선언
* 패키지문과 클래스 선언 사이에 선언되어야 함
  * import 패키지명.클래스명;
  * import 패키지명.* ;

* 컴파일 시에 처리되므로 프로그램의 성능에 영향 없음
* 이름이 같은 클래스가 속한 두 패키지를 import할 때에는 클래스 앞에 패키지명을 붙여야 함

### static import문
* static 멤버를 사용할 때 클래스 이름을 생략할 수 있게 해줌
```
import static java.lang.Integer.*;   // Integer 클래스의 모든 static 메서드
import static java.lang.Math.random; // Math.random()만. 괄호 안붙임
import static java.lang.System.out;  // System.out을 out만으로 참조 가능

out.println(random());
```