package Oops_Basics;

public class _07_Static {

    String subject;
    String teacherName;

    _07_Static(String subject, String teacherName) {
        this.subject = subject;
        this.teacherName = teacherName;
    }

    class Test {

        int marks;

        Test(int marks) {
            this.marks = marks;
        }

        // to access the value of the outer class we have to keep the inner class non
        // static as static class are independent of the objects ;
        // and can be implemented without creating the outer object
        String getTeacherName() {
            return teacherName;
        }
    }

    // get TeacherName in static class
    // to get the value of parent class we need to create object of the parent class
    // then only we can do it
    public static class GetClass {

        String getTeacherName() {
            _07_Static obj = new _07_Static("Science", "Divya Mam");

            return obj.teacherName;
        }

    }

    public static void main(String[] args) {

        _07_Static maths = new _07_Static("Maths", "Sreeja Anna");

        System.out.println(maths.subject);

        _07_Static.Test obj = maths.new Test(50);
        System.out.println(obj.getTeacherName());

        GetClass inner = new GetClass();
        System.out.println(inner.getTeacherName());

    }

}
