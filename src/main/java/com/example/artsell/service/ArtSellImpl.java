package com.example.artsell.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.AuctionItemDao;
import com.example.artsell.dao.CategoryDao;
import com.example.artsell.dao.InterestingItemDao;
import com.example.artsell.dao.ItemDao;
import com.example.artsell.dao.OrderDao;
import com.example.artsell.domain.Account;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.domain.Order;

@Service
@Transactional
public class ArtSellImpl implements ArtSellFacade {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private InterestingItemDao interestingItemDao;
	@Autowired
	private AuctionItemDao auctionItemDao;
	@Autowired
	private OrderDao orderDao;

	//ny수정
	@Override
	public Account getAccount(String userId, String password) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(userId, password);
	}
	
	@Override
	public Account getAccount(String userId) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(userId);
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.updateAccount(account);
	}

	@Override
	public List<String> getUsernameList() {
		// TODO Auto-generated method stub
		return accountDao.getUsernameList();
	}
	
	@Override
	public void deleteAccount(String userId) {
		accountDao.deleteAccount(userId);
	}
	
	@Override
	public List<Account> viewAccountList() {
		return accountDao.viewAccountList();
	} 
	//-- ny수정.

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryList();
	}

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(categoryId);
	}

	@Override
	public List<Item> getItemListByProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(String itemId) {
		// TODO Auto-generated method stub
		return itemDao.getItem(itemId);
	}
	
	@Override
	public void insertItem(ItemForm item) {
		itemDao.insertItem(item);
	}
	
	@Override
	public void deleteItem(String userId, String itemId) {
		itemDao.deleteItem(userId, itemId);
	}
	
	public List<Item> getMyItemList(String userId) {
		return itemDao.getMyItemList(userId);
	}

	@Override
	public boolean isItemInStock(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrder(String itemId, String userId) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(itemId, userId);
	}
	
	@Override
	public void SaveAuctionedItem(Order order) {
		orderDao.SaveAuctionedItem(order);
	}

	@Override
	public List<Order> getOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getItemListByCategory(String categoryId) {
		// TODO Auto-generated method stub
		return itemDao.getItemListByCategory(categoryId);
	}

	@Override
	public List<String> getArtistList() {
		// TODO Auto-generated method stub
		return itemDao.getArtistList();
	}
	
	@Override
	public List<Item> getInterestingItemList(String userId) {
		return interestingItemDao.getInterestingItemList(userId);
	}
	
	@Override
	public void insertInterestingItem(String userId, String itemId) {
		interestingItemDao.insertInterestingItem(userId, itemId);
	}
	
	@Override
	public void deleteInterestingItem(String userId, String itemId) {
		interestingItemDao.deleteInterestingItem(userId, itemId);
	}
	
	@Override
	public int containsInterestingItem(String userId, String itemId) {
		return interestingItemDao.containsInterestingItem(userId, itemId);
	}

	@Override
	public List<Item> searchItemList(String keywords, String artist, String categoryId) {
		// TODO Auto-generated method stub
		return itemDao.searchItemList(keywords, artist, categoryId);
	}
	
	@Override
	public int isAuctioning(String itemId) {
		return itemDao.isAuctioning(itemId);
	}

	@Override
	public Map<String, Integer> getBuyersByItemId(String itemId) {
		// TODO Auto-generated method stub
		return auctionItemDao.getBuyersByItemId(itemId);
	}
	
	public void updatePrice(String userId, String itemId, int price) {
		auctionItemDao.updatePrice(userId, itemId, price);
	}

}
