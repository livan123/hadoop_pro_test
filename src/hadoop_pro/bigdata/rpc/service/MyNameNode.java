package hadoop_pro.bigdata.rpc.service;

import hadoop_pro.bigdata.rpc.protocol.ClientNameNodeProtocol;

public class MyNameNode implements ClientNameNodeProtocol{
	
	//ģ��namenode��ҵ�񷽷�֮һ����ȡԪ���ݣ�
	//��������ĳһ̨��������Ϊ����������
	public String getMetaData(String path){
		return path+":3-{BLK_1,BLK_2}��������";
	}

}
