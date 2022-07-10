package com.ww;

import com.ww.mapper.UserMapper;
import com.ww.pojo.User;
import com.ww.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisplusDemo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void testSelectList() {
        // 通过条件构造器查询一个List集合，若没有条件，则可以设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }
//    @Test
//    void testInsert(){
//        User user = new User(null, "张三", 18, "123@qq.com",0);
//        int result = userMapper.insert(user);
//        System.out.println("受影响行数："+result);
//        System.out.println("自动获取id信息："+user.getId());
//    }

    @Test
    public void testDeleteById(){
        int rows = userMapper.deleteById(1L);
        System.out.println("rows："+ rows);
    }

    @Test
    public void testDeleteBatchIds(){
        List<Long> idList = Arrays.asList(4L, 5L);
        int rows = userMapper.deleteBatchIds(idList);
        System.out.println("rows：" + rows);
    }

    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        int rows = userMapper.deleteByMap(map);
        System.out.println("rows：" + rows);
    }

//    @Test
//    public void testUpdateById(){
//        User user = new User(1L, "admin", 20, "123456@qq.com",0);
//        int rows = userMapper.updateById(user);
//        System.out.println("rows：" + rows);
//    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
        List<Long> idList = Arrays.asList(1L, 2L, 3L);
        List<User> list = userMapper.selectBatchIds(idList);

    }

    @Test
    public void testSelectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("age", 20);
        List<User> list = userMapper.selectByMap(map);

    }

    @Test
    public void testSelectList1(){
        List<User> list = userMapper.selectList(null);
        list.forEach(user -> System.out.println(user));
    }


    @Test
    public void selectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("count：" + count);
    }

    @Test
    public void testSaveBatch(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        userService.saveBatch(users);
    }

}
