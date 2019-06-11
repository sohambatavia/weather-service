package au.origin.weather.infrastructure.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonWrapper {

    @JsonProperty("cities")
    private List<Map<String, Object>> list;

    public List<Map<String, Object>> getList() {

        return list;
    }

    public void setList(List<Map<String, Object>> list) {

        this.list = list;
    }

}
