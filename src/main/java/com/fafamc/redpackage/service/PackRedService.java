package com.fafamc.redpackage.service;

import com.fafamc.redpackage.domain.Package;
import com.fafamc.redpackage.vo.SendVo;

/**
 * 装红包接口
 */
public interface PackRedService {

    Package packRed(SendVo vo);

    /**
     *  人均模式装红包
     *  1.总人数
     *  2.每个人多少钱
     *  @param pNum
     *   @param eachMoney
     */
    Package averagePackRed(int pNum,int eachMoney,String message);

    /**
     * 抢红包模式装红包
     * @param pNum
     * @param totalMoney
     */
    Package scramblePackRed(int pNum,int totalMoney,String message);
}
