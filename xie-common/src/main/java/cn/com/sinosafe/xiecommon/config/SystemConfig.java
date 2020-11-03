package cn.com.sinosafe.xiecommon.config;

//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;

import com.google.zxing.client.j2se.CommandLineRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 加载微服务系统配置
 * @Author	: xiehanchun
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
//@Slf4j
//@AllArgsConstructor
//@Component
//public class SystemConfig implements CommandLineRunner {
//	public static Map<String, String> cacheMap = new HashMap<String, String>();
//	public static Map<String, String> mpTextMsgMap = new HashMap<String, String>();
//	public static Map<String, String> mpClickMsgMap = new HashMap<String, String>();
	
//	@Autowired
//	private SysConfigMapper sysConfigMapper;
//	@Autowired
//	private MpReplyMsgMapper mpReplyMsgMapper;
	
//	@Override
//	public void run(String... args) throws Exception {
		// 加载系统配置
//		List<Map<String, String>> list = sysConfigMapper.listSystemConfig();
//		for (Map<String, String> map : list) {
//			cacheMap.put(map.get("config_key"), map.get("config_value"));
//		}
//		log.info("系统配置cacheMap加载成功！");
		
		// 加载公众号文本消息配置
//		List<Map<String, String>> textMsgList = mpReplyMsgMapper.selectMpReplyMsgListByType(MpMsgType.text.name());
//		for (Map<String, String> map : textMsgList) {
//			mpTextMsgMap.put(map.get("msg_key"), map.get("msg_content"));
//		}
//		log.info("公众号文本消息配置mpTextMsgMap加载成功！");
		
		// 加载公众号点击事件消息配置
//		List<Map<String, String>> clickMsgList = mpReplyMsgMapper.selectMpReplyMsgListByType(MpMsgType.click.name());
//		for (Map<String, String> map : clickMsgList) {
//			mpClickMsgMap.put(map.get("msg_key"), map.get("msg_content"));
//		}
//		log.info("公众号点击事件消息配置mpClickMsgMap加载成功！");
		
//	}
	

//}
