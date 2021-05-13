package com.example.artsell.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class JoinAuctionController {
	@Autowired
	private ArtSellFacade artSell;
	
	//입찰, 재입찰
	@RequestMapping("/auction/bid")
	private void addAuctionItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("ItemId") String workingItemId, 
			@RequestParam("price") int price) throws Exception {
		if (auctionItem.isNewUserPrice(userSession.getAccount().getUserId(), ItemId)) { //헌값 수정!
				artSell.updatePrice(userId, itemId, price);
		}
		else {	//새로운 값
			artSell.addPrice(userId, itemId, price);
		}
	}
	
	// 아이템아이디에 해당하는 경매참여자들
	@RequestMapping("/auction/info")
	public String viewAutionJoinerList(@RequestParam("ItemId") String itemId, ModelMap model) {	
		Map<String, Integer> buyers = this.artSell.getBuyersByItemId(itemId);
		model.put("buyers", buyers);
		return "auction/myAuctionList";
	}

	//유찰
	@RequestMapping("/auction/fail")
    public ModelAndView miscarry(@ModelAttribute("userSession") UserSession userSession, 
	@RequestParam("itemId") String itemId) {
    	String userId = userSession.getAccount().getUserId();
		int price = artSell.getItemPrice(itemId);
		price = price*0.7;

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		cal.add(Calendar.DATE, 7);
		Date deadline = df.format(cal.getTime());
		ModelAndView model = new ModelAndView(myPainting_bidding);
		model.addObject("price", price);
		model.addObject("deadline", deadline);
		return model;
	}

	
}
