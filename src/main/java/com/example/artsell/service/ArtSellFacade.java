package com.example.artsell.service;

import java.util.List;


import com.example.artsell.domain.Account;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.jpetstore.domain.Order;


public interface ArtSellFacade {
	
	//--ny id로 수정.
	Account getAccount(String userId);

	Account getAccount(String userId, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);
	
	void deleteAccount(String userId);

	List<String> getUsernameList();
	
	List<Account> viewAccountList();
	//--ny


	List<Category> getCategoryList();

	Category getCategory(String categoryId);

	List<Item> searchItemList(String keywords, String categoryId);
	
	List<Item> searchItemListByArtist(String keywords, String artist, String categoryId);

	List<Item> getItemListByProduct(String productId);

	Item getItem(String itemId);

	boolean isItemInStock(String itemId);


	void insertOrder(Order order);

	Order getOrder(int orderId);

	List<Order> getOrdersByUsername(String username);
	
	List<Item> getItemListByCategory(String categoryId);
	
	List<String> getArtistList();
	
	List<Item> getInterestingItemList(String userId);
	
	void insertInterestingItem(String userId, String itemId);
	
	void deleteInterestingItem(String userId, String itemId);
	
	int containsInterestingItem(String userId, String itemId);
	
}