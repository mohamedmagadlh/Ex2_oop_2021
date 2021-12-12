package api.imp;

import api.api.DirectedWeightedGraph;
import api.api.EdgeData;
import api.api.NodeData;
import java.util.Set;
import java.util.*;

public class DWG implements DirectedWeightedGraph {
      NodeData nodeData;
     public HashMap<Integer, NodeData> NodesHash;
    public HashMap<Integer,HashMap<Integer,EdgeData>>EdgesHash;
     int MC;
    public DWG()
    {
        this.nodeData=null;
       this.NodesHash=new HashMap<Integer, NodeData> ();
       this.EdgesHash=new HashMap<Integer,HashMap<Integer,EdgeData>>();
        this.MC=0;
    }
    @Override
    public NodeData getNode(int key) {
        return NodesHash.get(key);
    }
    @Override
    public EdgeData getEdge(int src, int dest) {
        if(NodesHash.containsKey(src) && NodesHash.containsKey(dest) &&EdgesHash.get(src).containsKey(dest))
            return EdgesHash.get(src).get(dest);
        return null;
    }
    @Override
    public void addNode(NodeData n) {
        if(NodesHash.containsKey(n.getKey()) || n.getWeight()<=0)
        {
            System.err.println("ADD IS FAIL");
            return;
        }
        NodesHash.put(n.getKey(),n);
        EdgesHash.put(n.getKey(),new HashMap<Integer,EdgeData>());
        MC++;
    }

    @Override
    public void connect(int src, int dest, double w) {
    impEdgeData e=new impEdgeData(src,dest,w);
    if(NodesHash.containsKey(src)&& NodesHash.containsKey(dest) && w>0)
        EdgesHash.get(src).put(dest,e);
    else {
        System.err.println("CONNECT FAIL\nn");
        return;
    }
    MC++;
    }
    @Override
    public Iterator<NodeData> nodeIter() {
        return this.NodesHash.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return (Iterator)this.EdgesHash.values().iterator();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        if(NodesHash.containsKey(key)) {
            NodesHash.remove(key);
            Set<Integer> Keys=EdgesHash.keySet();
            for(Integer e:Keys)
            {
                if(EdgesHash.get((int)e).containsKey(key))
                    EdgesHash.get((int)e).remove(key);
            }
        }
        else {
            System.err.println("REMOVE NODE FAIL\n");
            return null;
        }
        MC++;
        return this.NodesHash.remove(key);
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(getEdge(src,dest)==null)return null;
        impEdgeData e=new impEdgeData(src,dest);
        EdgesHash.get(src).remove(dest);
        MC++;
        return e;
    }

    @Override
    public int nodeSize() {
        return NodesHash.size();
    }

    @Override
    public int edgeSize() {
        return EdgesHash.size();
    }

    @Override
    public int getMC() {
        return MC;

    }
    public void setMC(int m)
    {
        this.MC=m;
    }

    @Override
    public String toString() {
        return "DirectedWeightedGraphClass{" +
                "nodeData=" + nodeData +
                ", NodesHash=" + NodesHash +
                ", EdgesHash=" + EdgesHash +
                ", MC=" + MC +
                '}';
    }
}
