/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xiecommon.utils
 * fileName: StreamTest.java
 * date: 2020-04-14 14:18
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xiecommon.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: stream流
 * @packageName: cn.com.sinosafe.xiecommon.utils
 * @className: StreamTest
 * @author: xiehanchun
 * @data: 2020-04-14 14:18
 * @version: v1.0
 */
public class StreamTest {

//    public static void main(String[] args) {
//        List<DataBean> totalStocks = new ArrayList<>();
//
//		DataBean stock1 = new DataBean();
//		stock1.setDeptId(2);
//		stock1.setType(2);
//		stock1.setNum(2);
//		totalStocks.add(stock1);
//
//		DataBean stock2 = new DataBean();
//		stock2.setDeptId(2);
//		stock2.setType(2);
//		stock2.setNum(3);
//		totalStocks.add(stock2);
//
//		DataBean stock3 = new DataBean();
//		stock3.setDeptId(3);
//		stock3.setType(3);
//		stock3.setNum(5);
//		totalStocks.add(stock3);
//
//		DataBean stock4 = new DataBean();
//		stock4.setDeptId(3);
//		stock4.setType(3);
//		stock4.setNum(4);
//		totalStocks.add(stock4);
//
//		DataBean stock5 = new DataBean();
//		stock5.setDeptId(4);
//		stock5.setType(4);
//		stock5.setNum(10);
//		totalStocks.add(stock5);
//
//		List<DataBean> result = totalStocks.stream()
//			//group
//			.collect(Collectors.groupingBy(ed -> ed.getDeptId() + ":" + ed.getType()))
//			// 分组后的list做reduce
//			.values().stream().map(list -> list.stream().reduce(StreamTest::combine).get())
//			// 收集到list
//			.collect(Collectors.toList());
//
//		System.out.println(result);
//        //Calendar.HOUR_OF_DAY
//        System.out.println(""+ Calendar.getInstance().get(Calendar.MINUTE));
//
//    }
//    private static DataBean combine(DataBean e1, DataBean e2){
//        DataBean e = new DataBean();
//
//        e.setDeptId(e1.getDeptId());
//        e.setType(e1.getType());
//        e.setNum(e1.getNum() + e2.getNum());
//
//        return e;
//    }
//}

    public static void main(String[] args) {
        List<DataBean> totalStocks = new ArrayList<>();
        DataBean stock1 = new DataBean();
        stock1.setDeptId(2);
        stock1.setType(2);
        stock1.setNum(2);
        totalStocks.add(stock1);

        DataBean stock2 = new DataBean();
		stock2.setDeptId(2);
		stock2.setType(2);
		stock2.setNum(3);
		totalStocks.add(stock2);

		DataBean stock3 = new DataBean();
		stock3.setDeptId(3);
		stock3.setType(3);
		stock3.setNum(5);
		totalStocks.add(stock3);

		DataBean stock4 = new DataBean();
		stock4.setDeptId(3);
		stock4.setType(3);
		stock4.setNum(4);
		totalStocks.add(stock4);

        DataBean stock5 = new DataBean();
        stock5.setDeptId(3);
        stock5.setType(3);
        stock5.setNum(4);
        totalStocks.add(stock5);

        DataBean stock6 = new DataBean();
        stock6.setDeptId(3);
        stock6.setType(3);
        stock6.setNum(4);
        totalStocks.add(stock6);
//
//        Optional<DataBean> dataBean = totalStocks.stream().findAny();
//        System.out.println(dataBean);

        boolean result = totalStocks.stream().anyMatch(dataBean -> dataBean.getIss(dataBean));
        System.out.println(result);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        List<DataBean> beans = totalStocks.stream().distinct().collect(Collectors.toList());
//        for (DataBean bean : beans) {
//            System.out.println(bean);
//        }

//        List<String> list = new ArrayList<String>();
//        list.add("I am a boy");
//        list.add("I love the girl");
//        list.add("But the girl loves another girl");
//        List<String> collect = list.stream()
//                .map(line -> line.split(" "))
//                .flatMap(Arrays::stream)
//                .collect(Collectors.toList());
//        for (String s : collect) {
//            System.out.println(s);
//        }
    }
}

@Data
class DataBean {
    private int type;
    private int deptId;
    private int num;
    private boolean iss;

    public boolean getIss(DataBean dataBean) {
        if(dataBean.getDeptId() == 7){
            return true;
        }
        return false;
    }
}
