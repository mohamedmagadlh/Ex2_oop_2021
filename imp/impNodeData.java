package api.imp;

import api.api.GeoLocation;
import api.api.NodeData;

import java.util.ArrayList;
import java.util.Collection;
public class impNodeData implements NodeData {
    private int key;
    private GeoLocation geoLocation;
    private double weight;
    private int tag;
    private String info;
    private static int white = 0;
    private static int black = 1;
    private static int gray = 2;
    public impNodeData(int key, GeoLocation geoLocation, double weight,String info, int tag)
    {
        this.key=key;
        this.geoLocation=geoLocation;
        this.weight=weight;
        this.tag=tag;
        this.info=info;
    }


    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        if(this.geoLocation==null)return null;
        return this.geoLocation;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.geoLocation=p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight=w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;
    }

    @Override
    public String toString() {
        return "NodeDataCLass{" +
                "key=" + key +
                ", geoLocation=" + geoLocation +
                ", weight=" + weight +
                ", tag=" + tag +
                ", info='" + info + '\'' +
                '}';
    }
}
