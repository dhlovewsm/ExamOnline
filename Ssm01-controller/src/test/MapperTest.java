import com.examonline.controller.aop.ArchivesLog;
import com.examonline.entity.*;
import com.examonline.service.ApplicantService;
import com.examonline.service.ExamService;
import com.examonline.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/*.xml")
@Transactional
public class MapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void userTest(){
        User user = userService.getOne("aaa");
        System.out.println(user.getUserName());
    }



}
