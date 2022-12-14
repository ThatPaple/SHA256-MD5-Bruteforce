package extendedessay;



/**
 *
 * @author ThatPaple
 */
public abstract class ExtendedEssay implements Runnable{

    public static void main(String[] args){
        /*
            Time it takes to bruteforce SHA256 vs MD5
        */
        
        String toTest = "ted";
       // Status st = new Status();
        
// MD5

        long startTimeMD = System.nanoTime();
        md5.MD5Hash.MD5it(toTest);
        long endTimeMD = System.nanoTime();
        Double elapsedTimeMD = ((endTimeMD - startTimeMD) / 1000000000.0);
        System.out.println("MD5 HASHING TOOK : " + elapsedTimeMD + " s");
        System.out.println("");
        md5.MD5Bruteforce.initBruteforce(md5.MD5Hash.MD5it(toTest));
        
//SHA256

        long startTimeSHA = System.nanoTime();
        sha256.SHA256.SHA256it(toTest);
        
        long endTimeSHA = System.nanoTime();
        Double elapsedTimeSHA = ((endTimeSHA - startTimeSHA) / 1000000000.0);
        System.out.println("SHA256 HASHING TOOK : " + elapsedTimeSHA + " s");
        System.out.println("");
        sha256.SHA256Bruteforce.initBruteforce(sha256.SHA256.SHA256it(toTest));
    }
}


