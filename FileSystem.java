import java.util.ArrayList;
import java.util.List;
//Manages the tree

public class FileSystem{
    Node root; //This is root node

    public FileSystem(){ //Constructor for FileSystem
        root=new Node("root", false); //Initialzation, specifies root is folder (false)
    }

//Split File Path into parts
    private String[] splitPath(String path){
        if(path==null) //if path is null we get empty array
            return new String[0];

        path=path.trim(); //Removes any white space

        if (path.startsWith("/")) //Removes the first '/' in /root
            path=path.substring(1);

        if(path.isEmpty()) //if string is empty after trim and substring give empty array
            return new String[0];

        return path.split("/"); //splits the string using '/' as seperation
        
    }
    public Node findByPath(String Path){ //Method to find when full path is inputed
        String[] parts=splitPath(Path); //We split the path into its components
        if(parts.length==0) //If there are no parts we get null/not found
            return null;
        if(!parts[0].equals("root")) //If first part of path is not root then path is invalid so we return null
            return null;
        Node current=root; //Start traversal from this node
        for (int i=1; i<parts.length; i++){ //Loop to find all children
            String p=parts[i]; //path components
            boolean found= false; //Used to check if component exists in current's children
            for(Node child: current.children){ //Loop over children of current node
                if (child.name.equals(p)){ //If we find child with matching name, we move current to the child and mark as true/found
                    current=child;
                    found=true;
                    break;
                }
            }
            if(!found) //If not found then path is invalid
                return null;
        }
        return current; //we return current node if loop completed
    }

    public boolean create(){
        //Add code to create a new file/folder (node)
        return true;
    }

    public boolean delete(){
        //Add code to delete a folder/file (node)
        return true;
    }

    public void display(){
        //Add code to display the entire structure/tree
    }

    public void searchDFS(){
        //Add code to search using DFS
    }

    public String getPath(Node node){ //Returns absolute path
        if (node==null) //if null passed then no path
            return null;
        List<String> parts= new ArrayList<>(); //Created a list to collect path components
        Node cur=node; //Use cur to start at the requested node
        while (cur!= null){ //Use while to go up to root from current node
            parts.add(cur.name); //Add the current node name to parts
            cur=cur.parent; //Go up to the parent Node
        }
        StringBuilder sb=new StringBuilder(); //For combining/Concatenation the strings in parts
        for(int i=parts.size()-1; i>=0; i--){ 
            sb.append("/").append(parts.get(i)); //Add a '/' and the part of the name
        }
        return sb.toString();
    }

}

