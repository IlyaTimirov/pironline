package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeEvent<T> {
    @SerializedName("schema")
    private Schema schema;

    @SerializedName("payload")
    private Payload<T> payload;
}


