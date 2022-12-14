package sha256;

public class SHA256Bruteforce {
 public static int attempts = 0;
 public static boolean found = false;
 
    public static void main(String[] args) {
        
    }

    public static void initBruteforce(String hash) {

        char[] letters = {'A', 'a', 'B', 'b', 'C', 'c',
            'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g',
            'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k',
            'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
            'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's',
            'T', 't', 'U', 'u', 'V', 'v',
            'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
        /*
            
            ,' ','/','!','@','#','$','%','^','&','*','(',')','_','-','}','{'
            ,'1','2','3','4','5','6','7','8','9','0'
        
        
         */

 /*  Special characters and numbers slow down the process.. (duh!)
                Do I want to include them?
         */
        // PASTE IN THE MD5 HASH THAT YOU WISH TO BRUTEFORCE ATTACK
        if (hash.isEmpty()) {
            System.err.println("Missing HASH");
            System.exit(0);
        }
        String hashed = hash;
        
       
        
        
            long startTime;
            startTime = System.nanoTime();
            for (int i = 0; i < letters.length; i++) {
                bruteforce(letters, "", letters.length, i, hashed, startTime);
          
            }
       
    }
    
    static void bruteforce(char[] set, String prefix, int setlen, int base, String h, long startTime) {
    if(found == false){

        if(attempts % 100000000 == 0){
            System.out.println("sha: "+prefix);
        }
        
        try {
            String tmp = SHA256.SHA256it(prefix);
            if (tmp.equals(h)) {
                System.out.println("");

                long endTime = System.nanoTime();
                Double elapsedTime = ((endTime - startTime) / 1000000000.0);
                System.out.println("");
               System.out.println("\n"+
                       "SHA256 Brute  >> "
                       + "\n" 
                       + " Elapsed Time:" 
                       + elapsedTime 
                       + " s"
                       + "\n" 
                       + " Clear text: " 
                       + prefix + "\n" 
                       + " Hash: " 
                       + tmp 
                       + "\n" + " Attempts: " 
                       + attempts);
                System.out.println("");
                found = true;
                return;
              

            } else if (base == 0) {
                // System.out.println(prefix);
                 attempts++;
                return;
            }

            for (int i = 0; i < setlen; ++i) {
                
                String newPrefix = prefix + set[i];
                bruteforce(set, newPrefix, setlen, base - 1, h, startTime);
   
            }
        } catch (StackOverflowError e) {
        }
    
    }

    }
}
