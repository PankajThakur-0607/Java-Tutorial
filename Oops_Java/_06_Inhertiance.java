package Oops_Java;

public class _06_Inhertiance {
    

    public static void main(String[] args) {
            Queen q = new Queen();
            q.moves();

            Bear b = new Bear();
            b.eat();
    }

}


    interface ChessPlayer{
        void moves();
    }

    class Queen implements ChessPlayer{
        public void moves(){
            System.out.println("up , down , left , right , diagonal(in all 4 dirs)");
        }
    }
    class Rook implements ChessPlayer{
        public void moves(){
            System.out.println("up , down , left , right ");
        }
    }
    class King implements ChessPlayer{
        public void moves(){
            System.out.println("up , down , left , right , diagonal(in all 4 dirs and 1 step) ");
        }
    }




    interface Herbivore{
        void eat();
    }
    
    interface Carnivore{
        void eat();
    }


    class Bear implements Herbivore , Carnivore{

        public void eat(){
            System.out.println("Eats both veg");
        }

        // public void eatNon(){
        //     System.out.println("Eats non veg");
        // }

        
    }
