package hadoop_pro.bigdata.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import hadoop_pro.bigdata.rpc.protocol.ClientNameNodeProtocol;

public class MyHdfsClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ClientNameNodeProtocol namenode = 
				RPC.getProxy(
				ClientNameNodeProtocol.class, 
				1L, 
				new InetSocketAddress("localhost",8888), 
				new Configuration());
		System.out.println(namenode.getMetaData("/angela.mygirl"));
	}
}
