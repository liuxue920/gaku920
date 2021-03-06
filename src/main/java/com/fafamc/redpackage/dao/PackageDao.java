package com.fafamc.redpackage.dao;

import com.fafamc.gaku.repository.BaseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PackageDao<T> extends BaseRepository<Package> {
}
