package api.imp;

import api.api.DirectedWeightedGraph;
import api.api.DirectedWeightedGraphAlgorithms;
import api.api.NodeData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class DWGAlgo implements DirectedWeightedGraphAlgorithms {
    private DWG g;

    @Override
    public void init(DirectedWeightedGraph g) {

        this.g = (DWG) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {

        return this.g;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DWG newG = new DWG();
        for (NodeData i : this.g.NodesHash.values()) {
            NodeData v = new impNodeData(i.getKey(), i.getLocation(), i.getWeight(), i.getTag(), i.getInfo());
            newG.NodesHash.put(v.getKey(), v);
            newG.addNode(v);
        }
        newG.setMC(g.getMC());

        NodeData vert = new impNodeData(this.g.nodeData.getKey(), this.g.nodeData.getLocation(), this.g.nodeData.getWeight(), this.g.nodeData.getTag(), this.g.nodeData.getInfo());

        return newG;
    }

    @Override
    public boolean isConnected() {
        for (int i = 0; i < this.g.NodesHash.size(); i++) {
            boolean[] visited = new boolean[this.g.NodesHash.size()];
            DFS(this.g.NodesHash.get(i).getKey(), visited);
            for (boolean b : visited)
                if (!b) return false;

        }
        return true;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {

        return null;
    }

    @Override
    public NodeData center() {
        if (!isConnected()){
            return null;
        }
        double rad = Integer.MAX_VALUE;
        int n = this.g.nodeSize();
        double[][] dist = new double [n][n];
        double [] ecc = new double[n];
        ArrayList<Integer> centL = new ArrayList<>();
        double diam = 0;
        for(int k = 0; k < n; k++){
            for(int j = 0; j < n; j++){
                for (int i = 0; i < n; i++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ecc[i] = Math.max(ecc[i], dist[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            rad = Math.min(rad, ecc[i]);
            diam = Math.max(diam, ecc[i]);
        }
        for (int i = 0; i < n; i++) {
            if (ecc[i] == rad) {
                centL.add(i);
            }
        }
        int h = centL.size();
        Integer[] centA = new Integer[h];
        centA = centL.toArray(centA);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < centA.length; i++){
            if(centA[i] < min)
                min = centA[i];
        }
        return this.g.getNode(min);
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        GsonBuilder g = new GsonBuilder();
        g.registerTypeAdapter(DWG.class, new Json_Graph());
        Gson gson = g.create();
        String json = gson.toJson(getGraph());
        try {
            PrintWriter p = new PrintWriter(new File(file));
            p.write(json);
            p.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean load(String file) {
        try {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(DWG.class, new Json_Graph());
            Gson gson = builder.create();

            FileReader reader = new FileReader(file);
            DWG nGraph = gson.fromJson(reader, DWG.class);
            this.init(nGraph);
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void DFS(int v, boolean[] visited)//algo DFS
    {
        // mark current node as visited
        visited[v] = true;
        // do for every edge (v, u)
        for (int j = 0; j < g.NodesHash.size(); j++) {
            if (this.g.EdgesHash.get(v).containsKey(j)) {
                if (!visited[j]) {
                    DFS(j, visited);

                }
            }
        }

    }
}