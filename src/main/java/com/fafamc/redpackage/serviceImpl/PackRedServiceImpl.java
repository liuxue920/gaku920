package com.fafamc.redpackage.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.redpackage.dao.PackageExDao;
import com.fafamc.redpackage.dao.SubPackageExDao;
import com.fafamc.redpackage.domain.Package;
import com.fafamc.redpackage.domain.Subpackage;
import com.fafamc.redpackage.service.PackRedService;
import com.fafamc.redpackage.utils.CalculationUtil;
import com.fafamc.redpackage.vo.SendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PackRedServiceImpl implements PackRedService {

    @Autowired
    private PackageExDao packageExDao;
    @Autowired
    private SubPackageExDao subPackageExDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Package packRed(SendVo vo){
        if(vo.getModel() == 0){
            return averagePackRed(vo.getPNum(),vo.getEachMoney(),vo.getMessage());
        }
        if(vo.getModel() == 1){
            return scramblePackRed(vo.getPNum(),vo.getTotalMoney(),vo.getMessage());
        }
        throw new RuntimeException("xxx exception");
    }

    @Override
    public Package averagePackRed(int pNum, int eachMoney, String message) {
        Package pack = new Package();
        pack.setMessage(message);
        pack.setSendDateTime(new Date());
        pack.setModel(0);
        pack.setPNum(pNum);
        pack.setTotal(eachMoney*pNum);
        packageExDao.insertCord(pack);

        //在redis中存储子红包信息,失效时间是1天
        redisUtil.set("package_"+pack.getId(),JSON.toJSONString(pack),24*60*60);

        for(int i = 0 ; i < pNum ; i++){
            Subpackage subPage = new Subpackage();
            subPage.setMoney(eachMoney);
            subPage.setPackageId(pack.getId());
            subPackageExDao.insertCord(subPage);
            subPage.setId(subPage.getId());

            redisUtil.lSet("package_subs_"+pack.getId(),subPage,24*60*60);
        }


        return pack;
    }

    @Override
    public Package scramblePackRed(int pNum, int totalMoney, String message) {
        Package pack = new Package();
        pack.setMessage(message);
        pack.setSendDateTime(new Date());
        pack.setModel(1);
        pack.setPNum(pNum);
        pack.setTotal(totalMoney);
        packageExDao.insertCord(pack);
        //在redis中存储子红包信息
        redisUtil.set("package_"+pack.getId(), JSON.toJSONString(pack),24*60*60);

        List<Integer> moneys =  CalculationUtil.groupMoney(totalMoney,pNum);
        for(int i = 0 ; i < pNum ; i++){
            Subpackage subPage = new Subpackage();
            subPage.setMoney(moneys.get(i));
            subPage.setPackageId(pack.getId());
            subPackageExDao.insertCord(subPage);
            subPage.setId(subPage.getId());

            redisUtil.lSet("package_subs_"+pack.getId(),subPage,24*60*60);
        }
        return pack;
    }
}
