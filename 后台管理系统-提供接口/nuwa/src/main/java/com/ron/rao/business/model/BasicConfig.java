package com.ron.rao.business.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "basic_config")
@Data
public class BasicConfig {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 是否跳过开场动画页面
     */
    @Column(name = "IS_JUMP")
    private String isJump;

    /**
     * 女娲开场白
     */
    @Column(name = "NUWA_TIP")
    private String nuwaTip;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    private Integer lottoNum;

}