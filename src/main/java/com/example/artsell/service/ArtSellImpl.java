package com.example.artsell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.artsell.dao.AccountDao;
import com.example.artsell.dao.CategoryDao;
import com.example.artsell.dao.ItemDao;
import com.example.artsell.domain.Account;
import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.jpetstore.domain.Order;

@Service
@Transactional
public class ArtSellImpl implements ArtSellFacade {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(String userId, String password) {
		// TODO Auto-generated method stub
		return accountDao.getAccount(userId, password);
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> getUsernameList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(categoryId);
	}

	/*
	 * @Override public List<Item> searchItemList(String keywords, String
	 * categoryId) { if (categoryId != null) {
	 * itemDao.searchItemListByKewordInCate(keywords, categoryId); } else {
	 * itemDao.searchItemListByKeword(keywords); } }
	 * 
	 * @Override public List<Item> searchItemListByArtist(String keywords, String
	 * artist, String categoryId) { // TODO Auto-generated method stub if
	 * (categoryId != null) { if (keywords != null) {
	 * itemDao.searchItemListByAllInCate(keywords, artist, categoryId); } else {
	 * itemDao.searchItemListByArtistInCate(artist, categoryId); } } else { if
	 * (keywords != null) { itemDao.searchItemListByArtist(artist); } else {
	 * itemDao.searchItemListByAll(keywords, artist); } } }
	 */

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
	public boolean isItemInStock(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Item> searchItemList(String keywords, String artist, String categoryId) {
		// TODO Auto-generated method stub
		return itemDao.searchItemList(keywords, artist, categoryId);
	}

}
