package kr.co.youiwe.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BitSms {
	public static void sendMsg(String to, String msg) {
		
				BufferedReader in;
			    in = new BufferedReader(new InputStreamReader(System.in));

				String smsID= "rola";	
				String smsPW="bit123400";
			
				 // 보내는 번호010-9687-3487 입력할때 하이폰은 입력안한다
				//받는 번호  : 010-2559-8279(선생님)
				ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
				try{
					
		
				String senderPhone="01025598279";
			
				String receivePhone= to;
			
				String smsContent= msg;
				String test1 = (smsID+smsPW+receivePhone);
				CEncrypt encrypt = new CEncrypt("MD5",test1);
				java.lang.String send=sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
		 		System.out.println("결과코드:"+send);
				}catch(Exception e){
				System.out.println("Exception in main:" +e);
				}
			}
		

	}

