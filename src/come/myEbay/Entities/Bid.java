package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the BID database table.
 * 
 */
@Entity
public class Bid implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "CURRENT_PRICE")
	private String currentPrice;

	@Column(name = "HIGHEST_BIDDER")
	private String highestBidder;
	@Id
	private String id;

	@Column(name = "ITEM_ID")
	private String itemId;

	public Bid() {
	}

	public String getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getHighestBidder() {
		return this.highestBidder;
	}

	public void setHighestBidder(String highestBidder) {
		this.highestBidder = highestBidder;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}