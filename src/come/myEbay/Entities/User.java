package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String addr;

	private String email;

	private String id;

	private String name;

	private String password;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	private int version;

	public User() {
	}

	public User(String username, String addr, String email, String id,
			String name, String password, String phoneNumber, int version) {

		this.username = username;
		this.addr = addr;
		this.email = email;
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.version = version;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}