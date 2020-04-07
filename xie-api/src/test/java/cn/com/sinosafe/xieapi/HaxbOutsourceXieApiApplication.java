package cn.com.sinosafe.xieapi;

import cn.com.sinosafe.xie.cost.service.CostService;
import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HaxbOutsourceXieApiApplication {
    private Singleton singleton = new Singleton();

    @Autowired
    private CostService costService;
  /* @InjectMocks
   private UserBaseInfoService userBaseInfoService  = new UserBaseInfoServiceImpl();
   @Mock
   private UserBaseInfoMapper userBaseInfoMapper;

    @Before
    public void setUpHotAppData() {
        //准备桩数据，queryHotAppTime mock normal data
        List<UserBaseInfo> userBaseInfoList = new ArrayList<>();
        UserBaseInfo userBaseInfo1 = new UserBaseInfo();
//        省略一堆set方法调用。。。
        UserBaseInfo userBaseInfo2 = new UserBaseInfo();
//        省略一堆set方法调用。。。
        userBaseInfoList.add(userBaseInfo1);
        userBaseInfoList.add(userBaseInfo2);
        when(userBaseInfoMapper.selectUserBase(5)).thenReturn(userBaseInfoList);

        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setInviterType(10000);
        //写桩方法
        when(userBaseInfoMapper.selectUserBase(1)).thenReturn(userBaseInfoList);

        //queryHotAppTime mock null data
        when(userBaseInfoMapper.selectUserBase(4)).thenReturn(null);
    }

    @Test
    public void contextLoads() {
       int[] nums = {1,2,3,4,5,6,7,8,9};
        for (int num : nums) {
            System.out.println(num);
        }
    }*/


    @Test
    public void contextLoads() {
        UserBaseInfo userBaseInfo = Singleton.getInstance().getUserBaseInfo();
        System.out.println(userBaseInfo.getApplyId());
    }

//    @Test
//    public String returnUrl() throws Exception{
//        System.out.println("方法returnUrl");
//        return costService.returnUrl();
//    }
}
