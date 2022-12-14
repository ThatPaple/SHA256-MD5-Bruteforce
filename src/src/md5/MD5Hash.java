package md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5Hash {

    public static void main(String[] args) {
        long startTime;
        /*
            Check if it works: 
            test = 098f6bcd4621d373cade4e832627b4f6
         */

        String password = "test";
        System.out.println(MD5it(password));

    }

    public static String MD5it(String a) {
        
        String generatedHash = "";
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            msd.update(a.getBytes());
            byte[] bytes = msd.digest();

            String temp = "";
            for (int i = 0; i < bytes.length; i++) {
                temp = temp + Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1);
            }

            generatedHash = temp;
                    
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5Hash.class.getName()).log(Level.SEVERE, null, ex);
        }

        return generatedHash;
        

    }
}
