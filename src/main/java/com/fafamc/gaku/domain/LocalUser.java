package com.fafamc.gaku.domain;

import lombok.Data;

import java.util.List;

@Data
public class LocalUser {
    private String id;
    private String name;
    private List<Role> roleList;
}
