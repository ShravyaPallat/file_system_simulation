package filesystem;
// This class belongs to the filesystem package
import java.util.ArrayList;
import java.util.List;

// FileSystem class manages all operations on the tree (like a real file system)
public class FileSystem {

    Node root;      // Root directory (starting point of the file system)
    boolean found = false; // Used for search to track if match is found

    // Constructor: initializes the file system with a root folder
    public FileSystem() {
        root = new Node("root", false); // false = specifies root is a folder

          // ---------- DEFAULT FOLDERS & FILES ADDED ----------
    // /root/documents
    Node documents = new Node("documents", false);
    root.addChild(documents);

    // /root/documents/resume.docx
    Node resume = new Node("resume.docx", true);
    documents.addChild(resume);

    // /root/documents/notes
    Node notes = new Node("notes", false);
    documents.addChild(notes);

    // /root/documents/notes/todo.txt
    Node todo = new Node("todo.txt", true);
    notes.addChild(todo);

    // /root/pictures
    Node pictures = new Node("pictures", false);
    root.addChild(pictures);

    // /root/pictures/travel.jpg
    Node travel = new Node("travel.jpg", true);
    pictures.addChild(travel);

    // /root/music
    Node music = new Node("music", false);
    root.addChild(music);

    // /root/music/song.mp3
    Node song = new Node("song.mp3", true);
    music.addChild(song);
}

    // Splits a full path (like /root/docs/file.txt) into components
    private String[] splitPath(String path) {
        if (path == null) // if path is null we get empty array
            return new String[0];

        path = path.trim();// removes any white space

        if (path.startsWith("/")) 
        path = path.substring(1); // remove starting "/"

        if (path.isEmpty()) //if string is empty after trim and substring give empty array
            return new String[0];
        return path.split("/"); // split path by "/"
    }

    // Finds a node (file or folder) given its full path
    public Node findByPath(String path) {
        String[] parts = splitPath(path);//We split the path into its components
        if (parts.length == 0) //If there are no parts we get null/not found
            return null;
        if (!parts[0].equals("root")) //If first part of path is not root then path is invalid so we return null
        return null; // Must start from root

        Node current = root; // Start at root

        // Traverse down tree using name comparisons
        for (int i = 1; i < parts.length; i++) { // loop to find all children
            boolean found = false;
            for (Node child : current.children) { // loop over children of current node
                if (child.name.equals(parts[i])) {  //If we find child with matching name, we move current to the child and mark as true/found
                    current = child; // move down
                    found = true;
                    break;
                }
            }
            if (!found) // invalid path
            return null;
        }
        return current; // return final located node
    }

    // Creates a new file or folder under a given directory path
    public boolean create(String path, String name, boolean isFile) {
        Node parent = findByPath(path); // locate parent folder

        if (parent == null) {
            System.out.println("Invalid path. Folder does not exist.");
            return false;
        }
        if (parent.isFile) {
            System.out.println("Cannot create inside a file.");
            return false;
        }

        // Check if same name exists already
        for (Node child : parent.children) {
            if (child.name.equals(name)) {
                System.out.println("A file/folder with same name already exists.");
                return false;
            }
        }

        // Create and add new node
        Node newNode = new Node(name, isFile);
        parent.addChild(newNode);
        System.out.println((isFile ? "File" : "Folder") + " created: " + getPath(newNode));
        return true;
    }

    // Deletes a file or folder (only if the folder is empty)
    public boolean delete(String path) {
        Node node = findByPath(path);

        if (node == null || node == root) { // Cannot delete root
            System.out.println("Invalid delete operation.");
            return false;
        }

        if (!node.children.isEmpty()) { // Prevent deleting non-empty folder
            System.out.println("Folder not empty. Cannot delete directly.");
            return false;
        }

        node.parent.removeChild(node); // Remove node from parent's child list
        System.out.println("Deleted: " + path);
        return true;
    }

    // Displays entire file system structure starting from root
    public void display() {
        displayRecursive(root, 0); // start with level = 0
    }

    // Recursive helper to print tree with indentation
    private void displayRecursive(Node node, int level) {
        for (int i = 0; i < level; i++) System.out.print("   "); // indentation
        System.out.println((node.isFile ? "[FILE] " : "[DIR]  ") + node.name);

        for (Node child : node.children) {
            displayRecursive(child, level + 1); // go deeper in tree
        }
    }

    // Searches for file/folder by name using Depth First Search (DFS)
    public void searchDFS(String target) {
        found = false; // reset before searching
        System.out.println("Search Results:");
        dfs(root, target);

        if (!found) { // if not found after DFS ends
            System.out.println("file or folder is not found in this name: " + target);
        }
    }

    // DFS traversal to check each node
    private void dfs(Node node, String target) {
        if (node.name.equalsIgnoreCase(target)) { // match found
            System.out.println(getPath(node)); // print full path
            found = true;
        }
        for (Node child : node.children) {
            dfs(child, target); // recursive call
        }
    }

    // Converts a node reference into a full path string
    public String getPath(Node node) {//Returns absolute path
        if (node == null) //if null passed then no path
            return null;
        List<String> parts = new ArrayList<>(); //Created a list to collect path components

        while (node != null) { // go backwards until root or Use while to go up to root from current node
            parts.add(node.name);//Add the current node name to parts
            node = node.parent;//Go up to the parent Node
        }

        // Build the path from root → target
        StringBuilder sb = new StringBuilder();//For combining/Concatenation the strings in parts
        for (int i = parts.size() - 1; i >= 0; i--)
            sb.append("/").append(parts.get(i));//Add a '/' and the part of the name

        return sb.toString();
    }
}
