package com.devinforest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPUtil {
	public static String getIPAddress() {
		// IPv4 방식의 IP주소 가지고 오기
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	   
		String getIp = local.getHostAddress();
		System.out.println(getIp + "<-- IPUtil ip");
		return getIp;
	}
}
