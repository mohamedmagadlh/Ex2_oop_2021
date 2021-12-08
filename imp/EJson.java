package api.imp;

import api.api.EdgeData;
import com.google.gson.*;

import java.lang.reflect.Type;

public class EJson implements  JsonSerializer<EdgeData> {

    public  JsonElement serialize(EdgeData edge, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject J = new JsonObject();
        J.addProperty("src",edge.getSrc());
        J.addProperty("w", edge.getWeight());
        J.addProperty("dest", edge.getDest());
        return J;
    }
}