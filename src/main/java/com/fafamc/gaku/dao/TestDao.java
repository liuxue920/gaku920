package com.fafamc.gaku.dao;


import com.fafamc.gaku.domain.TTest;
import com.fafamc.gaku.repository.BaseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author gaku9
 * @Create 2020/7/11
 **/
@Mapper
@Repository
public interface TestDao extends BaseRepository<TTest> {
}
