package Principles.Access_Specifier;

public class ObjectDemo {

    int num;
    float gpa;

    ObjectDemo(int num) {
        this.num = num;
    }

    ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.num == ((ObjectDemo) (obj)).num;
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(34, 65.4f);
        ObjectDemo obj2 = new ObjectDemo(34, 78.5f);

        if (obj == obj2) {
            System.out.println("obj1 is equal than obj2 ");
        }
        if (obj.equals(obj2)) {
            System.out.println("obj1 is equal than obj2 ");
        }

        System.out.println(obj.getClass().getSimpleName());
        // System.out.println(obj.hashCode());
        // System.out.println(obj2.hashCode());
    }
}
