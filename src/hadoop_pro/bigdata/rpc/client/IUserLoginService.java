package hadoop_pro.bigdata.rpc.client;

public interface IUserLoginService {
	
	public static final long versionID=100L;
	public String login(String name, String password);

}
