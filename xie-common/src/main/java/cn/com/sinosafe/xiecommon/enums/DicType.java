/**
 * 
 */
package cn.com.sinosafe.xiecommon.enums;


/**  
* <p>Title: DicType</p>  
* <p>Description: 字典类型</p>  
* @author longxiaoqiang  
* @date 2020年2月27日  
*/
public enum DicType {

	//学历
    DICTYPE_1(1, "STD_XG_EDU"), 
    //政治面貌
    DICTYPE_2(2, "STD_XG_POLITICAL"), 
    //从事行业
    DICTYPE_3(3, "STD_GB_4754-2011-QRY"), 
    //区域
    DICTYPEPAGE_4(4, "STD_GB_T2260"),
    //申请状态
    APPLYSTATUS_5(5, "APPLY_STATUS"),
	//个人代理区域
    DICTYPEPAGE_6(6, "STD_GD_AREA"),
	//征信授权书内容
	DICTYPEPAGE_7(7, "STD_CREDIT_GD");


    private final String msg;
    private final int code;

    private DicType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
 // 根据ID获取枚举
    public static String getContent(int code){
        for(DicType temp:DicType.values()){
            if(temp.getCode() == code){
                return temp.getMsg();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
