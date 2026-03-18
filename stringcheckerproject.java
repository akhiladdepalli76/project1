import java.util.*;
import java.io.*;
class project1{
    static void description(){
        System.out.println("=== String Puzzle Solver ===");
    System.out.println("Commands you can use:");
    System.out.println("  palindrome  → check if a word reads same forwards and backwards");
    System.out.println("  anagram     → check if two words have same letters");
    System.out.println("  reverse     → reverse words in a sentence");
    System.out.println("  compressor  → compress repeated characters");
    System.out.println("  exit        → quit the program");
    }
    static boolean isPalindrome(String s){
        int l =0;
        int r = s.length()-1;
        while(l<=r){
            char ans1 = Character.toLowerCase(s.charAt(l));
            char ans2 = Character.toLowerCase(s.charAt(r));
            if(!Character.isLetterOrDigit(ans1)){
                l++;
                continue;
            }
            else if(!Character.isLetterOrDigit(ans2)){
                r--;
                continue;
            }
        else if(ans1 != ans2){
            return false;
        }
        l++;
        r--;
         
        }
        return true;


    }
    static boolean isAngram(String s1,String s2){
         if(s1.length() != s2.length()){
            return false;
         }
        HashMap<Character,Integer> map = new HashMap<>();
        // HashMap<Character,Integer>map2 = new HashMap<>();
        for(int i =0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)-1);


         }
        for(char x:map.keySet()){
     if(map.get(x) !=0){
        return false;
     }

         }

return true;
    }
    static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("\\s+");
        for(int i =0;i<arr.length;i++){
            sb.append(arr[arr.length-i-1]+" ");
        }
    
        return sb.toString().trim();
    } 
    static String compressor(String s){
       int l =0;
       int r =0;
       
        StringBuilder sb = new StringBuilder();
        while(r<s.length()){
            

          while(r<s.length()&&s.charAt(r)==s.charAt(l)){
            
            r++;
          }
          sb.append(s.charAt(l));
          sb.append((r-l));
          l=r;
        }
        
    

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("hi please enter the string here");
        System.out.println("hi hello ");
        System.out.println("welcome to my stringchecker project");
        System.out.println("if you want to know about what to do in this game enter 'description' to know more else press enter");
        String go = sc.nextLine();
        if(go.equalsIgnoreCase("description")){
            description();
        }
        
        System.out.println("Enter command: palindrome/anagram/reverse/compressor/exit");
            String command = sc.next();

        while(!command.equalsIgnoreCase("exit")){
            
            if(command.equalsIgnoreCase("palindrome")){
                System.out.println("Enter string to check palindrome:");
                String input = sc.next();
                System.out.println(isPalindrome(input) ? "it is a palindrome" : "not palindrome");
            } else if(command.equalsIgnoreCase("anagram")){
                System.out.println("Enter first string:");
                String s1 = sc.next();
                System.out.println("Enter second string:");
                String s2 = sc.next();
                System.out.println(isAngram(s1, s2) ? "strings are anagrams" : "strings are not anagrams");
            } else if(command.equalsIgnoreCase("reverse")){
                System.out.println("Enter sentence to reverse words:");
                sc.nextLine();
                String line = sc.nextLine();
                System.out.println("Reversed: " + reverse(line));
            } else if(command.equalsIgnoreCase("compressor")){
                System.out.println("Enter string to compress:");
                String input = sc.next();
                System.out.println("Compressed: " + compressor(input));
            } else if(command.equalsIgnoreCase("exit")){
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Unknown command. Use palindrome/anagram/reverse/compressor/exit.");
            }

            System.out.println("Type exit to quit or enter next command.");
            System.out.println("Enter command: palindrome/anagram/reverse/compressor/exit");
            command = sc.next();
            
            if(command.equalsIgnoreCase("exit")){
                break;
            }
           
            
            

        }
        sc.close();
    }
}

