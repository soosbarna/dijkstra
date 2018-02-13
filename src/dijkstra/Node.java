package dijkstra;

import java.util.List;
import java.util.LinkedList;

public class Node
{
    class Pair
    {
        int cost;
        Node node;
    }
    
    final String name;
    int dist;
    Node prev;
    final List<Pair> neigs;
    
    Node(String _name)
    {
        name = _name;
        neigs = new LinkedList<>();
        dist = 500;
    }
    
    void addNeig(Node city, int dist)
    {
        Pair pair = new Pair();
        pair.node = city;
        pair.cost = dist;
        neigs.add(pair);
    }
}
