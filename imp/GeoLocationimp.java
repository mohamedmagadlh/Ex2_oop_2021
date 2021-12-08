package api.imp;

import api.api.GeoLocation;

public class GeoLocationimp implements GeoLocation {
    private double x;
    private double  y;
    private  double z;
    public GeoLocationimp(double x, double y, double z)
    {
     this.x=x;
     this.y=y;
     this.z=z;
    }
    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        if(g instanceof GeoLocationimp) {
            GeoLocationimp G = (GeoLocationimp) g;
            return Math.sqrt(Math.pow(this.x - G.x, 2) + Math.pow(this.y - G.y, 2) + Math.pow(this.z - G.z, 2));
        }
        else  return -1;

    }
    public String toString() {
        return "My_GoeLocation{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
