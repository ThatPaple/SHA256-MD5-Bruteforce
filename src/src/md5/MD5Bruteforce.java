package md5;

public class MD5Bruteforce {

    public static int attempts = 0;
    public static boolean found = false;
    
    public static void main(String[] args) {
    }

    public static void initBruteforce(String HASH) {
        
        char[] letters = {'A', 'a', 'B', 'b', 'C', 'c',
            'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g',
            'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k',
            'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o',
            'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's',
            'T', 't', 'U', 'u', 'V', 'v',
            'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'
        //,' ', '/', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '}', '{',
        //  '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'    
        // ,' ','/','!','@','#','$','%','^','&','*','(',')','_','-','}','{'
        // ,'1','2','3','4','5','6','7','8','9','0'
        };

        /*  Special characters and numbers slowed down the process..
                Do I want to include them?
         */
        // PASTE IN THE MD5 HASH THAT YOU WISH TO BRUTEFORCE ATTACK
        String hashed = HASH;

        //System.out.println("Possible combinations");

            long startTime;
            startTime = System.nanoTime();
            for (int i = 0; i < letters.length; i++) {
                bruteforce(letters, "", letters.length, i, hashed, startTime);
           }
      

    }

    static void bruteforce(char[] set, String prefix, int setlen, int base, String h, long startTime) {
        if(found == false){
        
         if(attempts % 100000000 == 0){
            System.out.println("md5: " + prefix);
        }
         
         
        try {
            String tmp = MD5Hash.MD5it(prefix);

            if (tmp.equals(h)) {
                System.out.println("");

                long endTime = System.nanoTime();
                Double elapsedTime = ((endTime - startTime) / 1000000000.0);
                System.out.println("MD5 Brute  >> "
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
                       // Status st = new Status();
                       // st.setFirstHash(false);
                       found = true;
                        return;
                        /* try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    // Logger.getLogger(MD5Bruteforce.class.getName()).log(Level.SEVERE, null, ex
                } finally{
                    Thread.currentThread().interrupt();
                }*/
            } 
           
            else if (base == 0) {
               
                attempts++;
                return;
            }
            

            for (int i = 0; i < setlen; ++i) {
                //System.err.println("..");
                String newPrefix = prefix + set[i];
                bruteforce(set, newPrefix, setlen, base - 1, h, startTime);
            }
        } catch (StackOverflowError e) {
        }
        
        }
    }
}
