package com.example.chat.dao;

import com.example.chat.entity.FriendRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (FriendRelation)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-07 12:38:56
 */
public interface FriendRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    FriendRelation queryById( );

    /**
     * 查询指定行数据
     *
     * @param friendRelation 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<FriendRelation> queryAllByLimit(FriendRelation friendRelation, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param friendRelation 查询条件
     * @return 总行数
     */
    long count(FriendRelation friendRelation);

    /**
     * 新增数据
     *
     * @param friendRelation 实例对象
     * @return 影响行数
     */
    int insert(FriendRelation friendRelation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<FriendRelation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<FriendRelation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<FriendRelation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<FriendRelation> entities);

    /**
     * 修改数据
     *
     * @param friendRelation 实例对象
     * @return 影响行数
     */
    int update(FriendRelation friendRelation);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}

