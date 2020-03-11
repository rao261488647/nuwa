package com.ron.rao.business.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Lotto {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 奖品名称
     */
    @Column(name = "LOTTO_PRIZE")
    private String lottoPrize;

    /**
     * 生成图片存放地址
     */
    @Column(name = "IMG_URL")
    private String imgUrl;

    /**
     * 是否中奖 0 否 1 是
     */
    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取奖品名称
     *
     * @return LOTTO_PRIZE - 奖品名称
     */
    public String getLottoPrize() {
        return lottoPrize;
    }

    /**
     * 设置奖品名称
     *
     * @param lottoPrize 奖品名称
     */
    public void setLottoPrize(String lottoPrize) {
        this.lottoPrize = lottoPrize;
    }

    /**
     * 获取生成图片存放地址
     *
     * @return IMG_URL - 生成图片存放地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置生成图片存放地址
     *
     * @param imgUrl 生成图片存放地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取是否中奖 0 否 1 是
     *
     * @return STATUS - 是否中奖 0 否 1 是
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否中奖 0 否 1 是
     *
     * @param status 是否中奖 0 否 1 是
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}