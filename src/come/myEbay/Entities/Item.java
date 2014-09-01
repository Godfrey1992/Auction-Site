package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(name = "ITEM")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SELLER_ID")
	private String sellerId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "VERSION")
	private int version;

	public Item() {

	}

	public Item(String id, String sellerId, String title, String description,
			int version) {
		this.id = id;
		this.sellerId = sellerId;
		this.title = title;
		this.description = description;
		this.version = version;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}