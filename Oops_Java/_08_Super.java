package Oops_Java;

public class _08_Super {
    


    public static void main(String[] args) {
        cat c = new cat();
        System.out.println(c.color);

    }

}

class Lion{
    String color;
    Lion(){
        System.out.println("Lion constructor called");
    }
}

class cat extends Lion{
    cat(){
        super.color = "white";
        System.out.println("cat constructor called");
    }
}
