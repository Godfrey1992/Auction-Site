package come.myEbay.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class UserBean
 */
@Stateless (mappedName = "ejb/UserBean")
public class UserBean implements UserBeanRemote {

	String id1;
	String userName1;
	String name1;

    /**
     * Default constructor. 
     */
    public UserBean() {
        // TODO Auto-generated constructor stub

    }

	@Override
	public String setName(String name) {
		
		name1 = name;
		return null;
	}

	@Override
	public String getName() {
		
		return name1;
	}

	@Override
	public String setId(String id) {
		id1 = id;
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id1;
	}

	@Override
	public String setUserName(String userName) {
		userName1 = userName;
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName1;
	}
	


}
