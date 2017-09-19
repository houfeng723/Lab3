import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */


public class lab3class1 {
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
        }

    public static void main(String args[]) {

        String content=urlToString("http://erdani.com/tdpl/hamlet.txt");
        int letterLength=content.length();

        //System.out.print("There are ");
        //System.out.print(letterLength);
        //System.out.println(" characters");




        int index =0;
        int countWord =0;
        int countUnique =0;
        while(index<=letterLength-1) {
            if(content.charAt(index)!=' ') {
                index++;
            }
            else {
                if(content.charAt(index-1)==' ') {
                    index++;
                }
                else {
                    countWord++;
                    index++;
                }

            }
        }
        System.out.println("There are "+countWord+" words");

        index=0;
        while(index<=letterLength-7) {
            String testSubring=content.substring(index,index+6);
            if(testSubring.equals("Prince")) {
                countUnique++;
            }
            index++;
        }
        System.out.print("There are ");
        System.out.print(countUnique);
        System.out.println(" Prince, if case sensitive");

        index=0;
        while(index<=letterLength-7) {
            String testSubring=content.substring(index,index+6);
            if(testSubring.equalsIgnoreCase("Prince")) {
                countUnique++;
            }
            index++;
        }
        System.out.print("There are ");
        System.out.print(countUnique);
        System.out.println(" Prince, if we ignore case");
    }


}
