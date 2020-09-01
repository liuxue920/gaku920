package com.fafamc.redpackage.dao;

import com.fafamc.redpackage.domain.Subpackage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SubPackageExDao extends  SubPackageDao<Subpackage>{
    Long insertCord(Subpackage record);
}
