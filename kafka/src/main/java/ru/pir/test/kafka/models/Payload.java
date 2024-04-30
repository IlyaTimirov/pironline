package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Payload<T> {

    @SerializedName("before")
    private T before;

    @SerializedName("after")
    private T after;

    @SerializedName("op")
    private String op;

    @SerializedName("ts_ms")
    private Long tsMs;

    @SerializedName("transaction")
    private Object transaction;
}
