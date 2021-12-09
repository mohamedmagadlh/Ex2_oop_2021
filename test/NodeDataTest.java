package api.test;

import api.api.NodeData;
import api.imp.DWG;
import api.imp.impGeoLocation;
import api.imp.impNodeData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeDataTest {
    impGeoLocation G1 = new impGeoLocation(25,2,0);
    impNodeData N1 = new impNodeData(1,G1,0.0);
    impGeoLocation G2 = new impGeoLocation(16.2,3,0);
    impNodeData N2 = new impNodeData(2,G2,0.0);
    impGeoLocation G3 = new impGeoLocation(10,15,0);
    impNodeData N3 = new impNodeData(3,G3,0.0);

    @Test
    void getKey() {
    }

    @Test
    void getLocation() {
    }

    @Test
    void setLocation() {
    }

    @Test
    void getWeight() {
    }

    @Test
    void setWeight() {
    }

    @Test
    void getInfo() {
    }

    @Test
    void setInfo() {

    }

    @Test
    void getTag() {
    }

    @Test
    void setTag() {
    }
}