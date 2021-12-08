package api.imp;

import api.api.GeoLocation;
import api.api.NodeData;
import com.google.gson.*;

import java.lang.reflect.Type;

public class NJson implements JsonDeserializer<NodeData>, JsonSerializer<NodeData> {

    @Override
    public NodeData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int id = jsonObject.get("key").getAsInt();
        String pos = jsonObject.get("pos").getAsString();
        String [] posArr = pos.split(",");
        double x = Double.parseDouble(posArr[0]);
        double y = Double.parseDouble(posArr[1]);
        double z = Double.parseDouble(posArr[2]);
        GeoLocation g = new GeoLocationimp(x,y,z);
        NodeData newNode = new nodeDataimp(id, g, 0.0, 0, "");

        return newNode;
    }

    @Override
    public  JsonElement serialize(NodeData node, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject J = new JsonObject();
        J.addProperty("id", node.getKey());
        J.addProperty("pos",node.getLocation().toString());

        return J;
    }
}