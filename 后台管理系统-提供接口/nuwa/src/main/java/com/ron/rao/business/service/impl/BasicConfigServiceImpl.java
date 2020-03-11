package com.ron.rao.business.service.impl;

import com.ron.rao.business.dao.BasicConfigMapper;
import com.ron.rao.business.model.BasicConfig;
import com.ron.rao.business.service.BasicConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("basicConfigService")
public class BasicConfigServiceImpl implements BasicConfigService {

    @Autowired
    BasicConfigMapper basicConfigMapper;

    @Override
    public BasicConfig getBasicConfig() {
        return basicConfigMapper.selectAll().get(0);
    }

    @Override
    public void updateBaseCofig(BasicConfig config) {
        basicConfigMapper.updateByPrimaryKeySelective(config);
    }
}
