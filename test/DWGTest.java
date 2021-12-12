package api.test;

import api.api.NodeData;
import api.imp.DWG;
import api.imp.impNodeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DWGTest {


    @Test
    void getNode() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        d.addNode(n);
        assertEquals(d.getNode(0),n);

    }

    @Test
    void getEdge() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,2,"",0);
        d.addNode(n);
        d.addNode(y);
        d.connect(n.getKey(),y.getKey(),3);
        assertEquals(d.EdgesHash.get(n.getKey()).containsKey(y.getKey()),true);
    }

    @Test
    void addNode() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        d.addNode(n);
        assertEquals(d.NodesHash.containsKey(n.getKey()),true);
    }

    @Test
    void connect() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,2,"",0);
        NodeData z=new impNodeData(2,null,2,"",0);
        d.addNode(n);
        d.addNode(y);
        d.connect(n.getKey(),y.getKey(),2);

        assertEquals(d.EdgesHash.get(n.getKey()).containsKey(y.getKey()),true);
        assertEquals(d.EdgesHash.get(n.getKey()).containsKey(z.getKey()),false);
    }

    @Test
    void removeNode() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        d.addNode(n);
        assertEquals(d.NodesHash.size()==1,true);
        d.removeNode(n.getKey());
        assertEquals(d.NodesHash.size()==0,true);
    }

    @Test
    void removeEdge() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,1,"",0);

        d.addNode(y);  d.addNode(n);
        d.connect(n.getKey(),y.getKey(),2);
        assertEquals(d.EdgesHash.get(n.getKey()).containsKey(y.getKey()),true);
        d.removeEdge(n.getKey(),y.getKey());
        assertEquals(d.EdgesHash.get(n.getKey()).containsKey(y.getKey()),false);


    }

    @Test
    void nodeSize() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,1,"",0);

        d.addNode(y);  d.addNode(n);
        assertEquals(d.nodeSize(),2);

    }

    @Test
    void edgeSize() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,1,"",0);
        d.addNode(y);  d.addNode(n);
    }

    @Test
    void getMC() {
        DWG d=new DWG();
        NodeData n=new impNodeData(0,null,1,"",0);
        NodeData y=new impNodeData(1,null,1,"",0);
        d.addNode(n);
        d.addNode(y);
        assertEquals( d.getMC(),2);
    }

}