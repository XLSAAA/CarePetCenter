package cn.moquan.dao;

import cn.moquan.bean.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    // 查询

    // 查询所有的 User
    List<User> getAllUser();

    User getUserById(int id);

    User login(String username);

    // 添加

    int insertUser(User user);

    // 删除

    int deleteUserById(int id);

    // 更改

    int updateUserById(User user);

    int updateUserErrorCountById(@Param("userId") int userId, @Param("count") int count);

    int updateUserStatusById(int userId, int status);

    int updateUserUnfreezeById(@Param("userId") int userId, @Param("status") int status);

    int updateUserFreezeById(@Param("userId") int userId, @Param("status") int status);

    int updateDefaultPasswordById(@Param("id") int id, @Param("defaultPassword") String defaultPassword);
}
