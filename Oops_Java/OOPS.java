package Oops_Java;

public class OOPS {
    

    public static void main(String args[]){
        Pen p1 = new Pen();
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
        p1.setColor("Purple");
        System.out.println(p1.getColor());
        p1.setTip(5); ;
        System.out.println(p1.getTip());
        p1.color = "green";
        System.out.println(p1.color); 
        
    }
}


class Pen {
    // Properties 
    protected String color;
    protected int tip;

    String getColor(){
        return this.color;
    }
    void setColor(String newColor){
        this.color = newColor;
    }

    int getTip(){
        return this.tip;
    }
    void setTip(int newTip){
        this.tip = newTip;
    }
}


 