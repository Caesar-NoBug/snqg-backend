import com.snqg.ChildrenApplication;
import com.snqg.chat.mapper.MessageMapper;
import com.snqg.children.constant.RedisPrefix;
import com.snqg.children.controller.ChildrenController;
import com.snqg.children.mapper.UserMapper;
import com.snqg.common.util.JwtUtil;
import com.snqg.common.util.RedisCache;
import com.snqg.common.util.StrEncoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = ChildrenApplication.class)
public class TestChildren {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ChildrenController controller;

    @Resource
    private MessageMapper messageMapper;

    /*@Test
    public void testWxLogin() {
        String code = StrUtil.randNumCode(6);
        addTestData(code);
        LoginRequest request = new LoginRequest();
        request.setCode("0d34VXZv38C7E13v734w3iGylI04VXZL");
        request.setInviteCode(code);
        System.out.println(controller.login(request));
    }

    private void addTestData(String code) {
        User user = new User();
        user.setId("sdfsdf");
        user.setUsername("测试儿童");
        user.setRole(1);
        user.setGender(1);
        user.setAvatar("fsdfsdfsd");
        user.setAddress("fsdfsdfsd");
        user.setBirth(LocalDateTime.now());
        user.setPoint(999);
        user.setUpdateBy(LocalDateTime.now());

        userMapper.addBindInfo(code, user);
    }*/

    @Resource
    private RedisCache redisCache;

    /*@Test
    public void testToken() throws Exception {
        //String string = redisCache.getCacheObject(RedisPrefix.USER_SESSION_TOKEN + "o2HEN5a1-62AL1SDc18g4lW7PQUg").toString();
       // System.out.println(StrEncoder.check("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0N2E3YzQ0MWVmYjg0OGFjOTI4MTFlNTAwNDkyYTE5MSIsInN1YiI6Im8ySEVONWExLTYyQUwxU0RjMThnNGxXN1BRVWciLCJpc3MiOiJzZyIsImlhdCI6MTY5OTAxMTEyMCwiZXhwIjoxNjk5MDE0NzIwfQ.3yAo8ID_R6iLYEI2FoWU3VbJ0YQjXXcTq6FxAzxNQRE", string));
        String token = JwtUtil.createJWT("o2HEN5a1-62AL1SDc18g4lW7PQUg");
        System.out.println(JwtUtil.parseJWT(token).getSubject());

    }*/

    /*@Test
    public void testDB() {
        System.out.println(userMapper.selectUserById("o2HEN5a1-62AL1SDc18g4lW7PQUg"));

    }

    @Test
    public void insertTestData() {
        String token = JwtUtil.createJWT("666");

        redisCache.setCacheObject(RedisPrefix.USER_SESSION_TOKEN + "666", StrEncoder.encode(token));

        System.out.println(token);

        token = JwtUtil.createJWT("777");

        redisCache.setCacheObject(RedisPrefix.USER_SESSION_TOKEN + "777", StrEncoder.encode(token));

        System.out.println(token);
    }*/

    /*@Test
    public void testDB2() {
        System.out.println(messageMapper.selectFriendList("666"));
    }*/

}
