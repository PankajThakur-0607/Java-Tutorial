package SingleTon;


public class Singleton {
    

    private Singleton(){

    }

    private static Singleton instance;

    public static Singleton getInstance(){
        // check wheather 1 obj is created or not
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }


    static class Single {
        private Single(){}

        private static Single instance;

        public static Single getInstace(){
            if (instance == null) {
                instance =  new Single();
            }

            return instance;
        }
    }

    public static void main(String[] args) {
        
    }
}
