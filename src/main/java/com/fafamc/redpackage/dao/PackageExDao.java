package com.fafamc.redpackage.dao;

import com.fafamc.redpackage.domain.Package;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PackageExDao extends PackageDao<Package>{

    Long insertCord(Package record);
}
