package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hello {
    private String name;
    private int age;

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setName("asdfas");

        String name = hello.getName();
        System.out.println("name = " + name);
        System.out.println("hello = " + hello);

    }
}
