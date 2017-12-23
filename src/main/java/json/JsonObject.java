package json;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> ajpairs = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {

        for (JsonPair jp :
                jsonPairs) {
            this.add(jp);
        }
    }

    @Override
    public String toJson() {
        StringBuilder to_return = new StringBuilder();
        to_return.append('{');
        for (JsonPair jp :
                ajpairs) {
            to_return.append(jp.key).append(": ").append(jp.value.toJson().toString()).append(", ");

        }
        if (to_return.length() > 1)
            to_return.delete(to_return.length() - 2, to_return.length());
        to_return.append('}');
        return to_return.toString();
    }

    public void add(JsonPair jsonPair) {

        boolean coincidence = false;
        JsonPair jp;
        for (int i = 0; i < ajpairs.size(); i++) {
            jp = ajpairs.get(i);
            if (jp.key.equals(jsonPair.key)) {
                ajpairs.set(i, jsonPair);
                coincidence = true;
            }

        }
        if (!coincidence)
            ajpairs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair jp :
                ajpairs) {
            if (jp.key.equals(name))
                return jp.value;

        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject to_return = new JsonObject();
        for (String name :
                names) {
            if (find(name) != null)
                to_return.add(new JsonPair(name, find(name)));
        }
        return to_return;
    }
}
