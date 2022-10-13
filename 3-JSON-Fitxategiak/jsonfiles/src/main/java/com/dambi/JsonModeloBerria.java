package com.dambi;

import javax.json.Json;
import javax.json.JsonObject;

public class JsonModeloBerria {

    public static void main(String[] args) {

        JsonObject model = Json.createObjectBuilder()

                .add("menu", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("id", "file")
                                .add("value", "File")
                                .add("popup", Json.createArrayBuilder()
                                        .add(Json.createObjectBuilder()

                                                .add("value", "New")
                                                .add("oncliclk", "CreateNewDoc()")))))

                .build();
        System.out.println(model);

    }

}
