package cn.com.sinosafe.xiecommon.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONUtils
{
    private static JSONUtils json;
    private static ObjectMapper mapper;
    
    public static JSONUtils getSingleInstance() {
        if (null == JSONUtils.json) {
            synchronized (JSONUtils.class) {
                if (null == JSONUtils.json) {
                    JSONUtils.json = new JSONUtils();
                }
            }
        }
        return JSONUtils.json;
    }
    
    public ObjectMapper getGlobalMapper() {
        if (null == JSONUtils.mapper) {
            synchronized (ObjectMapper.class) {
                if (null == JSONUtils.mapper) {
                    JSONUtils.mapper = getLocalMapper();
                }
            }
        }
        return JSONUtils.mapper;
    }
    
    public ObjectMapper getLocalMapper() {
        return new ObjectMapper().configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true).configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public String toJSon(Object object) throws JsonGenerationException, JsonMappingException, IOException {
        return getGlobalMapper().writeValueAsString(object);
    }
    
    public String responseFormat(String resString) {
        StringBuffer jsonForMatStr = new StringBuffer();
        int level = 0;
        for (int index = 0; index < resString.length(); ++index) {
            char c = resString.charAt(index);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '[':
                case '{': {
                    jsonForMatStr.append(c + "\n");
                    ++level;
                    break;
                }
                case ',': {
                    jsonForMatStr.append(c + "\n");
                    break;
                }
                case ']':
                case '}': {
                    jsonForMatStr.append("\n");
                    --level;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                }
                default: {
                    jsonForMatStr.append(c);
                    break;
                }
            }
        }
        return jsonForMatStr.toString();
    }
    
    private String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; ++levelI) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
    
    static {
        JSONUtils.json = null;
        JSONUtils.mapper = null;
    }
    
    /**
	 * 将Json字符串转变为Map<String, Object>
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public Map<String, String> readMapValue_(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonString, new TypeReference<Map<String, String>>(){});
	}
	
	/**
	 * 将Json字符串转变为List<Map<String, Object>>
	 * @param jsonString
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<Map<String, Object>> readListMapValue(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		return this.getGlobalMapper().readValue(jsonString, new TypeReference<List<Map<String, Object>>>(){});
	}

}
