package com.breach.huajinbao.controller.verify;

import com.breach.common.entity.ConsumerActivateVerifyRecord;
import com.breach.common.entity.RegionCity;
import com.breach.common.entity.RegionProvince;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: Financial
 * @description: 认证
 * @author: shaokang
 * @create: 2019-01-10 19:26
 **/
@RestController
@RequestMapping("/verify")
public class VerifyController {

    @Autowired
    IVerifyService verifyService;

    /** 省市区联动 获取所有地区 未启用 **/
    @RequestMapping("/listAllRegions")
    public ReturnUtil listAllRegions() {
        return verifyService.listAllRegions();
    }

    /** 省市区联动 获取所有省份 **/
    @RequestMapping("/listAllProvince")
    public ReturnUtil listAllProvince() {
        return verifyService.listAllProvince();
    }

    /** 省市区联动 获取城市 **/
    @RequestMapping("/getListAllCity")
    public ReturnUtil getListAllCity(@RequestBody RegionProvince regionProvince) {
        return verifyService.getListAllCity(regionProvince);
    }

    /** 省市区联动 获取地区 **/
    @RequestMapping("/getListAllArea")
    public ReturnUtil getListAllArea(@RequestBody RegionCity regionCity) {
        return verifyService.getListAllArea(regionCity);
    }

    /** 获取所有可选学历 **/
    @RequestMapping("/listAllEducation")
    public ReturnUtil listAllEducation() {
        return verifyService.listAllEducation();
    }

    /** 获取所有可选收入范围 **/
    @RequestMapping("/listAllIncome")
    public ReturnUtil listAllIncome() {
        return verifyService.listAllIncome();
    }

    /** 身份证二要素验证 **/
    @RequestMapping("/idCard")
    public ReturnUtil idCard(@RequestBody ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {
        return verifyService.idCard(consumerActivateVerifyRecord);
    }

    /** 银行卡验证 **/

    /** 上传身份证正面照片 **/
    @RequestMapping("/uploadFront")
    public ReturnUtil uploadFront(@RequestBody MultipartFile file, String type) throws Exception {
        return verifyService.uploadFront(file, type);
    }

    /** 上传身份证背面照片 **/
    @RequestMapping("/uploadBack")
    public ReturnUtil uploadBack(@RequestBody MultipartFile file, String type) throws Exception {
        return verifyService.uploadBack(file, type);
    }

    /** 最后确认提交 **/
    @RequestMapping("/finalSubmit")
    public ReturnUtil finalSubmit(@RequestBody ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {
        return verifyService.finalSubmit(consumerActivateVerifyRecord);
    }

    /** 查询用户的认证/审额状态 **/
    @RequestMapping("/verifyState")
    public ReturnUtil verifyState() {
        return verifyService.verifyState();
    }

    @RequestMapping("/verifyIdCardExist")
    public ReturnUtil verifyIdCardExist(@RequestBody ConsumerActivateVerifyRecord consumerActivateVerifyRecord) {
        return verifyService.verifyIdCardExist(consumerActivateVerifyRecord);
    }
    


}
