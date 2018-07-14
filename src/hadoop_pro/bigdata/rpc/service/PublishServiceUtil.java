package hadoop_pro.bigdata.rpc.service;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Builder;
import org.apache.hadoop.ipc.RPC.Server;

import hadoop_pro.bigdata.rpc.client.IUserLoginService;
import hadoop_pro.bigdata.rpc.client.UserLoginServiceImpl;
import hadoop_pro.bigdata.rpc.protocol.ClientNameNodeProtocol;

public class PublishServiceUtil {
	//发布服务的工具；
	public static void main(String[] args) throws Exception, IOException{
		Builder builder=new RPC.Builder(new Configuration());
		builder.setBindAddress("localhost")
			.setPort(8888)
			.setProtocol(ClientNameNodeProtocol.class)
			.setInstance(new MyNameNode());
		//用builder方法，可以返回一个server对象，启动服务，运行这个东西就可以把别人写的业务类启动为服务；	
		Server server=builder.build();
		server.start();
        //如果远程调用的是getMetaData方法，则这个方法用反射方式去调这个对象方法的相应的参数方法，
		//此时这个服务便写好了，需要在其他地方编写相应的client来调用这个服务，调用的时候只需要实现上面的接口，
		//然后传递相应的参数给到服务端即可；
	
		Builder builder2=new RPC.Builder(new Configuration());
		builder.setBindAddress("localhost")
			.setPort(9999)
			.setProtocol(IUserLoginService.class)
			.setInstance(new UserLoginServiceImpl());
		//用builder方法，可以返回一个server对象，启动服务，运行这个东西就可以把别人写的业务类启动为服务；	
		Server server2=builder.build();
		server2.start();
	}
}
