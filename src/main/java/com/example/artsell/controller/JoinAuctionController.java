package com.example.artsell.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class JoinAuctionController {
   @Autowired
   private ArtSellFacade artSell;
   
   //입찰, 재입찰
   @RequestMapping("/auction/bid")
   public void addAuctionItem(@ModelAttribute("userSession") UserSession userSession, 
         @RequestParam("itemId") String itemId, 
         @RequestParam("price") int price) throws Exception {
	  
	  String userId = userSession.getAccount().getUserId();
      if (auctionItem.isNewUserPrice(userId, itemId)) { //헌값 수정!
            artSell.updatePrice(userId, itemId, price);
      }
      else {   //새로운 값
         artSell.addPrice(userId, itemId, price);
      }
      
      if (artSell.getBestPrice() < price) { //최고값이면
         artSell.updateItemBestPrice(price);
      }
      else {
         throw new Exception("error");
      }

   }
   
   //낙찰포기 //if 후순위자있을경우->후순위자상태바꿈   else 유찰 

   public String giveup(@ModelAttribute("userSession") UserSession userSession, 
            @RequestParam("itemId") String itemId, ModelMap model) {

      String userId = userSession.getAccount().getUserId();
   
      //auctionitem table에서 해당 아이디 / 아이템아이디의 행 삭제
      Artsell.deleteAuctionItem(userId, itemId);
   
   
      //AuctionedItem auctionedItem = artSell.getOrder(itemid); //해당 아이템가져와
   
      List<AuctionItem> auctionBuyerList = artsell.getBuyersByItemId(itemid);
   
   
      if (Artsell.countAuctionJoinList != 0) // 후순위자가 있다면
      {//낙찰
         AuctionItem secondAuctionitem = auctionBuyerList.get(0);
         String secondUser = secondAuctionitem.getUserId();
         String secondPrice = secondAuctionitem.getMyPrice();
         
         Artsell.updateItem(secondUser, secondPrice);
   
         return "auction/list/";
   
      }
      else{
         return "auction/fail";
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
      int minPrice= artSell.getItemPrice(minPrice);
      minPrice = (int) (minPrice * 0.7);

      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

      cal.add(Calendar.DATE, 7);
      Date deadline = df.parse(df.format(cal.getTime()));
      ModelAndView model = new ModelAndView("myPainting_bidding");
      model.addObject("minPrice", minPrice);
      model.addObject("deadline", deadline);
      return model;

   }
   
   @RequestMapping("/auction/fail/ok")
    public String Reupload(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId, 
          @RequestParam("minPrice") String minPrice, @RequestParam("deadline") String deadline, RedirectAttributes redirectAttributes) {

      artSell.updateReload(itemId, minPrice, deadline);
      redirectAttributes.addAttribute("itemId", itemId);
      
      return "redirect:/shop/viewItem";
}

   //유찰 안하겠다고 했을때
   @RequestMapping("/auction/fail/no")
    public String Reupload(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") String itemId) {
      artSell.deleteItem(itemId);
      return "/home";
   }

}