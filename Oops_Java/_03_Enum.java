
public class _03_Enum {
    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public , static and final
        // since its final you cannot create child enum 
        // type is Week

        Week(){
            System.out.println("Constructor called for  " + this);
        }

        // this is not public or protected , only  private or default 
        // why ?? we dont want to create new Objects 
        // this is not the enum concept , thats why  
    }

    public static void main(String[] args) {

        Week week = Week.Monday;

        // for(Week day : Week.values()){
        // System.out.println(day);
        // }

        System.out.println(week.ordinal());

    }
}
