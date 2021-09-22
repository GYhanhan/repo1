package com.star.dao;

import com.star.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 友链持久层接口

 */
@Mapper
@Repository
public interface FriendLinkDao {

    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    FriendLink getFriendLinkByBlogaddress(String blogaddress);//getFriendLinkByBlogaddress：在新增友链的时候做重复判断，查询到有相同友链给出提示

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);

}