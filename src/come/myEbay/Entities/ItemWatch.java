package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ITEM database table.
 * 
 */
@Entity
@Table(name = "WATCH")
public class ItemWatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "AUCTION_ID")
	private String auctionId;

	@Column(name = "USER_ID")
	private String userId;

	// bi-directional one-to-one association to Watch
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	public ItemWatch() {

	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}