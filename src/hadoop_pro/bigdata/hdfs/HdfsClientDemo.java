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
        //先写一个通讯系统，主要是分布系统中应用
		Configuration conf = new Configuration();
		conf.set("fs.DEFAULT_FS", "hdfs://mycluster");
		//拿到一个文件系统操作的客户端实例对象；hadoop的文件系统是可插拔的，
		//可以用hdfs，也可以用本地系统；
		//此地的fs是一个特定的文件系统，所以不应该在此定义，应将fs的定义放在方法的外面。
		fs = FileSystem.get(conf);
	}
	//做完init之后可以进行文件的上传下载操作：
	@Test
	public void testUpload() throws Exception, IOException{
		fs.copyFromLocalFile(new Path("F:/hadoop-file/core-site.xml"), 
				new Path("/access.log.copy"));
		fs.close();
	}
	//文件下载：
	@Test
	public void testDownload() throws Exception, IOException{
		fs.copyToLocalFile(new Path("c:/access.log"),
				new Path("/access.log.copy"));
		fs.close();
	}
}
















