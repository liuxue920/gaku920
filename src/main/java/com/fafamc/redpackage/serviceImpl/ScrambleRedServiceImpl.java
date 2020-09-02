package com.fafamc.redpackage.serviceImpl;

import com.fafamc.gaku.redis.RedisUtil;
import com.fafamc.redpackage.dao.SubPackageExDao;
import com.fafamc.redpackage.domain.Subpackage;
import com.fafamc.redpackage.service.ScrambleRedService;
import com.fafamc.redpackage.vo.GetVo;
import com.fafamc.redpackage.vo.OpenResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
public class ScrambleRedServiceImpl implements ScrambleRedService {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private SubPackageExDao subPackageExDao;

    /**
     * 思路逻辑
     * 1、根据大红包id获取redis信息，如果redis信息已经不存在说明已经抢完了
     * 2. 如果能获取到，则返回可以打开红包
     * @param vo
     * @return
     */
    @Override
    public boolean getRed(GetVo vo) {
        if(redisUtil.hasKey("package_" + vo.getPackageId())){
            return true;
        }
        return false;
    }

    /**
     * 逻辑思路
     * 1.做子包的del操作，如果返回值为空，说明已经删除完了
     * 2.如果返回了值，说明抢到了，
     * 3.判断长度，看是否还有，如果没有了，del大包的redis信息
     * 4.更新数据库
     * @param vo
     * @return
     */
    @Override
    public OpenResult openRed(GetVo vo) {
        Object obj = redisUtil.lPop("package_subs_" + vo.getPackageId());
        if(obj == null){
            return OpenResult.failed();
        }

        OpenResult result = new OpenResult();
        Subpackage subpackage = (Subpackage)obj;
        subpackage.setUserName(vo.getUserName());
        subPackageExDao.updateByPrimaryKeySelective(subpackage);
        result.setFlag(true);
        result.setSubpackage(subpackage);

        Object o = redisUtil.get("package_" + vo.getPackageId());
        result.setAPackage((Package) o);
        Long length = redisUtil.lGetListSize("package_subs" + vo.getPackageId());
        if(length == 0){
            redisUtil.del("package_" + vo.getPackageId());
        }
        return result;
    }
}
