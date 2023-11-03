import com.snqg.ChildrenApplication;
import com.snqg.children.controller.ChildrenController;
import com.snqg.children.entity.User;
import com.snqg.children.mapper.UserMapper;
import com.snqg.common.util.StrUtil;
import com.snqg.domain.request.children.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest(classes = ChildrenApplication.class)
public class TestChildren {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ChildrenController controller;

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
}
