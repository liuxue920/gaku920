package com.fafamc.redpackage.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Subpackage implements Serializable {
    private static final long serialVersionUID = -12828578859134400L;

    private Long id;

    private Long packageId;

    private Integer money;

    private String userName;

}