package mywechatem.demo.utils.chat.api.impl;


import mywechatem.demo.utils.chat.api.AuthTokenAPI;
import mywechatem.demo.utils.chat.comm.TokenUtil;

public class EasemobAuthToken implements AuthTokenAPI {

	@Override
	public Object getAuthToken(){
		return TokenUtil.getAccessToken();
	}
}
