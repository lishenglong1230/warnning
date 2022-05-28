package com.example.chat.controller;

import com.example.chat.entity.FriendRelation;
import com.example.chat.service.FriendRelationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (FriendRelation)表控制层
 *
 * @author makejava
 * @since 2022-03-07 12:38:55
 */
@RestController
@RequestMapping("friendRelation")
public class FriendRelationController {
    /**
     * 服务对象
     */
    @Resource
    private FriendRelationService friendRelationService;

    /**
     * 分页查询
     *
     * @param friendRelation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<FriendRelation>> queryByPage(FriendRelation friendRelation, PageRequest pageRequest) {
        return ResponseEntity.ok(this.friendRelationService.queryByPage(friendRelation, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<FriendRelation> queryById(@PathVariable("id")  id) {
        return ResponseEntity.ok(this.friendRelationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param friendRelation 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<FriendRelation> add(FriendRelation friendRelation) {
        return ResponseEntity.ok(this.friendRelationService.insert(friendRelation));
    }

    /**
     * 编辑数据
     *
     * @param friendRelation 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<FriendRelation> edit(FriendRelation friendRelation) {
        return ResponseEntity.ok(this.friendRelationService.update(friendRelation));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById( id) {
        return ResponseEntity.ok(this.friendRelationService.deleteById(id));
    }

}

