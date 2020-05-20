/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.cost
 * fileName: ValidParentheses.java
 * date: 2020-05-20 9:37
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.cost;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.HashMap;
import java.util.Stack;

/**
 * @description: 有效的括号
 * @packageName: cn.com.sinosafe.xieapi.cost
 * @className: ValidParentheses
 * @author: xiehanchun
 * @data: 2020-05-20 9:37
 * @version: v1.0
 */
public class ValidParentheses {

    HashMap<Character, Character> map;
    public ValidParentheses(){
        this.map = new HashMap<Character, Character>();
        this.map.put(')','(');
        this.map.put(']','[');
        this.map.put('}','{');
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(this.map.containsKey(c)){
                char topElement = stack.empty() ? '#' : stack.pop();
                if(topElement!=this.map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
                System.out.println("调加一个元素！");
            }
        }
        return stack.empty();
    }

}
