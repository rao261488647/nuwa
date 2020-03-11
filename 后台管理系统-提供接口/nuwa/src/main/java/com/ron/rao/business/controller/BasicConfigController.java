package com.ron.rao.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.ron.rao.business.model.BasicConfig;
import com.ron.rao.business.service.BasicConfigService;
import com.ron.rao.common.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@Controller("basicConfigController")
@RequestMapping("basic")
public class BasicConfigController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(BasicConfigController.class);



    @Autowired
    private BasicConfigService basicConfigService;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            BasicConfig basicConfig = basicConfigService.getBasicConfig();
            resultMap.put("data", JSONObject.toJSONString(basicConfig));
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(BasicConfig config) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            basicConfigService.updateBaseCofig(config);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

}
