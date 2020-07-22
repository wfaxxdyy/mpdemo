package cn.wf.mpdemo;

import cn.wf.mpdemo.entity.User;
import cn.wf.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Slf4j
class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,readOnly = true,timeout = 100)
    public void testInsert() {
        System.out.println(("----- testInsert method test ------"));
        User user = new User();
        user.setAge(11);
        user.setEmail("wf4@163.com");
        user.setName("wf4");
        int i = userMapper.insert(user);
        log.info(user.getId()+"");
    }
    @Test
    public void testUpdate() {
        System.out.println(("----- testUpdate method test ------"));
        User user = new User();
        user.setAge(12);
        userMapper.update(user,new UpdateWrapper<User>().eq("name","wf3"));
        log.info(user.getAge()+"");
    }
    @Test
    public void testDelete() {
        System.out.println(("----- testDelete method test ------"));
        userMapper.delete(new UpdateWrapper<User>().and(x -> x.eq("name","wf").eq("id",7)));
    }

    @Test
    public void testPageSelect() {
        System.out.println(("----- testPageSelect method test ------"));
        IPage<User> userPage = userMapper.selectPage(new Page<User>(1, 5), null);
        List<User> userList = userPage.getRecords();
        userList.forEach(System.out::println);
    }

}
