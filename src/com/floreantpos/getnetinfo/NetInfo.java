package com.floreantpos.getnetinfo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/* CREDIT: Taken from http://www.mkyong.com/java/how-to-get-mac-address-in-java/ */

public class NetInfo {
	
	 public static String getIPAddr(){
			
			InetAddress ip;
			try {
					
				ip = InetAddress.getLocalHost();
				return(ip.getHostAddress());
			
			} catch (UnknownHostException e) {
				
				//e.printStackTrace();
				
			}
		return(null);
	 }
		
	 public static String getMACAddr() {
		 
			try {
				byte[] mac = null;
				NetworkInterface network = null;
				int c=0;
				while((network==null) && (c<100)) {
					System.out.print("Auto Terminal ID - Trying Network Interface: "+c+"\n");
					network = NetworkInterface.getByIndex(c);
					if (network != null)  {
						mac = network.getHardwareAddress();
						
						if (mac == null) {
							network=null;
							c++;
							continue;
						}
						
						if (network.isLoopback()) { 
							network=null;
							c++;
							continue;
						} 
						
					}		
					c++;
				}
				
				if (network==null) {
					System.out.print("MAC (interface) could not be determined for deriving TerminalID.\n");
					return(null);
				}
				
				if (mac==null) {
					System.out.print("MAC (hardware address) could not be determined for deriving TerminalID.\n");
					return(null);					
				}

				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					//sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
					sb.append(String.format("%03d%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
				}
				return(sb.toString());
					
				
			} catch (SocketException e){
					
				//e.printStackTrace();
					
			}
	
		
			return(null);
			    
		   }
	 
	 public static int getTerminalIDFromMACAddr() {
		 	
		 String mac=getMACAddr();
	 	 String terminalID = null;
		  if ( mac != null) {
		 	 terminalID=mac.replace("-","");
			 System.out.println("MAC Address: "+terminalID);
			 terminalID=terminalID.substring(terminalID.length() - 8);
		 	} else return(-1);
			return(Integer.parseInt(terminalID));
		  }
	 

}
