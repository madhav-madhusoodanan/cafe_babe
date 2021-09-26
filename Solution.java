import java.util.*;

class LongestCommonPrefix{
  	int n;
    String[] words;
  	/* Declare an instance variable to store the list of strings */
  
  	LongestCommonPrefix(String listOfStrings){
    }
  
  	public void augment(/* add required parameters */){
    	/* 
           Implement the augment method to augment/modify a string in the list of strings in order to 
           act as a utility method to solve the given question	
        */
        
    }
  
  	public String longestPrefixString(){
    	/* Complete the method to find longest prefix in all strings of the list of strings */   

        /* find out the shortest word. Here smallest is used to find the length of the smallest word */
        int smallest = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0) 
            { 
                smallest = words[0].length();
            } 
            else if (smallest > words[i].length()) 
            {
                smallest  = words[i].length();
            }
        }

        /* take the first "smallest" letters of the first word. smallest turns into the longest possible prefix */
        char[] prefix = new char[smallest];
        words[0].getChars(0, smallest, prefix, 0);

        /* 3. pop letters until all the words match */        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < smallest; j++) {
                if(prefix[j] != words[i].charAt(j)) {
                    smallest-- ;
                    i--;
                    break;
                }
            }
        }

        /* displaying things */
        char[] final_prefix = new char[smallest];
        for (int i = 0; i < smallest; i++) {
            final_prefix[i] = prefix[i];
            // System.out.print(prefix[i]);
        }
        if(smallest == 0) return "-";
        return String.valueOf(final_prefix);
        
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LongestCommonPrefix obj = new LongestCommonPrefix("");
        obj.n = sc.nextInt();

        String[] words = new String[obj.n];
        for (int i = 0; i < obj.n; i++) {
            words[i] = sc.next();
        }

        obj.words = words;
        System.out.println(obj.longestPrefixString());
        // obj.longestPrefixString();
        sc.close();
    }
}

/* Algorithm

1. find out the shortest word
2. take all its letters
3. pop letters until all the words match

*/