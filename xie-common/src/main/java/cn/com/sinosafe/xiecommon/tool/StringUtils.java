package cn.com.sinosafe.xiecommon.tool;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description //TODO 
 * @Author xiehanchun
 * @Date 2020/4/13 14:28
 * @Param 
 * @return 
 */
public class StringUtils {
	
	private StringUtils(){
	}
	
	private static StringUtils su = null;
	
	public static StringUtils getSingleInstance() {
		if(null == su){
			synchronized(StringUtils.class){
				if(null == su){
					su = new StringUtils();	
				}
			}
		}
		return su;
	}
	
	/**
	 *  忽略大小写的情况下是否以指定字符串开头
	 * @param str
	 * @param prefix
	 * @return
	 */
	public boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(true, 0, prefix, 0, prefix.length());
	}
	
	/**
	 * 使用 Map按key进行排序
	 * @param map
	 * @return
	 */
	public Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
	
	static class MapKeyComparator implements Comparator<String> {
		// 比较器类比较Key值
		public int compare(String str1, String str2) {
			return str1.compareTo(str2);
		}
	}
	/**
	 * 根据指定长度生成字母和数字的随机数
	 * 0~9的ASCII为48~57
	 * A~Z的ASCII为65~90
	 * a~z的ASCII为97~122
	 * @param length
	 */
	public  String createRandomCharData(int length){
	    StringBuilder sb=new StringBuilder();
	    Random rand=new Random();//随机用以下三个随机生成器
	    Random randdata=new Random();
	    int data=0;
	    for(int i=0;i<length;i++){
	        int index=rand.nextInt(3);
	        //目的是随机选择生成数字，大小写字母
	        switch(index){
	        case 0:
	             data=randdata.nextInt(10);//仅仅会生成0~9
	             sb.append(data);
	            break;
	        case 1:
	            data=randdata.nextInt(26)+65;//保证只会产生65~90之间的整数
	            sb.append((char)data);
	            break;
	        case 2:
	            data=randdata.nextInt(26)+97;//保证只会产生97~122之间的整数
	            sb.append((char)data);
	            break;
	        }
	    }
	    String result=sb.toString();
	    return result;
	}
	/**
	 * 不够位数的在前面补0，保留num的长度位数字
	 * @param code
	 * @param num
	 * @return
	 */
	public String autoGenericCode(int code, int num) {
	        String result = "";
	        result = String.format("%0" + num + "d", code + 1);
	        return result;
	    }
	/**
	 * 忽略大小写的情况下是否以指定字符串结尾
	 * @param str
	 * @param suffix
	 * @return
	 */
	public boolean endsWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(true, strOffset, suffix, 0, suffix.length());
	}
	
	/**
	 * 安全比较两个字符串是否相同
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean safeEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
	
	/**
	 * 安全比较两个字符串忽略大小写是否相同
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean safeEqualsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }
	
	 /**
	 * 获取使用MD5加密后的字符串
	 * @param val
	 * @return
	 * @throws Exception 
	 */
	public String getMD5String(String val) throws Exception
	{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = val.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 获取文件的MD5值（和文件内容相关，和文件名称无关）
	 * @param filepath
	 * @return
	 * @throws Exception 
	 */
	public String getFileMD5String(String filepath) throws Exception
	{
		try{
			File file = new File(filepath);
			BufferedInputStream bis = null;
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[32 * 1024];

			MessageDigest alg = MessageDigest.getInstance("MD5");
			alg.reset();
			while (true) {
				int len = bis.read(buffer);
				if (len <= 0) {
					break;
				} else {
					alg.update(buffer, 0, len);
				}
			}
			bis.close();
			
			byte[] hash = alg.digest();
			String md5 = "";
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16) {
					md5 += "0";
				}
				md5 += Integer.toString(v, 16);
			}
			return md5;
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 获取使用sha加密后的字符串
	 * @param filepath
	 * @return
	 * @throws Exception 
	 */
	public String getShaString(String val) throws Exception
	{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = val.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("sha");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 获取文件的sha值（和文件内容相关，和文件名称无关）
	 * @param filepath
	 * @return
	 * @throws Exception 
	 */
	public String getFileShaString(String filepath) throws Exception
	{
		try{
			File file = new File(filepath);
			BufferedInputStream bis = null;
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[32 * 1024];

			MessageDigest alg = MessageDigest.getInstance("sha");
			alg.reset();
			while (true) {
				int len = bis.read(buffer);
				if (len <= 0) {
					break;
				} else {
					alg.update(buffer, 0, len);
				}
			}
			bis.close();
			
			byte[] hash = alg.digest();
			String md5 = "";
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16) {
					md5 += "0";
				}
				md5 += Integer.toString(v, 16);
			}
			return md5;
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Base64加密（可逆）
	 * @param data
	 * @return
	 *//*
	public String encodeBase64(String data)
    {
        return Base64.encodeBase64String(data.getBytes());
    }
	
	*//**
	 * Base64解密
	 * @param data
	 * @return
	 *//*
	public String decodeBase64(String data)
	{
		byte[] s = Base64.decodeBase64(data);
		return new String(s);
	}
	
	*//**
	 * Hex加密（可逆）
	 * @param data
	 * @return
	 *//*
	public String encodeHex(String data)
    {
        return Hex.encodeHexString(data.getBytes());
    }*/
	
	/**
	 * Hex解密
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	public String decodeHex(String data) throws Exception
	{
		try{
			byte[] s = Hex.decodeHex(data.toCharArray());
			return new String(s);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 将下划线格式的字段转为驼峰式，多个连续下划线作为一个处理
	 * @param field
	 * @return
	 */
	public String convertToCamel(String field){
		if(null != field){
			StringBuilder rs = new StringBuilder();
			boolean upper = false;
			for(char ch : field.trim().toCharArray())
			{
				if(ch == '-' || ch == '_')
				{
					upper = true;
				}else
				{
					rs.append(upper ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
					upper = false;
				}
			}
			return rs.toString();
		}
		return null;
	}
	
	/**
	 * 替换XML中不易配置的字符串
	 * @param src
	 * @return
	 */
	public String replaceXmlChar(String src){
		return Replace.replaceXmlChar(src);
	}
	
	/**
	 * 获取随机ID，长度为count
	 * @param count
	 * @return
	 */
	public String getRandomId(int count){
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	/**
	 * 获取随机数字，长度为count
	 * @param count
	 * @return
	 */
	public String getRandomNumeric(int count){
		return RandomStringUtils.randomNumeric(count);
	}
	
	/**
	 * 字符串分割
	 * @param src
	 * @param separator
	 * @return
	 */
	public List<String> splitToList(String src, String separator)
	{
		List<String> l = new ArrayList<String>();
		if(null == src){
			return null;
		}else if(null == separator){
			l.add(src);
		}else{
			for(int i = src.indexOf(separator),o = separator.length();  i != -1; i = src.indexOf(separator))
			{
				l.add(src.substring(0, i));
				src = src.substring(i+ o);
			}
			if(null != src && !"".equals(src)){
				l.add(src);
			}
		}
		return l;
	}
	
	/**
	 * 字符串分割成固定长度的List，如果不够长度，使用默认字符串填充，如果长度超过指定长度，保持不变
	 * @param src
	 * @param separator
	 * @param fixLength
	 * @param defaultString
	 * @return
	 */
	public List<String> splitToList(String src, String separator, int fixLength, String defaultString)
	{
		List<String> l = splitToList(src, separator);
		if(null == l){
			l = new ArrayList<String>();
		}
		for(int i=fixLength-l.size()-1; i>=0; i--){
			l.add(defaultString);
		}
		return l;
	}
	
	/**
	 * 字符串分割
	 * @param src
	 * @param separator
	 * @return
	 */
	public String[] split(String src, String separator)
	{
		List<String> l = splitToList(src, separator);
		return null == l ? null : l.toArray(new String[l.size()]);
	}
	
	/**
	 * 字符串分割分割成固定数目的数组，如果不够，使用默认字符串填充，如果长度超过指定长度，保持不变
	 * @param src
	 * @param separator
	 * @param fixLength
	 * @param defaultString
	 * @return
	 */
	public String[] split(String src, String separator, int fixLength, String defaultString)
	{
		List<String> l = splitToList(src, separator, fixLength, defaultString);
		return null == l ? null : l.toArray(new String[l.size()]);
	}
	
	/**
	 * 用分隔符连接列表中的项
	 * @param list
	 * @param separator
	 * @return
	 */
	public String join(List<?> list, String separator){
		if(null == list || list.isEmpty()){
			return null;
		}
		if(null == separator){
			separator = "";
		}
		StringBuffer sb = new StringBuffer();
		for(Object obj : list){
			if(null != obj){
				sb.append(separator).append(obj.toString());
			}
		}
		return sb.substring(separator.length()).toString();
	}
	
	/**
	 * 用分隔符连接数组中的项
	 * @param arr
	 * @param separator
	 * @return
	 */
	public String join(Object[] arr, String separator){
		if(null == arr || arr.length == 0){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for(Object obj : arr){
			if(null != obj){
				sb.append(separator).append(obj.toString());
			}
		}
		return sb.substring(separator.length()).toString();
	}
	
	private String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }
	
	public String getRandomString(int length) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * 16);
			sb.append(hexDigits[index]);
		}
		return sb.toString();
	}
	/**
	 * javabean to map
	 * @param javaBean
	 * @return
	 */
	public Map<String, Object> bean2Map(Object javaBean){
		Map<String, Object> result = new HashMap<String, Object>(); 
        Method[] methods = javaBean.getClass().getDeclaredMethods(); 

        for (Method method : methods) 
        { 
            try 
            { 
                if (method.getName().startsWith("get")) 
                { 
                    String field = method.getName(); 
                    field = field.substring(field.indexOf("get") + 3); 
                    field = field.toLowerCase().charAt(0) + field.substring(1); 

                    Object value = method.invoke(javaBean, (Object[])null); 
                    result.put(field, null == value ? "" : value); 
                } 
            } 
            catch (Exception e) 
            { 
            } 
        } 

        return result;
	}
	
	/**
	 * javabean to map
	 * @param javaBean
	 * @return
	 */
	public Map<String, String> bean2Map$2(Object javaBean){
		Map<String, String> result = new HashMap<String, String>(); 
        Method[] methods = javaBean.getClass().getDeclaredMethods(); 

        for (Method method : methods) 
        { 
            try 
            { 
                if (method.getName().startsWith("get")) 
                { 
                    String field = method.getName(); 
                    field = field.substring(field.indexOf("get") + 3); 
                    field = field.toLowerCase().charAt(0) + field.substring(1); 

                    Object value = method.invoke(javaBean, (Object[])null); 
                    result.put(field, null == value ? "" : value.toString()); 
                } 
            } 
            catch (Exception e) 
            { 
            } 
        } 

        return result;
	}
}

/**
 * 替换XML中配置字符
 */
class Replace{
	Pattern pattern;
	String replace;
	
	private static List<Replace> xmlReplaceList = new ArrayList<Replace>();
	static{
		xmlReplaceList.add(new Replace(" and ", "&&"));
		xmlReplaceList.add(new Replace(" or ", "||"));
		xmlReplaceList.add(new Replace(" not ", "!"));
		xmlReplaceList.add(new Replace(" lq ", "<"));
	}
	
	/**
	 * 替换表达式中的字符（主要是为了便于在XML文件中书写）
	 * @param src
	 * @return
	 */
	public static String replaceXmlChar(String src){
		if(null != src){
			for(Replace r : xmlReplaceList){
				src = r.replaceThis(src);
			}
		}
		return src;
	}
	
	Replace(String pattern, String replace){
		this.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		this.replace = replace;
	}
	
	String replaceThis(String src){
		if(null != src){
			src = pattern.matcher(src).replaceAll(replace);
		}
		return src;
	}
	
}