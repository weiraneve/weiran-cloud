package com.weiran.graphql.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    // 型号代码
    @Column(name = "model_code", nullable = false)
    private String modelCode;

    // 品牌
    @Column(name = "brand_name")
    private String brandName;

    // 发售日期
    @Column(name = "launch_date")
    private LocalDate launchDate;

    // 格式化日期
    private transient String formattedDate;

    // Getter and setter
    public String getFormattedDate() {
        return getLaunchDate().toString();
    }
}
