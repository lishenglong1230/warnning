package com.example.chat.service.impl;

import com.example.chat.entity.FriendRelation;
import com.example.chat.dao.FriendRelationDao;
import com.example.chat.service.FriendRelationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (FriendRelation)表服务实现类
 *
 * @author makejava
 * @since 2022-03-07 12:39:07
 */
@Service("friendRelationService")
public class FriendRelationServiceImpl implements FriendRelationService {
    @Resource
    private FriendRelationDao friendRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    @Override
    public FriendRelation queryById( ) {
        return this.friendRelationDao.queryById();
    }

    /**
     * 分页查询
     *
     * @param friendRelation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<FriendRelation> queryByPage(FriendRelation friendRelation, PageRequest pageRequest) {
        long total = this.friendRelationDao.count(friendRelation);
        return new PageImpl<>(this.friendRelationDao.queryAllByLimit(friendRelation, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param friendRelation 实例对象
     * @return 实例对象
     */
    @Override
    public FriendRelation insert(FriendRelation friendRelation) {
        this.friendRelationDao.insert(friendRelation);
        return friendRelation;
    }

    /**
     * 修改数据
     *
     * @param friendRelation 实例对象
     * @return 实例对象
     */
    @Override
    public FriendRelation update(FriendRelation friendRelation) {
        this.friendRelationDao.update(friendRelation);
        return this.queryById(friendRelation.get());
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.friendRelationDao.deleteById() > 0;
    }
}
