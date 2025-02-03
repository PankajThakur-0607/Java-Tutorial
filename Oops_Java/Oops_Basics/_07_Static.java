package Oops_Basics;

public class _07_Static {
    


    public static void main(String[] args) {
        
        
        Studentt.schoolName = "M.K Mehta";

        // Studentt s2 = new Studentt();
        System.out.println(Studentt.schoolName);

        // Studentt s3 = new Studentt();
        Studentt.schoolName = "P.G Junior College";

        System.out.println(Studentt.schoolName);
    }

}


class Studentt{

    String name ;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}
