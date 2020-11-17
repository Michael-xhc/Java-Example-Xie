package com.alibaba.nacos.example.spring.cloud.test;

/**
 * Created by xiehanchun on 2020/11/17
 */
public class TestController {

//    private final RedissonClient redissonClient;

    public static void main(String[] args) {
        //CJ前缀+6位日期,例：CJ201015
//        String date = "CJ" + DateUtil.today().replace("-", "").substring(2);
        //从redis取出今天的递增数字
//        RAtomicLong rAtomicLong = redissonClient.getAtomicLong("ListingOrder:ListingOrderCode:"+date);
//        long num = rAtomicLong.get();
//        //如果递增数为空0，从数据库查今天最大的成交编号的递增数,数据库再也没有，则回返回一个缺省值
//        if(num == 0){
//            num = getMaxListingOrderCode(date);
//        }
//        //判断取出来的递增数跟redis当前的是否一致,不一致则从redis取出最新的再比对，一致则+1后保存回redis
//        while (!rAtomicLong.compareAndSet(num,num += 1)){
//            num = rAtomicLong.get();
//        }
//        System.out.println( date + String.format("%05d", num));
    }
}
