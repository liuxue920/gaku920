package com.fafamc.redpackage.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Package implements Serializable {
    private static final long serialVersionUID = -70825879477996907L;

    private Long id;

    private String message="恭喜发财";

    private String imageUrl;

    @JSONField(format="YYYY-MM-DD HH:mm:SS")
    private Date sendDateTime;

    //0-->平均   1-->抢红包
    private int model;

    //总共金额
    private int total;

    //多少个红包
    private int pNum;

    private List<Subpackage> subpackageList=new ArrayList<>();

}