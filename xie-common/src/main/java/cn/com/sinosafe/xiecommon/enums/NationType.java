/**
 * 
 */
package cn.com.sinosafe.xiecommon.enums;

/**  
* <p>Title: NationType</p>  
* <p>Description: 民族类型</p>  
* @author longxiaoqiang  
* @date 2020年2月27日  
*/
public enum NationType {
	//
	NATIONTYPE_1("汉族", "01"), 
    //
	NATIONTYPE_2("蒙古族", "02"), 
    //
	NATIONTYPE_3("回族", "03"), 
    //
	NATIONTYPE_4("藏族", "04"),
	//
	NATIONTYPE_5("维吾尔族", "05"), 
	//
	NATIONTYPE_6("苗族", "06"), 
	//
	NATIONTYPE_7("彝族", "07"), 
	//
	NATIONTYPE_8("壮族", "08"),
	//
	NATIONTYPE_9("布依族", "09"), 
	//
	NATIONTYPE_10("朝鲜族", "10"), 
	//
	NATIONTYPE_11("满族", "11"), 
	//
	NATIONTYPE_12("侗族", "12"),
	//
	NATIONTYPE_13("瑶族", "13"), 
	//
	NATIONTYPE_14("白族", "14"), 
	//
	NATIONTYPE_15("土家族", "15"), 
	//
	NATIONTYPE_16("哈尼族", "16"),
	//
	NATIONTYPE_17("哈萨克族", "17"), 
	//
	NATIONTYPE_18("傣族", "18"), 
	//
	NATIONTYPE_19("黎族", "19"), 
	//
	NATIONTYPE_20("傈傈族", "20"),
	//
	NATIONTYPE_21("佤族", "21"), 
	//
	NATIONTYPE_22("畲族", "22"), 
	//
	NATIONTYPE_23("高山族", "23"), 
	//
	NATIONTYPE_24("拉祜族", "24"),
	//
	NATIONTYPE_25("水族", "25"), 
	//
	NATIONTYPE_26("东乡族", "26"), 
	//
	NATIONTYPE_27("纳西族", "27"), 
	//
	NATIONTYPE_28("景颇族", "28"),
	//
	NATIONTYPE_29("柯尔克孜族", "29"), 
	//
	NATIONTYPE_30("土族", "30"), 
	//
	NATIONTYPE_31("达斡尔族", "31"), 
	//
	NATIONTYPE_32("仫佬族", "32"),
	//
	NATIONTYPE_33("羌族", "33"), 
	//
	NATIONTYPE_34("布朗族", "34"), 
	//
	NATIONTYPE_35("撒拉族", "35"), 
	//
	NATIONTYPE_36("毛南族", "36"),
	//
	NATIONTYPE_37("仡佬族", "37"), 
	//
	NATIONTYPE_38("锡伯族", "38"), 
	//
	NATIONTYPE_39("阿昌族", "39"), 
	//
	NATIONTYPE_40("普米族", "40"),
	//
	NATIONTYPE_41("塔吉克族", "41"), 
	//
	NATIONTYPE_42("怒族", "42"), 
	//
	NATIONTYPE_43("乌孜别克族", "43"), 
	//
	NATIONTYPE_44("俄罗斯族", "44"),
	//
	NATIONTYPE_45("鄂温克族", "45"), 
	//
	NATIONTYPE_46("德昂族", "46"), 
	//
	NATIONTYPE_47("保安族", "47"), 
	//
	NATIONTYPE_48("裕固族", "48"),
	//
	NATIONTYPE_49("京族", "49"), 
	//
	NATIONTYPE_50("塔塔尔族", "50"), 
	//
	NATIONTYPE_51("独龙族", "51"), 
	//
	NATIONTYPE_52("鄂伦春族", "52"),
	//
	NATIONTYPE_53("赫哲族", "53"), 
	//
	NATIONTYPE_54("门巴族", "54"), 
	//
	NATIONTYPE_55("珞巴族", "55"), 
	//
	NATIONTYPE_56("基诺族", "56"),
	//
	NATIONTYPE_99("未知", "99");



    private final String msg;
    private final String code;

    private NationType(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }
    
    // 根据名称获取编号
    public static String getContent(String msg){
        for(NationType temp:NationType.values()){
            if(msg.equals(temp.getMsg())){
                return temp.getCode();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
