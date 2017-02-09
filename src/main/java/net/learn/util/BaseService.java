package net.learn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

 
public class BaseService {
	
//	@Override
//	public String parseResult(String info) {
//		return info;
//	}
	public static SerializerFeature[] s = {SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullBooleanAsFalse,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty};
	public static SerializerFeature[] s1 = {SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteNullBooleanAsFalse,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty};
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(java.sql.Timestamp.class, new CustomDateEditor(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss"), true));
	}

	protected  static String jsonSuccess(Object mapObject) {
		Map<String, Object> allMap = new HashMap<String, Object>();
		//allMap.put("code", 200);
		//allMap.put("msg", "success");
//		if (null != mapObject) {
//			allMap.put("data", mapObject);
//		}
		String result = JSON.toJSONString(allMap,s).replaceAll(":null", ":\"\"");
		return result;
	}
	protected String jsonSuccess2(Object mapObject) {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("success", true);
		if (null != mapObject) {
			allMap.put("data", mapObject);
		}
		String result = JSON.toJSONString(allMap,s1).replaceAll(":null", ":\"\"");
		return result;
	}
	
	protected String jsonSuccess() {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("code", 200);
		allMap.put("msg", "success");
		return JSON.toJSONString(allMap);
	}
	protected String jsonSuccess2() {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("code", 000);
		allMap.put("msg", "errr");
		return JSON.toJSONString(allMap);
	}
	
	protected String jsonFailure() {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("code", 500);
		allMap.put("msg", "error");
		return JSON.toJSONString(allMap);
	}
	protected String jsonFailure3() {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("code", 300);
		allMap.put("msg", "城市已存在");
		return JSON.toJSONString(allMap);
	}
	protected String jsonFailure2() {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("state", 2);
		allMap.put("sendTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		allMap.put("data", "签名信息未通过");

		String result = JSON.toJSONString(allMap,s).replaceAll(":null", ":\"\"");
		return result;
	}
	
	protected String jsonFailure(Exception e) {
		e.printStackTrace();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		if(e instanceof ServiceException ){
			ServiceException temp=(ServiceException)e;
			map.put("errCode", temp.getErrCode());
			map.put("errSubCode", temp.getErrSubCode());
			map.put("message", temp.getMessage());
		}else{
			map.put("errCode", 1);
			map.put("errSubCode", "");
			map.put("message", e.initCause(e.getCause()).toString());
		}
		return JSON.toJSONString(map);
	}
	protected String paramsFailure() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("message", "parameter is not correct ");
		return JSON.toJSONString(map);
	}
	
	
	/** 
	 * <dt><span class="strong">方法描述:</span></dt><dd>参数异常JSON</dd>
	 * <dt><span class="strong">作者:</span></dt><dd>xuanhua.hu</dd>
	 * <dt><span class="strong">时间:</span></dt><dd>2016-7-9 上午11:54:17</dd>
	 * @param errSubcode
	 * @param message
	 * @return null
	 * @since v1.0
	*/
	protected String paramsFailure(String errSubcode,String message) {
		Map<String, Object> allMap = new HashMap<String, Object>();
		allMap.put("code", errSubcode);
		allMap.put("msg", message);
		return JSON.toJSONString(allMap);
	}
 
}
