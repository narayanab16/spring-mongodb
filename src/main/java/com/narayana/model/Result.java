package com.narayana.model;

import java.io.Serializable;

public class Result implements Serializable {
    String domainResult;
    Integer total;

    public String getDomainResult() {
        return domainResult;
    }

    public Integer getTotal() {
        return total;
    }
}
