package com.runner;

import com.api.pojo.LoginRequestPOJO;
import static com.utility.TestUtility.*;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginRequestPOJO loginRequestPOJO=new LoginRequestPOJO("iamfd","password");
		String data = convertPOJOToJSON(loginRequestPOJO);
		System.out.println(data);

	}

}
