package Principles.Access_Specifier;

public class A {

    private int num;
    String name;
    int[] arr;
    protected int age;
    public void setNum(int num){
        this.num = num;
    }

    public int getNum(){
        return this.num;
    }
    public A(int num, String name , int age) {
        this.name = name;
        this.num = num;
        this.arr = new int[num];
        this.age = age;
    }

    public static void main(String[] args) {

        A hii = new A(0, null, 0);
        System.out.println(hii.age);
    }
}
