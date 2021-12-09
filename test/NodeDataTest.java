package api.test;

import api.api.GeoLocation;
import api.api.NodeData;
import api.imp.DWG;
import api.imp.impGeoLocation;
import api.imp.impNodeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeDataTest {
    impGeoLocation G = new impGeoLocation(25,2,0);
    impNodeData N = new impNodeData(1,G,0.0,"m",2);

    @Test
    void getKey() {
        int k = N.getKey();
        assertEquals(k, 1);
    }

    @Test
    void getLocation() {
        GeoLocation g1 = N.getLocation();
        assertEquals(G.x(), g1.x());
        assertEquals(G.y(),g1.y());
        assertEquals(G.z(), g1.z());
    }

    @Test
    void setLocation() {

        GeoLocation G1 = new impGeoLocation(22, 1.5, 1.9);
        N.setLocation(G1);
        GeoLocation G2 = N.getLocation();
        assertEquals(G1.x(), G2.x());
        assertEquals(G1.y(), G2.y());
        assertEquals(G1.z(), G2.z());
    }
    @Test
    void getWeight() {
        double w = N.getWeight();
        assertEquals(w, 0.0);
    }

    @Test
    void setWeight() {
        N.setWeight(2.9);
        assertEquals(N.getWeight(),2.9);
    }

    @Test
    void getInfo() {
        String S = N.getInfo();
        assertTrue(S.equals("m"));
    }

    @Test
    void setInfo() {
        N.setInfo("12");
        String i = N.getInfo();
        assertTrue(i.equals("12"));

    }

    @Test
    void getTag() {
        int tag = N.getTag();
        assertEquals(tag, 2);
    }

    @Test
    void setTag() {
        N.setTag(0);
        int tag = N.getTag();
        assertEquals(tag,0);
    }
}