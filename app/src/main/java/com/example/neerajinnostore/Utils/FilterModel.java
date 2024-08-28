package com.example.neerajinnostore.Utils;

public class FilterModel {
    String Id;
    String FilterName;

    public FilterModel(String id, String filterName) {
        Id = id;
        FilterName = filterName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFilterName() {
        return FilterName;
    }

    public void setFilterName(String filterName) {
        FilterName = filterName;
    }
}
