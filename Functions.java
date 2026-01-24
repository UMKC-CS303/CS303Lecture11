public class Functions {

    public static boolean isDigits(String inString){
        if (inString == null || inString.isEmpty()) 
            return false;
        for (char c : inString.toCharArray()) {
            if (!Character.isDigit(c)) 
               return false;
        }
        return true;
    }

    public static void testInsertDelete(){
        System.out.println("\nTEST BST INSERT, SEARCH & TRAVERSALS (TASKS 1-4)");

        String [] BSTlist = new String[] {"Alvin", "Theodore","Wilma","Fred","Betty"};

        System.out.println("\nTESTING NODE INSERT:");

        MyBST<String> bst1 = new MyBST<>(BSTlist);
        System.out.println("\tIN:  " + bst1.inOrderString()); 
        //System.out.println("\tPRE: " + bst1.preOrderString()); 

        bst1.insert("Happy");
        System.out.println("\n\tTESTING ADD (HAPPY):\n\t" + bst1.inOrderString()); 

        System.out.println("\n1. TESTING SEARCH METHOD (TASK 1):  ");
        System.out.print("\tFinding Wilma: " + bst1.search("Wilma"));
        System.out.println(";  Finding NotFd: " + bst1.search("NotFd"));

        System.out.println("\n2. TESTING PREORDER METHOD (TASK 2):  ");
        //System.out.println("\t" + bst1.preOrderString());  
 
        System.out.println("\n3. TESTING POSTORDER METHOD (TASK 3):  ");

        System.out.println("\n4. TESTING DELETE METHOD (TASK 4):  ");
        bst1.delete("Theodore");
        System.out.println("\t" + bst1.inOrderString());  
        
        System.out.print("\nPrinting BST ");
        for (String s : bst1)
            System.out.print(s.toUpperCase() + " ");
        System.out.println();
    } 

     public static void testOther(){
        System.out.println("\nTEST BST ISLEAF, HEIGHT, DEPTH, MIN, MAX, UPDATE (TASKS 5-9)");

        String [] BSTlist = new String[] {"Alvin", "Theodore","Wilma","Fred","Betty"};
        MyBST<String> bst1 = new MyBST<>(BSTlist);
        bst1.insert("Happy");
         

        System.out.println("\n5.  TESTING IS LEAF METHOD (TASK 5):  ");
        System.out.println("\tAlvin isLeaf: " + bst1.isLeaf("Alvin"));
        System.out.println("\tBetty isLeaf: " + bst1.isLeaf("Betty"));
        System.out.println("\tFred  isLeaf: " + bst1.isLeaf("Fred"));
        System.out.println("\tTheo  isLeaf: " + bst1.isLeaf("Theodore"));
        System.out.println("\tHappy isLeaf: " + bst1.isLeaf("Happy"));
        System.out.println("\tWilma isLeaf: " + bst1.isLeaf("Wilma"));
        System.out.println("\tNotFd isLeaf: " + bst1.isLeaf("Notfd"));  

        System.out.println("\n6.  TESTING HEIGHT METHOD (TASK 6):  ");
        System.out.println("\tThe height of the tree is: " + bst1.heightWrapper());  


        System.out.println("\n7.  TESTING DEPTH METHOD (TASK 7):  ");
        System.out.println("\tDepth of Alvin is: " + bst1.depth("Alvin"));  
        System.out.println("\tDepth of Fred  is: " + bst1.depth("Fred")); 
        System.out.println("\tDepth of Happy is: " + bst1.depth("Happy"));   
        System.out.println("\tDepth of NotFd is: " + bst1.depth("Notfd"));  

        System.out.println("\n8.  TESTING MIN & MAX METHODS (TASK 8):  ");
        System.out.println("\tBST Minimum is: " + bst1.findMin());  
        System.out.println("\tBST Maximum is: " + bst1.findMax()); 

        System.out.println("\nIN:   " + bst1.inOrderString()); 
        //System.out.println("\nPRE:  " + bst1.preOrderString()); 

        System.out.println("\n9.  TESTING UPDATE METHOD (TASK 9):  ");
        System.out.println("\tA) Update Wilma to Abigail: " + bst1.update("Wilma", "Abigail"));  
        System.out.println("\tIN:  " + bst1.inOrderString()); 
        //System.out.println("\tPRE: " + bst1.preOrderString()); 

        System.out.println("\tB) Update Fred to Barney: " + bst1.update("Fred", "Barney"));  
        System.out.println("\tIN:  " + bst1.inOrderString()); 
        //System.out.println("\tPRE: " + bst1.preOrderString()); 
          
        System.out.println("\tC) Update Happy to Barney: " + bst1.update("Happy", "Barney"));  
        System.out.println("\tIN:  " + bst1.inOrderString()); 
        //System.out.println("\tPRE: " + bst1.preOrderString()); 
         
        
        System.out.print("\nPrinting BST ");
        for (String s : bst1)
            System.out.print(s.toUpperCase() + " ");
        System.out.println();
    } 
}
