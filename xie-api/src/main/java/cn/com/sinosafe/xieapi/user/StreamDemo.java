package cn.com.sinosafe.xieapi.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by xiehanchun on 2020/7/24
 */
public class StreamDemo {


    public static void main(String[] args) {
        // 集合1
        List<SkillUpgrade> lists = new ArrayList<>();
        SkillUpgrade s = new SkillUpgrade();
        s.setLv(1);
        s.setAppearNum(100);
        lists.add(s);
        SkillUpgrade s2 = new SkillUpgrade();
        s2.setLv(2);
        s2.setAppearNum(200);
        lists.add(s2);
        // 集合2
        List<SkillUpgrade> listx = new ArrayList<>();
        SkillUpgrade x = new SkillUpgrade();
        x.setLv(1);
        x.setSelectNum(1100);
        listx.add(x);
        SkillUpgrade x2 = new SkillUpgrade();
        x2.setLv(2);
        x2.setSelectNum(1200);
        listx.add(x2);
        // 把list转map,{k=lv,vaule=并为自身}  . SkillUpgrade->SkillUpgrade或Function.identity()
        Map<Integer, SkillUpgrade> map = listx.stream()
                .collect(Collectors.toMap(SkillUpgrade::getLv, e -> e));
        System.out.println("map:="+map);
        // 合并
        lists.forEach(n -> {
            // 如果等级一致
            if (map.containsKey(n.getLv())) {
                SkillUpgrade obj = map.get(n.getLv());
                // 把数量复制过去
                n.setAppearNum(obj.getSelectNum());
            }
        });
        System.out.println("lists:="+lists);
        // 重复问题
        Map<Integer, SkillUpgrade> keyRedo = listx.stream()
                .collect(Collectors.toMap(SkillUpgrade::getLv, Function.identity(), (key1, key2) -> key2));
        // 方式二：指定实例的map
        Map<Integer, SkillUpgrade> linkedHashMap = listx.stream().collect(Collectors.toMap(SkillUpgrade::getLv,
                SkillUpgrade -> SkillUpgrade, (key1, key2) -> key2, LinkedHashMap::new));
    }
}
