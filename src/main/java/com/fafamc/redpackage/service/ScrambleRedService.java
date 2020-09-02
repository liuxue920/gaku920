package com.fafamc.redpackage.service;

import com.fafamc.redpackage.vo.GetVo;
import com.fafamc.redpackage.vo.OpenResult;

/**
 * 抢红包接口
 */
public interface ScrambleRedService {
    boolean getRed(GetVo vo);
    OpenResult openRed(GetVo vo);
}
