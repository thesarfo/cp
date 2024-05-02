import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Practice{
    public static void main(String[] args) {
        // check if a file exists
        Path path = Path.of("C:\\Users\\ErnestSarfo\\Desktop\\resources\\RobertMartin-CleanCode.pdf");
        boolean exists = Files.exists(path);
        System.out.println("Exists = " + exists);

        // get the last modified date of a file
        Path path2 = Path.of("C:\\Users\\ErnestSarfo\\Desktop\\resources\\RobertMartin-CleanCode.pdf");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path2);
        System.out.println("Last modified time : " lastModifiedTime);

        // comparing files 
        Path path3 = Path.of("C:\\Users\\ErnestSarfo\\Desktop\\resources\\RobertMartin-CleanCode.pdf");
        long mismatchIndex = Files.mismatch(path3, Paths.get("c:\\dev\\whatever.txt"));
        System.out.println("mismatch: " + mismatchIndex);

        // getting the owner of a file
        Path path4 = Path.of("C:\\Users\\ErnestSarfo\\Desktop\\resources\\RobertMartin-CleanCode.pdf");
        UserPrincipal owner = Files.getOwner(path4);
        System.out.println("owner: " owner);

        // writing strings to files
        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeS  n 

        // new arraylist
        List<Integer> listExample = new ArrayList<Integer>();
        listExample.add(0, 10);
        System.out.println("List " + listExample);
    }
}
