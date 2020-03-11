package com.ron.rao.business.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ron.rao.business.model.Stone;
import com.ron.rao.business.service.StoneService;
import com.ron.rao.common.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller("stoneController")
@RequestMapping("stone")
public class StoneController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(StoneController.class);



    @Autowired
    private StoneService stoneService;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            List<Stone> stoneList = stoneService.getAllStoneList();
            resultMap.put("data", JSONArray.toJSONString(stoneList));
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/detail")
    public String detail(Stone stone) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            Stone st = stoneService.getStoneById(stone.getId());
            resultMap.put("data", JSONArray.toJSONString(st));
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(Stone stone) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            stoneService.saveStone(stone);
        }catch (Exception e){
            code = "0";
            msg = "error";
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }
    @ResponseBody
    @RequestMapping("/check")
    public String checkCipherText(Stone stone) {
        String code = "1";
        String msg = "恭喜你，成功找到了一块神石碎片，马上成功了，继续加油哦！";
        Map<String,String> resultMap = new HashMap<>();
        try {
            Stone st = stoneService.getStoneByCipherText(stone.getCipherText());
            if(st != null){
                if("1".equals(st.getIsDecode())){
                    code = "0";
                    msg = "该密文已经使用过了哦，继续耐心寻找吧！";

                }else {
                    st.setIsDecode("1");
                    stoneService.saveStone(st);
                    resultMap.put("data", JSONArray.toJSONString(st));
                }
            }else{
                code = "0";
                msg = "密文不正确哦，继续耐心寻找吧！";
            }
        }catch (Exception e){
            code = "0";
            msg = "error";
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

}
