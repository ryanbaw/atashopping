package ata.wx.shopping.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 作者：郭丹丹
 功能：得到由当前时间产生的商品id ，充值记录id ，以及当前时间 
 时间：2008年1月25日
 **/
public class GetIdTime {

	public static String getPid() {
		long time = new Date().getTime();
		String pid = "P"+String.valueOf(time);
//System.out.println(pid);
		return pid;
	}
	
	public static String getFormid() {
		long time = new Date().getTime();
		String formid = "F"+String.valueOf(time);
//System.out.println(pid);
		return formid;
	}

	public static String getLogid() {
		long time = new Date().getTime();
		String logid = "L"+String.valueOf(time);
//System.out.println(logid);
		return logid;
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒 ");		
		Calendar ca = Calendar.getInstance();		
		ca.add(Calendar.HOUR, +8);
		Date date = ca.getTime();
		String nowTime=sdf.format(date);
//System.out.println(nowTime);
        return nowTime;
	}
	
}
