package cn.com.sinosafe.xiecommon.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具
 * 
 * @author sinosafe
 */
public final class StrUtils {
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 转化空对象为""
	 * @param obj
	 * @return
	 */
	public static String nullReplace(Object obj) {
		String result = "";
		if(obj != null) {
			result = String.valueOf(obj);
		}
		return result;
	}
	/**
	 * 字符串去除空格
	 * @param content
	 * @return
	 */
	public static String removeSpace(String content) {
		if(isNotEmpty(content)) {
			content = content.replaceAll("\\s*","");
		}
		return content;
	}
	
	/**
	 * 
	 * 方法说明：处理身份证号或者手机号
	 * @version 0.1.0
	 * @time 2017年12月26日
	 */
	public static String hideContent(String content) {
		String result = content;
		if(isNotEmpty(content)) {
			if(content.length() == 11) {
				result = content.substring(0,3)+"***"+content.substring(8,11);
			} else if(content.length() == 18) {
				result = content.substring(0, 4)+"***"+content.substring(14,18);
			} else if(content.length() > 18) {
				result = content.substring(0,5)+"*****"+content.substring(content.length()-3,content.length());
			}
		}
		return result;
	}
	/**
	 * 
	 * 方法说明：从身份证号获取性别：1男2女
	 * @version 0.1.0
	 * @time 2017年12月26日
	 */
	public static String getSexByCertCode(String certCode) {
		String result = null;
		if(isNotEmpty(certCode)) {
			if(certCode.length() == 18) {
				result = certCode.substring(16,17);
				int num = Integer.valueOf(result);
				if(num % 2 == 0) {
					result = "2";
				} else {
					result = "1";
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * 方法说明：从身份证号获取生日
	 * @version 0.1.0
	 * @time 2017年12月26日
	 */
	public static String getBirthByCertCode(String certCode) {
		String result = null;
		if(isNotEmpty(certCode)) {
			if(certCode.length() == 18) {
				result = certCode.substring(6,10)+"-"+certCode.substring(10,12)+"-"+certCode.substring(12,14);
			}
		}
		return result;
	}
	/**
	 * 
	 * 方法说明：从身份证号获取生日
	 * @version 0.1.0
	 * @time 2017年12月26日
	 */
	public static String emailToHide(String email) {
		String result = email;
		if(isNotEmpty(email)) {
			 if(email.length() > 2) {
				 result = email.substring(0, 2) + "*****" + email.substring(email.indexOf("@"), email.length());
			 }
		}
		return result;
	}
	
	/**
	 * 中文字符转化
	 * 
	 * @author liansonghui
	 * @param content
	 * @throws UnsupportedEncodingException
	 */
	public static String chineseToUTF8(String content) throws UnsupportedEncodingException {
		if (StrUtils.isNotEmpty(content)) {
			content = new String(content.getBytes("iso-8859-1"), "UTF-8");
		}
		return content;
	}

	/**
	 * 中文字符转化
	 * 
	 * @author liansonghui
	 * @param content
	 * @throws UnsupportedEncodingException
	 */
	public static String chineseToUTF8WithoutCharset(String content) throws UnsupportedEncodingException {
		if (StrUtils.isNotEmpty(content)) {
			content = new String(content.getBytes(), "UTF-8");
		}
		return content;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}

		if ("".equals(str.trim())) {
			return true;
		}

		return false;
	}

	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 判断字符串是否为空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return "".equals(str.trim());
	}

	/**
	 * 判断字符串是否为非空字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * 将字符串转为boolean类型
	 * 
	 * @param value
	 * @param defaultValue
	 *            设置默认值，默认使用false
	 * @return
	 */
	public static Boolean toBoolean(String value, boolean defaultValue) {
		if (isEmpty(value)) {
			return defaultValue;
		}

		try {
			return Boolean.parseBoolean(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转为boolean类型
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean toBoolean(String value) {
		return toBoolean(value, false);
	}

	/**
	 * 将字符串转为long类型
	 * 
	 * @param value
	 * @param defaultValue
	 *            设置默认值
	 * @return
	 */
	public static Long toLong(String value, Long defaultValue) {
		if (isEmpty(value)) {
			return defaultValue;
		}
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转为int类型
	 * 
	 * @param value
	 * @param defaultValue
	 *            设置默认值
	 * @return
	 */
	public static Integer toInt(String value, Integer defaultValue) {
		if (isEmpty(value)) {
			return defaultValue;
		}
			
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转为double类型
	 * 
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static Double toDouble(String value, Double defaultValue) {
		if (isEmpty(value)) {
			return defaultValue;
			
		}
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串转为float类型
	 * 
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static Float toFloat(String value, Float defaultValue) {
		if (isEmpty(value)) {
			return defaultValue;
			
		}
		try {
			return Float.parseFloat(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * 将数组值按英文逗号拼接成字符串
	 * 
	 * @param array
	 * @return
	 */
	public static String join(Object[] array) {
		return join(array, ",", "");
	}

	/**
	 * 将数组值按指定分隔符拼接成字符串
	 * 
	 * @param array
	 * @param delimiter
	 *            分割符，默认使用英文逗号
	 * @return
	 */
	public static String join(Object[] array, String delimiter) {

		return join(array, delimiter, "");
	}

	/**
	 * 将数组值按指定分隔符拼接成字符串 <br>
	 * </br>
	 * <b>示例</b>： <br>
	 * </br>
	 * array等于new String[]{"a","b"} <br>
	 * </br>
	 * delimiter等于, <br>
	 * </br>
	 * surround等于' <br>
	 * </br>
	 * 转换结果为：'a','b'
	 * 
	 * @param array
	 * @param delimiter
	 *            分割符，默认使用英文逗号
	 * @param surround
	 *            每个值左右符号，默认无
	 * @return
	 */
	public static String join(Object[] array, String delimiter, String surround) {
		if (array == null) {
			throw new IllegalArgumentException("Array can not be null");
			
		}

		if (array.length == 0) {
			return "";
			
		}

		if (surround == null) {
			
			surround = ""; 
		}

		if (delimiter == null) {
			
			surround = ",";
		}

		StringBuffer buffer = new StringBuffer();

		for (Object item : array) {
			buffer.append(surround).append(item.toString()).append(surround).append(delimiter);
		}

		buffer.delete(buffer.length() - delimiter.length(), buffer.length());

		return buffer.toString();
	}

	/**
	 * Encode a string using algorithm specified in web.xml and return the resulting
	 * encrypted password. If exception, the plain credentials string is returned
	 *
	 * @param password
	 *            Password or other credentials to use in authenticating this
	 *            username
	 * @param algorithm
	 *            Algorithm used to do the digest
	 *
	 * @return encypted password based on the algorithm.
	 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();

		MessageDigest md = null;

		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			return password;
		}

		md.reset();

		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}

			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}

		return buf.toString();
	}

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return (map == null || map.isEmpty());
	}

	public static <K, V> boolean isNotEmpty(Map<K, V> map) {
		return (map != null && !map.isEmpty());
	}

	/**
	 * 方法说明：处理银行名称差异
	 * @version 1.0.0
	 * @time 2018年1月18日
	 */
	public static String dealBankName(String bankName) {
		if(bankName != null) {
			if(!"中国银行".equals(bankName)) {
				String temp = bankName;
				bankName = bankName.replace("银行", "");
				temp = temp + ","+bankName;
				if(bankName.contains("浦发") || bankName.contains("浦东")) {
					temp = temp + ",浦东发展";
				}
				bankName = temp;
			}
		}
		return bankName;
	}

	/**
	 * 方法说明：拆分身份证地址到省市区
	 * @version 1.0.0
	 * @time 2018年1月22日
	 */
	public static Map<String, String> splitCertAddress(String certAddress) {
		Map<String,String> resultMap = new HashMap<String,String>(8);
		String provName = null;
		String cityName = null;
		String countyName = null;
		String temp = null;
		if(isNotEmpty(certAddress)) {
			String[] split = certAddress.split("省");
			if(split != null && split.length > 1) {
				provName = split[0]+"省";
				split = split[1].split("市");
				if(split != null && split.length > 1) {
					cityName = split[0]+"市";
					temp = split[1];
					split = temp.split("区");
					if(split != null && split.length > 1) {
						countyName = split[0]+"区";
					} else {
						split = temp.split("县");
						if(split != null && split.length > 1) {
							countyName = split[0]+"县";
						} else {
							split = temp.split("镇");
							if(split != null && split.length > 1) {
								countyName = split[0]+"镇";
							}
						}
					}
				} 
			} else {
				//上海市,北京市,天津市和重庆市
				String cities = "上海,北京,天津,重庆";
				//是否直辖市
				boolean isCity = false;
				String city = null;
				for(String c : cities.split(",")) {
					if(certAddress.contains(c) ) {
						isCity = true;
						city = c;
					}
				}
				if(isCity) {
					if(certAddress.startsWith(city)) {
						provName = city+"市";
						if("市".equals(certAddress.substring(2,3))) {
							certAddress = certAddress.substring(3,certAddress.length());
						} else {
							certAddress = certAddress.replace(city, "");
						}
						split = certAddress.split("市");
						if(split != null) {
							if(split.length > 1) {
								cityName = split[0]+"市";
								temp = split[1];
								split = temp.split("区");
								if(split != null && split.length > 1) {
									countyName = split[0]+"区";
								} else {
									split = temp.split("县");
									if(split != null && split.length > 1) {
										countyName = split[0]+"县";
									} else {
										split = temp.split("镇");
										if(split != null && split.length > 1) {
											countyName = split[0]+"镇";
										}
									}
								}
							}
						} 
					}
				} else {
					String areaSplit = "自治区";
					if(certAddress.contains(areaSplit)) {
						split = areaSplit.split(areaSplit);
						if(split != null && split.length > 1) {
							provName = split[0]+areaSplit;
							split = split[1].split("市");
							if(split != null && split.length > 1) {
								cityName = split[0]+"市";
								temp = split[1];
								split = temp.split("区");
								if(split != null && split.length > 1) {
									countyName = split[0]+"区";
								} else {
									split = temp.split("县");
									if(split != null && split.length > 1) {
										countyName = split[0]+"县";
									} else {
										split = temp.split("镇");
										if(split != null && split.length > 1) {
											countyName = split[0]+"镇";
										}
									}
								}
							} 
						}
					}
				}
				 
			}
		}
		resultMap.put("provName", provName);
		resultMap.put("cityName", cityName);
		resultMap.put("countyName", countyName);
		return resultMap;
	}

	
	/**
     * 解析地址
     * @param address
     * @return
     */
    public static List<Map<String,String>> addressSplit(String address){
        String regex="((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)(?<city>[^市]+市|.+自治州)?(?<county>[^县]+县|.+区|.+镇|.+局)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m=Pattern.compile(regex).matcher(address);
        String province=null,city=null,county=null,town=null,village=null;
        List<Map<String,String>> table=new ArrayList<Map<String,String>>();
        Map<String,String> row=null;
        while(m.find()){
            row=new LinkedHashMap<String,String>();
            province=m.group("province");
            row.put("provName", province==null?"":province.trim());
            city=m.group("city");
            row.put("cityName", city==null?"":city.trim());
            county=m.group("county");
            row.put("countyName", county==null?"":county.trim());
            town=m.group("town");
            row.put("townName", town==null?"":town.trim());
            village=m.group("village");
            row.put("villageName", village==null?"":village.trim());
            table.add(row);
        }
        return table;
    }
    
	/**
     * <p>Compares two Strings, returning <code>true</code> if they are equal ignoring
     * the case.</p>
     *
     * <p><code>null</code>s are handled without exceptions. Two <code>null</code>
     * references are considered equal. Comparison is case insensitive.</p>
     *
     * <pre>
     * StringUtils.equalsIgnoreCase(null, null)   = true
     * StringUtils.equalsIgnoreCase(null, "abc")  = false
     * StringUtils.equalsIgnoreCase("abc", null)  = false
     * StringUtils.equalsIgnoreCase("abc", "abc") = true
     * StringUtils.equalsIgnoreCase("abc", "ABC") = true
     * </pre>
     */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		 return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}
	/**
     * <p>Left pad a String with a specified character.</p>
     *
     * <p>Pad to a size of <code>size</code>.</p>
     *
     * <pre>
     * StringUtils.leftPad(null, *, *)     = null
     * StringUtils.leftPad("", 3, 'z')     = "zzz"
     * StringUtils.leftPad("bat", 3, 'z')  = "bat"
     * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
     * StringUtils.leftPad("bat", 1, 'z')  = "bat"
     * StringUtils.leftPad("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str  the String to pad out, may be null
     * @param size  the size to pad to
     * @param padChar  the character to pad with
     * @return left padded String or original String if no padding is necessary,
     *  <code>null</code> if null String input
     * @since 2.0
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
        	// returns original String when possible
            return str; 
        }
        if (pads > 8192) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }

    /**
     * <p>Left pad a String with a specified String.</p>
     *
     * <p>Pad to a size of <code>size</code>.</p>
     *
     * <pre>
     * StringUtils.leftPad(null, *, *)      = null
     * StringUtils.leftPad("", 3, "z")      = "zzz"
     * StringUtils.leftPad("bat", 3, "yz")  = "bat"
     * StringUtils.leftPad("bat", 5, "yz")  = "yzbat"
     * StringUtils.leftPad("bat", 8, "yz")  = "yzyzybat"
     * StringUtils.leftPad("bat", 1, "yz")  = "bat"
     * StringUtils.leftPad("bat", -1, "yz") = "bat"
     * StringUtils.leftPad("bat", 5, null)  = "  bat"
     * StringUtils.leftPad("bat", 5, "")    = "  bat"
     * </pre>
     *
     * @param str  the String to pad out, may be null
     * @param size  the size to pad to
     * @param padStr  the String to pad with, null or empty treated as single space
     * @return left padded String or original String if no padding is necessary,
     *  <code>null</code> if null String input
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
        	// returns original String when possible
            return str; 
        }
        if (padLen == 1 && pads <= 8192) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }
    /**
     * <p>Returns padding using the specified delimiter repeated
     * to a given length.</p>
     *
     * <pre>
     * StringUtils.padding(0, 'e')  = ""
     * StringUtils.padding(3, 'e')  = "eee"
     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     *
     * <p>Note: this method doesn't not support padding with
     * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode Supplementary Characters</a>
     * as they require a pair of <code>char</code>s to be represented.
     * If you are needing to support full I18N of your applications
     * consider using {@link #repeat(String, int)} instead. 
     * </p>
     *
     * @param repeat  number of times to repeat delim
     * @param padChar  character to repeat
     * @return String with repeated character
     * @throws IndexOutOfBoundsException if <code>repeat &lt; 0</code>
     * @see #repeat(String, int)
     */
    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }
    
    /**
     * <p>Right pad a String with spaces (' ').</p>
     *
     * <p>The String is padded to the size of <code>size</code>.</p>
     *
     * <pre>
     * StringUtils.rightPad(null, *)   = null
     * StringUtils.rightPad("", 3)     = "   "
     * StringUtils.rightPad("bat", 3)  = "bat"
     * StringUtils.rightPad("bat", 5)  = "bat  "
     * StringUtils.rightPad("bat", 1)  = "bat"
     * StringUtils.rightPad("bat", -1) = "bat"
     * </pre>
     *
     * @param str  the String to pad out, may be null
     * @param size  the size to pad to
     * @return right padded String or original String if no padding is necessary,
     *  <code>null</code> if null String input
     */
    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    /**
     * <p>Right pad a String with a specified character.</p>
     *
     * <p>The String is padded to the size of <code>size</code>.</p>
     *
     * <pre>
     * StringUtils.rightPad(null, *, *)     = null
     * StringUtils.rightPad("", 3, 'z')     = "zzz"
     * StringUtils.rightPad("bat", 3, 'z')  = "bat"
     * StringUtils.rightPad("bat", 5, 'z')  = "batzz"
     * StringUtils.rightPad("bat", 1, 'z')  = "bat"
     * StringUtils.rightPad("bat", -1, 'z') = "bat"
     * </pre>
     *
     * @param str  the String to pad out, may be null
     * @param size  the size to pad to
     * @param padChar  the character to pad with
     * @return right padded String or original String if no padding is necessary,
     *  <code>null</code> if null String input
     * @since 2.0
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
        	// returns original String when possible
            return str; 
        }
        if (pads > 8192) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
     * <p>Right pad a String with a specified String.</p>
     *
     * <p>The String is padded to the size of <code>size</code>.</p>
     *
     * <pre>
     * StringUtils.rightPad(null, *, *)      = null
     * StringUtils.rightPad("", 3, "z")      = "zzz"
     * StringUtils.rightPad("bat", 3, "yz")  = "bat"
     * StringUtils.rightPad("bat", 5, "yz")  = "batyz"
     * StringUtils.rightPad("bat", 8, "yz")  = "batyzyzy"
     * StringUtils.rightPad("bat", 1, "yz")  = "bat"
     * StringUtils.rightPad("bat", -1, "yz") = "bat"
     * StringUtils.rightPad("bat", 5, null)  = "bat  "
     * StringUtils.rightPad("bat", 5, "")    = "bat  "
     * </pre>
     *
     * @param str  the String to pad out, may be null
     * @param size  the size to pad to
     * @param padStr  the String to pad with, null or empty treated as single space
     * @return right padded String or original String if no padding is necessary,
     *  <code>null</code> if null String input
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
        	// returns original String when possible
            return str; 
        }
        if (padLen == 1 && pads <= 8192) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

	/**
	 * @Description 判断字符串是否为空
	 * @Date 2019/8/27 15:22
	 * @param parms
	 * @return boolean
	 */
	public static boolean isEmpty(String...parms){
		if (parms != null && parms.length > 0) {
			for (int i = 0; i < parms.length; i++) {
				if (isEmpty(parms[i])){
					return true;
				}
			}
		}
		return false;
	}
}
