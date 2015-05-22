package com.common.echarts.json;

import java.lang.reflect.Type;

import com.common.echarts.axis.Axis;
import com.common.echarts.axis.CategoryAxis;
import com.common.echarts.axis.TimeAxis;
import com.common.echarts.axis.ValueAxis;
import com.common.echarts.code.AxisType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * @author liuzh
 */
public class AxisDeserializer implements JsonDeserializer<Axis> {
    public Axis deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        String _type = jsonObject.get("type").getAsString();
        AxisType type = AxisType.valueOf(_type);
        Axis axis = null;
        switch (type) {
            case category:
                axis = context.deserialize(jsonObject, CategoryAxis.class);
                break;
            case value:
                axis = context.deserialize(jsonObject, ValueAxis.class);
                break;
            case time:
                axis = context.deserialize(jsonObject, TimeAxis.class);
                break;
        }
        return axis;
    }
}
