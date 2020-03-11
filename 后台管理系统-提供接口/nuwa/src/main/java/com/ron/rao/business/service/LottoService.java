package com.ron.rao.business.service;

import com.ron.rao.business.model.Lotto;

import java.util.List;

public interface LottoService {
    List<Lotto> getAllLottoList();

    Lotto getLottoById(Integer id);

    void saveLotto(Lotto Lotto);

    /**
     * 获取所有未中的奖品
     * @return
     */
    List<Lotto> getAllLottoNoPrizeList();

    /**
     * 获取已中奖奖品列表
     * @return
     */
    List<Lotto> getAllLottoPrizeList();

}
