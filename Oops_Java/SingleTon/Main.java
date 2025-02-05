package SingleTon;

import SingleTon.Singleton.Single;

public class Main {

    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        // all 3 reference variable are pointing to just one object
        System.out.println(obj);
        System.out.println(obj2);
        System.out.println(obj3);
        


        // another singleton class 
        Single obj4 = Single.getInstace();
        Single obj5 = Single.getInstace();
        Single obj6 = Single.getInstace();
        System.out.println(obj4);
        System.out.println(obj5);
        System.out.println(obj6);    

    }
}
