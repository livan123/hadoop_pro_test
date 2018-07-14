package hadoop_pro.bigdata.rpc.client;

public class UserLoginServiceImpl implements IUserLoginService{

	@Override
	public String login(String name, String password) {
		// TODO Auto-generated method stub
		return name+"logged in sucessfully";
	}

}
