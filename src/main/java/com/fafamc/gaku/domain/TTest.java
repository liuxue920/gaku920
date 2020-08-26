package com.fafamc.gaku.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author gaku9
 * @Create 2020/7/12
 **/
@Table(name="t_test")
@Data
public class TTest implements Serializable {

    @Id
    private Long id;

    private String name;
}
