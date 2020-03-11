package com.ron.rao.business.service.impl;

import com.ron.rao.business.dao.StoneMapper;
import com.ron.rao.business.model.Stone;
import com.ron.rao.business.service.StoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stoneService")
public class StoneServiceImpl implements StoneService {

    @Autowired
    StoneMapper stoneMapper;


    @Override
    public List<Stone> getAllStoneList() {
        return stoneMapper.selectAll();
    }

    @Override
    public Stone getStoneById(Integer id) {
        return stoneMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveStone(Stone stone) {
        stoneMapper.updateByPrimaryKeySelective(stone);
    }

    /**
     * 根据密文查询是否可以激活
     *
     * @param text
     * @return
     */
    @Override
    public Stone getStoneByCipherText(String text) {
        Stone st = new Stone();
        st.setCipherText(text);

        return stoneMapper.selectOne(st);
    }
}
