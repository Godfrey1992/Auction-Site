package come.myEbay.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the AUCTION database table.
 * 
 */
@Entity
@Table(name = "AUCTION")
public class AuctionItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "CURRENT_PRICE")
	private String currentPrice;

	@Column(name = "SELLER_ID")
	private String sellerId;

	@Column(name = "STARTING_BID")
	private String startingBid;

	private int version;

	// bi-directional one-to-one association to Item
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	public AuctionItem() {
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}