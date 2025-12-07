interface Animal {
  String TYPE = "동물";

  String say();

  default String hello() {
    return say();
  }
}

class Dog implements Animal {
  @Override
  public String say() {
    return "멍멍";
  }
}

public class Test {
  public static void main(String[] args) {
    Animal a = new Dog();
    System.out.println(a.say());      // 출력: 멍멍
    System.out.println(a.hello());    // 출력: 멍멍
    System.out.println(Animal.TYPE);  // 출력: 동물
  }
}