package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class Source {

    @SerializedName("version")
    private String version;

    @SerializedName("connector")
    private String connector;

    @SerializedName("name")
    private String name;

    @SerializedName("ts_ms")
    private Long tsMs;

    @SerializedName("snapshot")
    private String snapshot;

    @SerializedName("db")
    private String db;

    @SerializedName("sequence")
    private List<String> sequence;

    @SerializedName("schema")
    private String schema;

    @SerializedName("table")
    private String table;

    @SerializedName("txId")
    private Integer txId;

    @SerializedName("lsn")
    private Integer lsn;

    @SerializedName("xmin")
    private Object xmin;
}
