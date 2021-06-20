package com.example.artsell.dao.mybatis.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.artsell.domain.AuctionItem;
import com.example.artsell.domain.Order;

@Mapper
public interface OrderMapper {
	Order getOrder (String itemId, String userId) throws DataAccessException;
	//AuctionItem getAuctionItem(String itemId, String userId);
//	void editDestination (Order order, String des) throws DataAccessException;
	void SaveAuctionedItem (String itemId, int myPrice, String userId, String address1, String address2, Date sellDate)throws DataAccessException;
	void updateAuctionedState(String itemId, String userId) throws DataAccessException;
}
