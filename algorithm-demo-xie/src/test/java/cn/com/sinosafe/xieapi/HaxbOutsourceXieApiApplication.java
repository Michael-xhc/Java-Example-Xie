package cn.com.sinosafe.xieapi;

//import cn.com.sinosafe.xie.cost.service.CostService;
//import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
//import cn.com.sinosafe.xie.user.service.MyBinarySearchTree;
//import cn.com.sinosafe.xie.user.service.UserBaseInfoService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HaxbOutsourceXieApiApplication {
    private Singleton singleton = new Singleton();

//    @Autowired
//    private CostService costService;
//      @Autowired
//      private UserBaseInfoService userBaseInfoService;
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


//    @Test
//    public void contextLoads() {
//        UserBaseInfo userBaseInfo = Singleton.getInstance().getUserBaseInfo();
//        System.out.println(userBaseInfo.getApplyId());
//    }

//    @Test
//    public String returnUrl() throws Exception{
//        System.out.println("方法returnUrl");
//        return costService.returnUrl();
//    }

//    @Test
//    public void convertBST() throws Exception{
//        MyBinarySearchTree my =new MyBinarySearchTree();
//        my.addNode(9);
//        my.addNode(5);
//        my.addNode(15);
//        my.addNode(3);
//        my.addNode(7);
//        my.addNode(11);
//        my.addNode(17);
//        my.addNode(6);
//        my.addNode(4);
//        my.addNode(1);
//        my.addNode(10);
//        my.addNode(8);
//        my.addNode(12);
//        my.addNode(16);
//        my.addNode(7);
//        userBaseInfoService.convertBST(my.root);
//    }
}
