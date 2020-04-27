/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.designpatterns
 * fileName: BuilderPattern.java
 * date: 2020-04-27 14:11
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.designpatterns;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * @description: 构建者模式
 * @packageName: cn.com.sinosafe.xieapi.designpatterns
 * @className: BuilderPattern
 * @author: xiehanchun
 * @data: 2020-04-27 14:11
 * @version: v1.0
 */
@Data
public class BuilderPattern {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;


    public BuilderPattern(Builder builder){
          this.name = builder.getName();
          this.maxIdle = builder.getMaxIdle();
          this.maxTotal = builder.getMaxTotal();
          this.minIdle = builder.getMinIdle();
    }

    public static class Builder {
        private static final int MAX_TOAL = 8;
        private static final int MAX_IDLE = 8;
        private static final int MIN_IDLE = 0;

        private String name;
        private int maxTotal = MAX_TOAL;
        private int maxIdle = MAX_IDLE;
        private int minIdle = MIN_IDLE;

        public BuilderPattern build(){
            if(StringUtils.isBlank(name)){
                throw new IllegalArgumentException("参数name不能为空");
            }
            if(maxIdle > maxTotal){
                throw new IllegalArgumentException("maxIdle > maxTotal");
            }
            if(minIdle < maxTotal){
                throw new IllegalArgumentException("minIdle < maxTotal");
            }
            return new BuilderPattern(this);
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            if(StringUtils.isBlank(name)){
                throw new IllegalArgumentException("name不能为空");
            }
            this.name = name;
            return this;
        }

        public int getMaxTotal() {
            return maxTotal;
        }

        public Builder setMaxTotal(int maxTotal) {
            if(maxTotal <= 0){
                throw new IllegalArgumentException("maxTotal不能为空");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public Builder setMaxIdle(int maxIdle) {
            if(maxIdle <= 0){
                throw new IllegalArgumentException("maxIdle不能为空");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public Builder setMinIdle(int minIdle) {
            if(minIdle <= 0){
                throw new IllegalArgumentException("minIdle不能为空");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
}
