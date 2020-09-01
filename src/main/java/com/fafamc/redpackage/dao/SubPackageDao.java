package com.fafamc.redpackage.dao;

import com.fafamc.gaku.repository.BaseRepository;
import com.fafamc.redpackage.domain.Subpackage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SubPackageDao<T> extends BaseRepository<Subpackage> {
}
