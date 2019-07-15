package cn.amphobia.community.mapper;

import cn.amphobia.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author amphobia
 * @data 2019/7/15 0015-20:02
 */
/*
        private int id;
        private String accoundId;
        private String name;
        private String token;
        private Long gmtCreate;
        private Long gmtModified;
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user (account_id,name,token,gmt_create,gmt_modified)" +
            "VALUES (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
