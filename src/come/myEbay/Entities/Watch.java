package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the WATCH database table.
 * 
 */
@Entity
public class Watch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "AUCTION_ID")
	private String auctionId;

	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "USER_ID")
	private String userId;

	public Watch() {
	}

	public Watch(String id, String auctionId, String itemId, String userId) {

		this.id = id;
		this.auctionId = auctionId;
		this.itemId = itemId;
		this.userId = userId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuctionId() {
		return this.auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}