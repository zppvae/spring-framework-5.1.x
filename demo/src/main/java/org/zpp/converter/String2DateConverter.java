package org.zpp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zpp
 * @date 2020/1/14 18:10
 */
public class String2DateConverter implements Converter<String,Date> {

	private final String format = "yyyy-MM-dd HH:mm:ss";

	@Override
	public Date convert(String source) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(source);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
