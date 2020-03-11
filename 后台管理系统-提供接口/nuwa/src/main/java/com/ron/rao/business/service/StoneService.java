package com.ron.rao.business.service;

import com.ron.rao.business.model.Stone;

import java.util.List;

public interface StoneService {


    List<Stone> getAllStoneList();

    Stone getStoneById(Integer id);

    void saveStone(Stone stone);

    /**
     * 根据密文查询是否可以激活
     * @param text
     * @return
     */
    Stone getStoneByCipherText(String text);
}
