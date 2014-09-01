/**
* Class written by: Godfrey Oguike id: 10051389
* This class stores all the functions needed to make the auction site function.
* e.g to make a bid a call to the MyEbayModelImpl will need to be made.
* this is a singleton bean meaning only one instance of the class will be created
* no matter how many users connect the web site. most of the other classes will make
* a call to this one using the interface class MyEbayModel.
*/

package come.myEbay;

import java.util.*;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.*;
import come.myEbay.Entities.Auction;
import come.myEbay.Entities.AuctionItem;
import come.myEbay.Entities.Item;
import come.myEbay.Entities.ItemWatch;
import come.myEbay.Entities.User;
import come.myEbay.Entities.Watch;

@Local
@Singleton
public class MyEbayModelImpl implements MyEbayModel {

	@PersistenceContext
	private EntityManager emgr;

	public MyEbayModelImpl() {

	}

	// Return all items from the ITEM table
	@SuppressWarnings("unchecked")
	public Item[] getAllItems() throws MyEbayException {

		Query query = emgr.createNativeQuery("SELECT * FROM ITEM", Item.class);
		List<Item> items = new ArrayList<Item>();
		items = (List<Item>) query.getResultList();
		return items.toArray(new Item[0]);
	}

	// Insert a new item object into the ITEM table
	@Override
	public void InsertItem(Item item) throws MyEbayException {
		try {
			emgr.persist(item);
		} catch (EntityExistsException ex) {
			throw new MyEbayException("Error");
		}
	}

	// Find a partical user in the USER table
	@Override
	public User getUser(String username, String password)
			throws MyEbayException {

		User user = emgr.find(User.class, username);
		if (user != null) {
			return user;
		} else {
			throw new MyEbayException("");
		}
	}

	// Bid on an auction
	@Override
	public void bidAuction(String id, String price) throws MyEbayException {
		Auction auction = emgr.find(Auction.class, id);

		String cPrice = auction.getCurrentPrice();
		int originalPrice = Integer.parseInt(cPrice.trim());

		int newPrice = Integer.parseInt((price).trim());

		if (originalPrice < newPrice) {
			try {
				auction.setCurrentPrice(price);
				emgr.merge(auction);
				System.out.println("YESSSS");

			} catch (Exception e) {
				System.out.println("ERRRRORRR");
			}
		}
	}

	// Return a particle item from the ITEM table depending on user search string
	@Override
	@SuppressWarnings("unchecked")
	public Item[] getSearchItems(String s) throws MyEbayException {
		String word = s.trim();
		Query query = emgr.createNativeQuery(
				"SELECT * FROM APP.ITEM WHERE TITLE = '" + word + "'",
				Item.class);

		List<Item> items = new ArrayList<Item>();
		items = (List<Item>) query.getResultList();
		return items.toArray(new Item[0]);
	}

	// Return all the rows in the AUCTION table
	@SuppressWarnings("unchecked")
	@Override
	public AuctionItem[] getAllAuction() throws MyEbayException {

		Query query = emgr
				.createNativeQuery(
						"SELECT * FROM APP.AUCTION JOIN APP.ITEM ON APP.AUCTION.ITEM_ID = APP.ITEM.ID",
						AuctionItem.class);
		List<AuctionItem> auctionItem = new ArrayList<AuctionItem>();
		auctionItem = (List<AuctionItem>) query.getResultList();
		if (auctionItem.size() > 0) {
			System.out.println("YESSS");
			return auctionItem.toArray(new AuctionItem[0]);
		} else {
			System.out.println("NULL RETURNED");
			return null;
		}
	}

	// Return a particle auction specified by the user
	@SuppressWarnings("unchecked")
	@Override
	public AuctionItem[] getSearchAuctions(String s) throws MyEbayException {
		String word = s.trim().toUpperCase();

		Query query = emgr
				.createNativeQuery(
						"SELECT * FROM APP.AUCTION JOIN APP.ITEM ON APP.AUCTION.ITEM_ID = APP.ITEM.ID WHERE APP.ITEM.TITLE LIKE '%"
								+ word + "%'", AuctionItem.class);

		List<AuctionItem> auctionItem = new ArrayList<AuctionItem>();
		auctionItem = (List<AuctionItem>) query.getResultList();
		return auctionItem.toArray(new AuctionItem[0]);
	}

	// Create a new auction by inserting a new Auction object into the database
	@Override
	public void createAuction(Auction auction) throws MyEbayException {
		
		try {
			emgr.persist(auction);
		} catch (EntityExistsException e) {
			throw new MyEbayException("ERROR");
		}
	}
	
	// Get a specific item from the ITEM table
	@SuppressWarnings("unchecked")
	@Override
	public AuctionItem[] getItem(String s) throws MyEbayException {
		// TODO Auto-generated method stub
		String id = s.trim().toUpperCase();
		Query query = emgr
				.createNativeQuery(
						"SELECT * FROM APP.AUCTION JOIN APP.ITEM ON APP.AUCTION.ITEM_ID = APP.ITEM.ID WHERE APP.ITEM.ID = '"
								+ id + "'", AuctionItem.class);

		List<AuctionItem> auctionItem = new ArrayList<AuctionItem>();
		auctionItem = (List<AuctionItem>) query.getResultList();
		return auctionItem.toArray(new AuctionItem[0]);
	}

	// Add new item to the watch list
	@Override
	public void createWatchListItem(Watch watch) throws MyEbayException {
		try {
			emgr.persist(watch);
		} catch (EntityExistsException ex) {
			throw new MyEbayException("Error");
		}
	}

	// Get all items in the WATCH table
	@SuppressWarnings("unchecked")
	@Override
	public ItemWatch[] getWatchList(String userId) throws MyEbayException {
		String word = userId.trim().toUpperCase();

		Query query = emgr
				.createNativeQuery(
						"SELECT * FROM APP.WATCH JOIN APP.ITEM ON APP.WATCH.ITEM_ID = APP.ITEM.ID WHERE APP.WATCH.USER_ID = '"
								+ word + "'", ItemWatch.class);

		List<ItemWatch> itemWatch = new ArrayList<ItemWatch>();
		itemWatch = (List<ItemWatch>) query.getResultList();
		System.out.println("GENERATED ITEM");
		return itemWatch.toArray(new ItemWatch[0]);
	}

	// Register a new user
	@Override
	public void registerUser(User user) throws MyEbayException {
		try {
			emgr.persist(user);
		} catch (EntityExistsException ex) {
			throw new MyEbayException("Error");
		}
	}
}
