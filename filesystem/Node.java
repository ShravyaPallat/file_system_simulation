//Tree Node
package filesystem; // This class is part of the 'filesystem' package

import java.util.ArrayList;
import java.util.List;

// Node represents a file or a folder inside the file system tree
public class Node {

    public String name;        // Name of the file or folder
    public boolean isFile;     // true → file, false → folder
    public Node parent;        // Reference to the parent node (folder)
    public List<Node> children; // List of child nodes (only for folders) subfolders/files

    // Constructor: Creates a new Node with given name and type (file/folder)
    public Node(String name, boolean isFile){
        this.name = name;
        this.isFile = isFile;
        this.parent = null; // Parent will be set later when added to a folder
        this.children = new ArrayList<>(); // Initialize list for subfiles/subfolders
    }

    // Adds a child node under this node (used when creating new files/folders)
    public void addChild(Node child){
        child.parent = this; // Assign parent reference
        this.children.add(child); // Add to folder's children list
    }

    // Removes a child node from this node (used when deleting files/folders)
    public void removeChild(Node child){
        this.children.remove(child); // Delete reference from the children list
    }
}
