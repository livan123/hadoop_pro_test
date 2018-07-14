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
	//��������Ĺ��ߣ�
	public static void main(String[] args) throws Exception, IOException{
		Builder builder=new RPC.Builder(new Configuration());
		builder.setBindAddress("localhost")
			.setPort(8888)
			.setProtocol(ClientNameNodeProtocol.class)
			.setInstance(new MyNameNode());
		//��builder���������Է���һ��server������������������������Ϳ��԰ѱ���д��ҵ��������Ϊ����	
		Server server=builder.build();
		server.start();
        //���Զ�̵��õ���getMetaData����������������÷��䷽ʽȥ��������󷽷�����Ӧ�Ĳ���������
		//��ʱ��������д���ˣ���Ҫ�������ط���д��Ӧ��client������������񣬵��õ�ʱ��ֻ��Ҫʵ������Ľӿڣ�
		//Ȼ�󴫵���Ӧ�Ĳ�����������˼��ɣ�
	
		Builder builder2=new RPC.Builder(new Configuration());
		builder.setBindAddress("localhost")
			.setPort(9999)
			.setProtocol(IUserLoginService.class)
			.setInstance(new UserLoginServiceImpl());
		//��builder���������Է���һ��server������������������������Ϳ��԰ѱ���д��ҵ��������Ϊ����	
		Server server2=builder.build();
		server2.start();
	}
}
