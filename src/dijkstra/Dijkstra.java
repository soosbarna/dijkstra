package dijkstra;

import java.util.List;
import java.util.LinkedList;

public class Dijkstra
{
    public static List<String> searchPath(final String start, final String end)
    {
        Node startnode = NodeFactory.getExistingNode(start);
        Node endnode = NodeFactory.getExistingNode(end); 
        List<Node> list = (LinkedList<Node>) NodeFactory.llist.clone();
        List<String> retList = new LinkedList<>();
        
        for (Node n : list)
        {
            n.dist = 600;
        }
        startnode.dist = 0;
        
        while(!list.isEmpty())
        {
            Node u = list.get(0);
            for (int i = 1; i < list.size(); i++)
            {
                Node k = list.get(i);
                if (k.dist < u.dist)
                {
                    u = k;
                }
            }
            list.remove(u);
            
            if (u == endnode)
            {
                Node current = u;
                while(current.prev != null)
                {
                    retList.add(current.name);
                    current = current.prev;
                }
                return retList;
            }
            
            List<Node.Pair> negis = u.neigs;
            for (int i = 0; i < negis.size(); i++) {
                Node v = negis.get(i).node;
                if (list.contains(v))
                {
                    int a = u.dist + negis.get(i).cost;
                    if (a < v.dist)
                    {
                        v.dist = a;
                        v.prev = u;
                    }
                }  
            }  
        }
        return new LinkedList<>(); 
    }
}
