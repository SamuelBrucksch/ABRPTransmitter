package g4rb4g3.at.abrptransmitter.gson;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GSONDoubleTypeAdapter extends TypeAdapter<Double> {
    @Override
    public void write(JsonWriter out, Double value) throws IOException {
        out.value(value);
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        // required to not throw on null or empty values

        JsonToken jsonToken = in.peek();
        switch (jsonToken) {
            case NUMBER:
            case STRING:
                String s = in.nextString();
                try {
                    return Double.parseDouble(s);
                } catch (NumberFormatException ignored) {
                }
                return null;
            case NULL:
                in.nextNull();
                return null;
            default:
                throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
        }
    }
}
