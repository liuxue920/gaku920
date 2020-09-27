package com.fafamc.gaku.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
}
