package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the AUCTION database table.
 * 
 */
@Entity
public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "CURRENT_PRICE")
	private String currentPrice;

	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "SELLER_ID")
	private String sellerId;

	@Column(name = "STARTING_BID")
	private String startingBid;

	private int version;

	public Auction() {
	}

	public Auction(String id, String itemId, String sellerId,
			String startingBid, String currentPrice, int version) {

		this.id = id;
		this.currentPrice = currentPrice;
		this.itemId = itemId;
		this.sellerId = sellerId;
		this.startingBid = startingBid;
		this.version = version;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getStartingBid() {
		return this.startingBid;
	}

	public void setStartingBid(String startingBid) {
		this.startingBid = startingBid;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}