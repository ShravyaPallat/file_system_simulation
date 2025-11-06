//Tree Node
import java.util.ArrayList;
import java.util.List;
//Node represents files and dolders
public class Node{
    String name; //Name of the node
    boolean isFile; //true is file, false is folder
    Node parent; //References parent node
    List<Node> children; //Contains subfolders/ files

    public Node(String name, boolean isFile){ //Constructor for Node class
        this.name=name;
        this.isFile=isFile;
        this.parent=null;
        this.children=new ArrayList<>(); //Initialization
    }
    public void addChild(Node child){ //Attaches child node to current node
        child.parent=this;
        this.children.add(child); //Adds the child to children list
    }
    public void removeChild(Node child){ //Removes a child from current node's children list
        this.children.remove(child);
    }
}