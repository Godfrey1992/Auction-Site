package come.myEbay.bean;

import java.util.ArrayList;

import javax.ejb.Remote;



@Remote
public interface UserBeanRemote {
	
	String setId(String id);
	
	String getId();
	
	String setUserName(String userName);
	
	String getUserName();
	
	String setName(String name);
	
	String getName();
	
}
