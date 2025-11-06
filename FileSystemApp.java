//Main Program
import java.util.Scanner;

public class FileSystemApp{
    public static void main(String[] args) {
        FileSystem fs=new FileSystem(); //Create new filesystem
        Scanner sc= new Scanner(System.in); 

        /*Add some sample data/prexixsting files and folder to execute here
        using fs.create()
        */

       //While loop for using file system
       while(true){
        System.out.println("--------File System Simulation--------");
        System.out.println("1. Create Folder");
        System.out.println("2. Create FIle");
        System.out.println("3. Delete");
        System.out.println("4. Display"); //Entire Structure
        System.out.println("5. Search"); //Using DFS
        System.out.println("6. Exit");
        System.out.println("Enter an option: ");
        int choice=sc.nextInt();

        switch (choice) { //Switch case to use input to perform
            case 1:
                //use fs.create();
                break;
            case 2:
                //use fs.create()
                break;
            case 3:
                //use fs.delete()
                break;
            case 4:
                fs.display();
                break;
            case 5:
                //use fs.searchDFS()
                break;
            case 6:
                sc.close();
                System.out.println("Exiting.");
                return;
            default:
                System.out.println("Invalid Choice. Try again");
        }
       }

    }
}
