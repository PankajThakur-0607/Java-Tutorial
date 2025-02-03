package Oops_Basics;

public class _01_oops {

    public static void main(String args[]) {
        BankAccount myAcc = new BankAccount();
        myAcc.name = "Pankaj Thakur";
        System.out.println(myAcc.name);
        myAcc.setPassWord("Hello@123");
        System.out.println(myAcc.getPassword());

    }

}

class BankAccount {
    public String name;
    private String password;

    String getPassword() {
        return this.password;
    }

    void setPassWord(String pwd) {
        this.password = pwd;
    }

}
