package com.ron.rao.business.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ron.rao.business.model.BasicConfig;
import com.ron.rao.business.model.Lotto;
import com.ron.rao.business.service.BasicConfigService;
import com.ron.rao.business.service.LottoService;
import com.ron.rao.business.vo.ReqLottoVo;
import com.ron.rao.common.BaseController;
import com.ron.rao.common.CyFont;
import com.ron.rao.common.FontUtil;
import com.ron.rao.common.ImageUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin
@Controller("lottoController")
@RequestMapping("lotto")
public class LottoController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(LottoController.class);

    private static  Font font = null;

    @Value("${font.folder}")
    private String fontFolder;
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    @Autowired
    private LottoService lottoService;

    @Autowired
    private BasicConfigService basicConfigService;

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            List<Lotto> lottoList = lottoService.getAllLottoList();
            resultMap.put("data", JSONArray.toJSONString(lottoList));
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/detail")
    public String detail(Lotto lotto) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            if(lotto.getId() != null){
                Lotto st = lottoService.getLottoById(lotto.getId());
                resultMap.put("data", JSONArray.toJSONString(st));
            }else {
                code = "0";
                msg = "未获取到信息";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/save")
    public String save(ReqLottoVo lotto) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            if(StringUtils.isNotBlank(lotto.getLottoPrize())){
//                ApplicationHome h = new ApplicationHome(getClass());
//                String dirPath = h.getSource().getParentFile().toString();
//                System.out.println("图片存储地址---"+dirPath);
                //
                if(font == null){
                    CyFont cf=new CyFont();
                    font = cf.getDefinedFont(fontFolder+"font.ttf", 80);
                }
                String filePath = uploadFolder+lotto.getLottoPrize()+".png";

                logger.info("图片保存路径：{}",filePath);

                File file = new File(filePath);
                ImageUtil.createImage(lotto.getLottoPrize(),font,file,480,150);

                lotto.setImgUrl(filePath);
            }

            lottoService.saveLotto(lotto);

            if(lotto.getBasicId() != null){
                BasicConfig b = basicConfigService.getBasicConfig();
                b.setLottoNum(b.getLottoNum()-1);
                basicConfigService.updateBaseCofig(b);
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

    @ResponseBody
    @RequestMapping("/item")
    public String item(Lotto lotto) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {
            List<Lotto> list = lottoService.getAllLottoNoPrizeList();
            if(list.size() > 0){
                int index = new Random().nextInt(list.size());
                Lotto lotto1 = list.get(index);
                resultMap.put("data", JSONArray.toJSONString(lotto1));
            }else{
//                code = "0";
//                msg = "没有更多信息了";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }
    @ResponseBody
    @RequestMapping("/info")
    public String info(Lotto lotto) {
        String code = "1";
        String msg = "SUCCESS";
        Map<String,String> resultMap = new HashMap<>();
        try {

            List<Lotto> prizeList= lottoService.getAllLottoPrizeList();
            resultMap.put("prizeList", JSONArray.toJSONString(prizeList));
            BasicConfig basicConfig = basicConfigService.getBasicConfig();
            resultMap.put("config", JSONArray.toJSONString(basicConfig));
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code",code);
        resultMap.put("msg",msg);


        return JSONObject.toJSONString(resultMap);
    }
}
