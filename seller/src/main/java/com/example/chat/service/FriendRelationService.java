package com.example.chat.service;

import com.example.chat.entity.FriendRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (FriendRelation)表服务接口
 *
 * @author makejava
 * @since 2022-03-07 12:39:05
 */
public interface FriendRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    FriendRelation queryById( );

    /**
     * 分页查询
     *
     * @param friendRelation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<FriendRelation> queryByPage(FriendRelation friendRelation, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param friendRelation 实例对象
     * @return 实例对象
     */
    FriendRelation insert(FriendRelation friendRelation);

    /**
     * 修改数据
     *
     * @param friendRelation 实例对象
     * @return 实例对象
     */
    FriendRelation update(FriendRelation friendRelation);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}
