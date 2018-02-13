package dijkstra;

import java.util.List;
import java.util.LinkedList;

public class NodeFactory
{
    public static final LinkedList<Node> llist = new LinkedList();
    
    public static Node getNode(final String city)
    {
        for (int i = 0; i < llist.size(); i++) {
            Node m = llist.get(i);
            if (m.name.equals(city))
            {
                return m;
            }
        }
        
        Node n = new Node(city);
        llist.add(n);
        return n;
    }
    
    public static Node getExistingNode(final String city)
    {
        for (int i = 0; i < llist.size(); i++)
        {
            Node m = llist.get(i);
            if (m.name.equals(city))
            {
                return m;
            }
        }
        return null;
    }
}