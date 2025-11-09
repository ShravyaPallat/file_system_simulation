//main program
import java.util.Scanner;       // For taking user input
import filesystem.*;   // Import FileSystem class from filesystem package

// Main class that provides menu-driven program for interacting with the file system
public class FileSystemApp {

    public static void main(String[] args) {

        FileSystem fs = new FileSystem(); // Creating file system object
        Scanner sc = new Scanner(System.in); // Scanner to take user input

        while (true) { // Infinite loop to repeatedly show menu
            System.out.println("\n--------File System Simulation--------");
            System.out.println("1. Create Folder");
            System.out.println("2. Create File");
            System.out.println("3. Delete");
            System.out.println("4. Display"); // Entire Sturcture
            System.out.println("5. Search (DFS)"); // Using DFS
            System.out.println("6. Exit");
            System.out.print("Enter an option: ");

            int choice = sc.nextInt(); // Read menu choice
            sc.nextLine(); // Clear input buffer after taking integer

            switch (choice) { // Perform operation based on choice

                case 1: // Create folder
                    System.out.print("Enter parent folder path (e.g., /root): ");
                    fs.create(sc.nextLine(), ask(sc, "Folder name: "), false);
                    break;

                case 2: // Create file
                    System.out.print("Enter parent folder path (e.g., /root/docs): ");
                    fs.create(sc.nextLine(), ask(sc, "File name: "), true);
                    break;

                case 3: // Delete file/folder
                    System.out.print("Enter full path to delete: ");
                    fs.delete(sc.nextLine());
                    break;

                case 4: // Display the whole directory structure
                    fs.display();
                    break;

                case 5: // Search using DFS
                    System.out.print("Enter name to search: ");
                    fs.searchDFS(sc.nextLine());
                    break;

                case 6: // Exit from program
                    System.out.println("Exiting...");
                    sc.close();
                    return; // End program

                default:
                    System.out.println("Invalid Option! Try Again.");
            }
        }
    }

    // Helper method to display label and get user input for names
    static String ask(Scanner sc, String label) {
        System.out.print(label);
        return sc.nextLine();
    }
}
