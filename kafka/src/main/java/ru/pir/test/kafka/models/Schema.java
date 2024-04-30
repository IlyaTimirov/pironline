package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Schema {

    @SerializedName("type")

    private String type;
    @SerializedName("fields")

    private List<Field> fields;
    @SerializedName("optional")

    private Boolean optional;
    @SerializedName("name")

    private String name;
    @SerializedName("version")

    private Integer version;

}
