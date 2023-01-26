# 날짜와 시간
### `java.util.Date`
* 날짜와 시간을 다룰 목적으로 만들어진 클래스(JDK1.0)
* Date의 메서드는 거의 deprecated 되었으나 여전히 쓰이고 있음  
<br/>

### `java.util.Calendar`
* Date 클래스를 개선한 새로운 클래스(JDK1.1)
* 여전히 단점이 존재  
<br/>

### `java.time`
* Date와 Calendar의 단점을 개선한 새로운 클래스 제공(JDK1.8)  

<br/>
<br/>

# Calendar 클래스
* 추상 클래스이므로 getInstance()를 통해 구현된 객체를 얻어야 함
```java
    calendar cal = new Calendar();  // Error. 추상클래스는 인스턴스 생성 불가

   // OK. getInstance() 메서드는 Calendar클래스를 구현한 클래스의 인스턴스 반환     
    Calendar cal = Calendar.getInstance();
```  
<br/>

`get()`
* 날짜와 시간 필드 가져오기 - int get(int field)
 ```java
    Calendar cal = Calendar.getInstance();  // 현재 날짜와 시간으로 셋팅
    int thisYear = cal.get(Calendar.YEAR);  // 올해가 몇 년인지 반환
    int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // 이 달의 마지막 날
```  
<br/>

`set()`
* 날짜 지정하기
  * 월(MONTH)이 0부터 시작한다는 점에 주의
```java
    Calendar date1 = Calendar.getInstance();
    date1.set(2017, 7, 15);  // 2017년 8월 15일! 
```
* 시간 지정하기
```java
    Calendar time1 = Calendar.getInstance();
    time1.set(Calendar.HOUR_OF_DAY, 10);
    time1.set(Calendar.MINUTE, 20);
    time1.set(Calendar.SECOND, 30);  // 10시 20분 30초
```  
<br>

`clear()`
* Calendar 객체의 모든 필드를 초기화
```java
    Calendar dt = Calendar.getInstance();

    // Tue Aug 29 07:13:03 KST 2017
    System.out.println(new Date(dt.getTimeInMillis()));
    
    dt.clear();  // 모든 필드 초기화
 
    // Thu Jan 01 00:00:00 KST 1970    
    System.out.println(new Date(dt.getTimeInMillis()));
```
* clear(int field)는 Calendar객체의 특정 필드를 초기화
```java
    Calendar dgt = Calendar.getInstance();
    
    // Tue Aug 29 07:13:03 KST 2017
    System.out.println(new Date(dt.getTimeInMillis()));
    
    dt.clear(Calendar.SECOND);       // 초를 초기화
    dt.clear(Calendar.MINUTE);       // 분를 초기화
    dt.clear(Calendar.HOUR_OF_DAY);  // 시를 초기화
    dt.clear(Calendar.HOUR);         // 시간 초기화

    // Tue Aug 29 00:00:00 KST 2017
    System.out.println(new Date(dt.getTimeInMillis()));
```  
<br>

`add()`
* 특정 필드의 값을 증가 또는 감소시킴
* 다른 필드에 영향을 줌
```java
    Calendar date = Calendar.getInstance();
    date.clear(); // 모든 필드 초기화
    date.set(2023, 1, 31) // 2023년 2월 31일로 설정

    date.add(Calendar.DATE, 1);    // 날짜에 1을 더함
    date.add(Calendar.MONTH, -8);  // 월에서 8을 뺌
```  
<br>

`roll()`
* 특정 필드에 값을 증가 또는 감소시킴
* 다른 필드에 영향을 주지 않음
```java
    date.set(2023, 1, 31) // 2023년 2월 31일로 설정

    date.roll(Calendar.DATE, 1);    // 날짜에 1을 더함
    date.roll(Calendar.MONTH, -8);  // 월에서 8을 뺌
```  
<br>

### `Date <-> Calendar 변환`
`Calendar를 Date로 변환`
```java 
    Calendar cal = Calendar.getInstance();
        ...
    Date d = new Date(cal.getTimeInMillis()); // Date(long date)
```  
<br>

`Date를 Calendar로 변환`
```java 
    Date d = new Date();
        ...
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
```
<br>
<br>

# 형식화 클래스
* java.text 패키지의 DecimalFormat, SimpleDateFormat  
<br>
* 숫자와 날짜를 원하는 형식으로 쉽게 출력 가능 (숫자, 날짜 -> 형식 문자열)
```java
    double number = 1234567.89;
    DecimalFormat df = new DecimalFormat("#.#E0");
    String result = df.format(number);  // result = "1.2E6"
```
* 형식 문자열에서 숫자와 날짜를 뽑아내는 기능 (형식 문자열 -> 숫자, 날짜)
```java
    DecimalFormat df = new DecimalFormat("#,###.##");
    Number num = df.parse("1,234,567.89");
    double b = num.doubleValue();  // 1234567.89
```  
<br>

### `DecimalFormat`
* 숫자를 형식화할 때 사용 (숫자 -> 형식 문자열)
* 특정 형식의 문자열을 숫자로 변환할때도 사용 (형식 문자열 -> 숫자)  
<br>
### `SimpleDateFormat`
* 날짜와 시간을 다양한 형식으로 출력할 수 있게 함
```java
    Date today = new Date;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String result = df.format(today);
```  
<br>

* 특정 형식으로 되어있는 문자열에서 날짜와 시간을 뽑아낼 수도 있음
```java
    DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
    Date d = df.parse("2015년 11월 23일");  // 문자열을 Date로 변환
    String result = df2.format(d);
```