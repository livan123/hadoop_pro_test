package hadoop_pro.bigdata.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class UserLoginAction {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IUserLoginService userLoginService = 
				RPC.getProxy(
						IUserLoginService.class, 
						100L, new InetSocketAddress("localhost", 9999), 
						new Configuration());
		String login=userLoginService.login("anglababy", "123456");
		System.out.println(login);
	}

}
