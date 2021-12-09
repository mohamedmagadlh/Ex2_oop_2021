package api.test;

import api.api.EdgeData;
import api.imp.impEdgeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeDataTest {
    int Src=6,Dest=18,tag=1;
    double weight=0.9;
    String Info = "mo";
    EdgeData test = new impEdgeData(Src,Dest,weight,Info,tag);
    @Test
    void getSrc() {
        assertEquals(test.getSrc(),Src);
    }

    @Test
    void getDest() {
        assertEquals(test.getDest(),Dest);
    }

    @Test
    void getWeight() {
        assertEquals((int) test.getWeight(),(int) weight);
    }

    @Test
    void getInfo() {
        assertEquals(test.getInfo(),Info);
    }

    @Test
    void setInfo() {
        test.setInfo("ibra");
        assertEquals(test.getInfo(),"ibra");
    }

    @Test
    void getTag() {
        assertEquals(test.getTag(),tag);
    }

    @Test
    void setTag() {
        test.setTag(2);
        assertEquals(test.getTag(),2);
    }
}