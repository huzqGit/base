package com.common.echarts.json;

import java.lang.reflect.Type;
import java.util.Map;

import com.common.echarts.code.SeriesType;
import com.common.echarts.series.Bar;
import com.common.echarts.series.Chord;
import com.common.echarts.series.Force;
import com.common.echarts.series.Funnel;
import com.common.echarts.series.Gauge;
import com.common.echarts.series.Island;
import com.common.echarts.series.K;
import com.common.echarts.series.Line;
import com.common.echarts.series.Pie;
import com.common.echarts.series.Radar;
import com.common.echarts.series.Scatter;
import com.common.echarts.series.Series;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * @author liuzh
 */
public class SeriesDeserializer implements JsonDeserializer<Series> {
    public Series deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        String _type = jsonObject.get("type").getAsString();
        SeriesType type = SeriesType.valueOf(_type);
        Series series = null;
        switch (type) {
            case line:
                series = context.deserialize(jsonObject, Line.class);
                break;
            case bar:
                series = context.deserialize(jsonObject, Bar.class);
                break;
            case scatter:
                series = context.deserialize(jsonObject, Scatter.class);
                break;
            case funnel:
                series = context.deserialize(jsonObject, Funnel.class);
                break;
            case pie:
                series = context.deserialize(jsonObject, Pie.class);
                break;
            case force:
                series = context.deserialize(jsonObject, Force.class);
                break;
            case gauge:
                series = context.deserialize(jsonObject, Gauge.class);
                break;
            case map:
                series = context.deserialize(jsonObject, Map.class);
                break;
            case island:
                series = context.deserialize(jsonObject, Island.class);
                break;
            case k:
                series = context.deserialize(jsonObject, K.class);
                break;
            case radar:
                series = context.deserialize(jsonObject, Radar.class);
                break;
            case chord:
                series = context.deserialize(jsonObject, Chord.class);
                break;
        }
        return series;
    }
}
