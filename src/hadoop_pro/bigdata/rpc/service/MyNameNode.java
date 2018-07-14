package hadoop_pro.bigdata.rpc.service;

import hadoop_pro.bigdata.rpc.protocol.ClientNameNodeProtocol;

public class MyNameNode implements ClientNameNodeProtocol{
	
	//模拟namenode的业务方法之一，获取元数据；
	//它运行在某一台机器上作为服务启动；
	public String getMetaData(String path){
		return path+":3-{BLK_1,BLK_2}…………";
	}

}
