package hadoop_pro.bigdata.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

public class HdfsClientDemo {
	
	FileSystem fs = null;
	@Before
	public void init() throws IOException{
        //��дһ��ͨѶϵͳ����Ҫ�Ƿֲ�ϵͳ��Ӧ��
		Configuration conf = new Configuration();
		conf.set("fs.DEFAULT_FS", "hdfs://mycluster");
		//�õ�һ���ļ�ϵͳ�����Ŀͻ���ʵ������hadoop���ļ�ϵͳ�ǿɲ�εģ�
		//������hdfs��Ҳ�����ñ���ϵͳ��
		//�˵ص�fs��һ���ض����ļ�ϵͳ�����Բ�Ӧ���ڴ˶��壬Ӧ��fs�Ķ�����ڷ��������档
		fs = FileSystem.get(conf);
	}
	//����init֮����Խ����ļ����ϴ����ز�����
	@Test
	public void testUpload() throws Exception, IOException{
		fs.copyFromLocalFile(new Path("F:/hadoop-file/core-site.xml"), 
				new Path("/access.log.copy"));
		fs.close();
	}
	//�ļ����أ�
	@Test
	public void testDownload() throws Exception, IOException{
		fs.copyToLocalFile(new Path("c:/access.log"),
				new Path("/access.log.copy"));
		fs.close();
	}
}
















