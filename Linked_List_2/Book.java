package Linked_List_2;

// public class Book {
//     // Non-static inner class
//     public class Page {
//         private int pageNumber;

//         public Page(int pageNumber) {
//             this.pageNumber = pageNumber;
//         }

//         public void printPageNumber() {
//             System.out.println("Page Number: " + pageNumber);
//         }

//         // Method to access the outer class's title
//         public void printBookTitle() {
//             System.out.println("Book Title: " + title);
//         }

//         // Method t oaccess the outer class's cases
//         public void printCases(){
//             System.out.println("Cases are : " + cases );
//         }
//     }

//     private String title;
//     public int cases;
//     public Book(String title) {
//         this.title = title;
//     }

//     void setCases(int cases){
//         this.cases = cases;
//     }

//     public void printTitle() {
//         System.out.println("Book Title: " + title);
//     }

//     public static void main(String[] args) {
//         // Create an instance of the outer class
//         Book book = new Book("Java Programming");
//         book.cases = 7;

//         // Create an instance of the non-static inner class
//         Book.Page page = book.new Page(1);
//         page.printPageNumber(); // Output: Page Number: 1
//         page.printBookTitle();  // Output: Book Title: Java Programming
//         page.printCases();
//     }
// }



public class Book {
    // Static nested class
    public static class Page {
        private int pageNumber;

        public Page(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public void printPageNumber() {
            System.out.println("Page Number: " + pageNumber);
        }
    }

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void printTitle() {
        System.out.println("Book Title: " + title);
    }

    public static void main(String[] args) {
        // Create an instance of the static nested class
        Book.Page page = new Book.Page(1);
        page.printPageNumber(); // Output: Page Number: 1

        // Create an instance of the outer class
        Book book = new Book("Java Programming");
        book.printTitle(); // Output: Book Title: Java Programming
    }
}










