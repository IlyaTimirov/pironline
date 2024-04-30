package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Field {

    @SerializedName("type")
    private String type;

    @SerializedName("optional")
    private Boolean optional;

    @SerializedName("default")
    private String _default;

    @SerializedName("field")
    private String field;

    @SerializedName("name")
    private String name;

    @SerializedName("version")
    private Integer version;

    @SerializedName("parameters")
    private Parameters parameters;


    @SerializedName("fields")
    private List<Field> fields;
}
