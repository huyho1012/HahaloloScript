package common.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DummyDataJSON {
    public static DummyDataJSON getDummyData(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return mapper.readValue(new File(filename), DummyDataJSON.class);
    }

    @JsonProperty("content10000Chars")
    String content10000Chars;

    @JsonProperty("content10001Chars")
    String content10001Chars;

    @JsonProperty("content20000Chars")
    String content20000Chars;

    @JsonProperty("content20001Chars")
    String content20001Chars;

    @JsonProperty("updateContent")
    String updateContent;

    @JsonProperty("newContent")
    String newContent;

    public String getContent10000Chars() {
        return content10000Chars;
    }

    public void setContent10000Chars(String content10000Chars) {
        this.content10000Chars = content10000Chars;
    }

    public String getContent10001Chars() {
        return content10001Chars;
    }

    public void setContent10001Chars(String content10001Chars) {
        this.content10001Chars = content10001Chars;
    }

    public String getContent20001Chars() {
        return content20001Chars;
    }

    public void setContent20001Chars(String content20001Chars) {
        this.content20001Chars = content20001Chars;
    }


    public String getContent20000Chars() {
        return content20000Chars;
    }

    public void setContent20000Chars(String content20000Chars) {
        this.content20000Chars = content20000Chars;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

}
