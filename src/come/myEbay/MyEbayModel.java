package come.myEbay;

import come.myEbay.Entities.Auction;
import come.myEbay.Entities.AuctionItem;
import come.myEbay.Entities.Item;
import come.myEbay.Entities.ItemWatch;
import come.myEbay.Entities.User;
import come.myEbay.Entities.Watch;

public interface MyEbayModel {

	// Display all Items
    public Item[] getAllItems()
            throws MyEbayException; 
    
    // Insert an item
    public void InsertItem(Item item)
    		throws MyEbayException; 
    
    // user Login
    public User getUser(String username, String password) throws MyEbayException; 
    
    // Bid on an auction
    public void bidAuction(String id, String price) throws MyEbayException;
	
    // Returns all the auction items from the database
	public AuctionItem[] getAllAuction() throws MyEbayException;
		
	// Returns a specific item
	public Item[] getSearchItems(String s) throws MyEbayException;
	
	// Return a specific auction
	public AuctionItem[] getSearchAuctions(String s) throws MyEbayException;
	
	// Creates a new auction
	public void createAuction(Auction auction) throws MyEbayException;
	
	// Return a specific item
	public AuctionItem[] getItem(String s) throws MyEbayException;
	
	// Add an auction to the watch list
	public void createWatchListItem(Watch watch) throws MyEbayException; 
	 
	// Get all the watch list
	public ItemWatch[] getWatchList(String userId) throws MyEbayException;
	
	// Register a new user 
	public void registerUser(User user) throws MyEbayException;
}		

