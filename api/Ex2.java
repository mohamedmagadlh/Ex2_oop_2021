package api.api;

import api.Gui.Myframe;
import api.api.DirectedWeightedGraph;
import api.api.DirectedWeightedGraphAlgorithms;
import api.imp.DWG;
import api.imp.DWGAlgo;

/**
 * This class is the main class for Ex2 - your implementation will be tested using this class.
 */
public class Ex2 {
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraph getGraph(String json_file) {
        DirectedWeightedGraph graph = new DWG();
        DWGAlgo graphAlgo = new DWGAlgo();
        graphAlgo.init(graph);//Init the graph on which this set of algorithms operates on.
        graphAlgo.load(json_file);//load this json_file
        return graphAlgo.getGraph();
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static DirectedWeightedGraphAlgorithms getGrapgAlgo(String json_file) {
        DirectedWeightedGraph graph = new DWG();
        DWGAlgo graphAlgo = new DWGAlgo();
        graphAlgo.init(graph);
        graphAlgo.load(json_file);
        return graphAlgo;
    }
    /**
     * This static function will run your GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        DirectedWeightedGraphAlgorithms alg = getGrapgAlgo(json_file);
        // ****** Add your code here ******
        alg = getGrapgAlgo(json_file);
        Myframe win = new Myframe((DWGAlgo) alg);
        // ********************************
    }
}