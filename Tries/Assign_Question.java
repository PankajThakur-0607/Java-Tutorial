package Tries;

import java.util.*;


public class Assign_Question {


    static class Node {
      ArrayList<String> data;
      Node children[];
      boolean eow;

            public Node(){
                data = new ArrayList<>();
                children = new Node[26];
                eow = false;
            }
        
    }

    public static void insert(String st){
        
        Node curr = root;
    char word[] = st.toCharArray();
    Arrays.sort(word);

    for(char c : word){
        Node child = curr.children[c - 'a'];
        if (child == null) {
            curr.children[c - 'a'] = new Node();
        }
        curr = curr.children[c - 'a'];
    }

    curr.eow = true;
    curr.data.add(st);
    }


   public static void dfs(Node rt){
    if (rt.eow) {
        ans.add(rt.data);
    }


    for(int i =0 ; i< 26; i++){
        if (rt.children[i] != null) {
            dfs(rt.children[i]);
        }
    }
   }


    static Node root = new Node();
     static ArrayList<ArrayList<String>> ans;

    public static ArrayList<ArrayList<String>>  groupAnagram (String str[]){
        ans = new ArrayList<>();

        for(String word : str){
            insert(word);
        }

        dfs(root);

        return ans;

    
    }




 
// static class Node {
//     ArrayList<String> data ;
//      Node children[];
//      boolean eow;

//         public Node(){
//           data = new ArrayList<>();
//           children = new Node[26];
//           eow = false;
//         }
//  }
//   public static Node root = new Node();
//   public static  ArrayList<ArrayList<String>> ans;

//   public static void insert(String st){
//       Node curr = root;
//       char word[] = st.toCharArray();
//       Arrays.sort(word);

//       for(char i : word){
//           Node child = curr.children[i - 'a'];
//           if(child == null){
//               curr.children[i - 'a'] = new Node();
//           }

//           curr = curr.children[i - 'a'];
//       }
//        curr.eow = true;
//        curr.data.add(st);
//   }

//   public static void dfs(Node rt){
//       if(rt.eow){
//           ans.add(rt.data);
//       }

//       for(int i =0; i< 26 ; i++){
//           if(rt.children[i] != null){
//               dfs(rt.children[i]);
//           }
//       }
//   }

//  public static ArrayList<ArrayList<String>> anagramsHelp(String str1[]){
//          ans = new ArrayList<>();

//      for(String word : str1){
//          insert(word);
//      }

//      dfs(root);


//      return ans;


//  }

    public static void main(String[] args) {
        
   String str[] = {""};
  

System.out.println(groupAnagram(str));
    

   


    }
}
