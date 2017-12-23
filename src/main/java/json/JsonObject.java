package json;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> ajpairs = new ArrayList<JsonPair>();

    public JsonObject(JsonPair... jsonPairs) {

        for (JsonPair jp:
             jsonPairs) {
            this.add(jp);
        }
    }

    @Override
    public String toJson() {
        String to_return = new String();
        to_return += '{';
        for (JsonPair jp:
             ajpairs) {
            to_return += jp.key + ": " + jp.value.toJson().toString() + ", ";

        }
        if(to_return.length() > 1)
            to_return = to_return.substring(0, to_return.length()-2);
        to_return += '}';
        return to_return;
    }

    public void add(JsonPair jsonPair) {

        boolean coincidence = false;
        JsonPair jp;
        for (int i = 0; i < ajpairs.size(); i++) {
            jp = ajpairs.get(i);
            if (jp.key == jsonPair.key){
                ajpairs.set(i, jsonPair);
                coincidence = true;

            }

        }
        if(!coincidence)
            ajpairs.add(jsonPair);
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {

        return null;
    }
}
