package SingleTon;

public class Main {

    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        // all 3 reference variable are pointing to just one object
        System.out.println(obj);
        System.out.println(obj2);
        System.out.println(obj3);
    }
}
