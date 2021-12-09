package api.test;

import api.api.GeoLocation;
import api.imp.impGeoLocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class impGeoLocationTest {
    GeoLocation Gsrc=new impGeoLocation(15,17,22.3);
    GeoLocation Gdest=new impGeoLocation(1,4,2.5);
    @Test
    void x() {
        assertEquals(Gsrc.x(),15);
        assertNotEquals(Gsrc.x(),2);
    }

    @Test
    void y() {
        assertEquals(Gsrc.y(),17);
        assertNotEquals(Gsrc.y(),1.5);
    }

    @Test
    void z() {
        assertEquals(Gsrc.z(),22.3);
        assertNotEquals(Gsrc.z(),9.1);
    }

    @Test
    void distance() {
        assertEquals(Gsrc.distance(Gdest),27.514359887157106);
    }
}