package com.ron.rao.business.service.impl;

import com.ron.rao.business.dao.LottoMapper;
import com.ron.rao.business.model.Lotto;
import com.ron.rao.business.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("lottoService")
public class LottoServiceImpl implements LottoService {

    @Autowired
    private LottoMapper lottoMapper;
    @Override
    public List<Lotto> getAllLottoList() {
        return lottoMapper.selectAll();
    }

    @Override
    public Lotto getLottoById(Integer id) {
        return lottoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveLotto(Lotto lotto) {
        if(lotto.getId() != null){
            lottoMapper.updateByPrimaryKeySelective(lotto);
        }else{
            lotto.setCreateTime(new Date());
            lottoMapper.insertSelective(lotto);
        }
    }

    /**
     * 获取所有未中的奖品
     *
     * @return
     */
    @Override
    public List<Lotto> getAllLottoNoPrizeList() {
        Lotto lotto = new Lotto();
        lotto.setStatus("0");

        return lottoMapper.select(lotto);
    }

    /**
     * 获取已中奖奖品列表
     *
     * @return
     */
    @Override
    public List<Lotto> getAllLottoPrizeList() {
        Lotto lotto = new Lotto();
        lotto.setStatus("1");

        return lottoMapper.select(lotto);
    }
}
