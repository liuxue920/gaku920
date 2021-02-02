package com.fafamc.forfun.clone;

import java.io.Serializable;

//@Data
public class SonBottle implements  Serializable {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
