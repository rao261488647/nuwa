package com.ron.rao.business.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Stone {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 神石碎片编号
     */
    @Column(name = "STONE_NO")
    private String stoneNo;

    /**
     * 触碰神石碎片提示的信息
     */
    @Column(name = "TIP_INFO")
    private String tipInfo;

    /**
     * 密文
     */
    @Column(name = "CIPHER_TEXT")
    private String cipherText;

    /**
     * 是否被破译
     */
    @Column(name = "IS_DECODE")
    private String isDecode;

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
     * 获取神石碎片编号
     *
     * @return STONE_NO - 神石碎片编号
     */
    public String getStoneNo() {
        return stoneNo;
    }

    /**
     * 设置神石碎片编号
     *
     * @param stoneNo 神石碎片编号
     */
    public void setStoneNo(String stoneNo) {
        this.stoneNo = stoneNo;
    }

    /**
     * 获取触碰神石碎片提示的信息
     *
     * @return TIP_INFO - 触碰神石碎片提示的信息
     */
    public String getTipInfo() {
        return tipInfo;
    }

    /**
     * 设置触碰神石碎片提示的信息
     *
     * @param tipInfo 触碰神石碎片提示的信息
     */
    public void setTipInfo(String tipInfo) {
        this.tipInfo = tipInfo;
    }

    /**
     * 获取密文
     *
     * @return CIPHER_TEXT - 密文
     */
    public String getCipherText() {
        return cipherText;
    }

    /**
     * 设置密文
     *
     * @param cipherText 密文
     */
    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    /**
     * 获取是否被破译
     *
     * @return IS_DECODE - 是否被破译
     */
    public String getIsDecode() {
        return isDecode;
    }

    /**
     * 设置是否被破译
     *
     * @param isDecode 是否被破译
     */
    public void setIsDecode(String isDecode) {
        this.isDecode = isDecode;
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