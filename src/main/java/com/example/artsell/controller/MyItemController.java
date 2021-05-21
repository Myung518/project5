package com.example.artsell.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.domain.ItemForm;
import com.example.artsell.service.ArtSellFacade;
import com.example.artsell.service.PaintRegiValidator;


@Controller
@SessionAttributes("userSession")
public class MyItemController {
	
	@Autowired
	private ArtSellFacade artSell;
	
	@ModelAttribute("cateList")
	public List<Category> kinds() {
		List<Category> cateList = artSell.getCategoryList();
//		List<String> cateNameList = new ArrayList<String>();
//		for(Category c : cateList)
//			cateNameList.add(c.getName());
		return cateList;
	}
	
	@ModelAttribute("item")
	public ItemForm create() {
		return new ItemForm();
	}
	
	@RequestMapping("/myitem/list")
	public ModelAndView ViewMyItemList(@RequestParam(value = "page", required = false) String page,
			@ModelAttribute("userSession") UserSession userSession) throws Exception {

		PagedListHolder<Item> itemList = new PagedListHolder<Item>(
				this.artSell.getMyItemList(userSession.getAccount().getUserId()));
		itemList.setPageSize(5);
		//handleRequest(page, itemList);

		return new ModelAndView("myPaintingList", "mypaintList", itemList.getPageList());
	}
	
	@PostMapping("/myitem/add")
	public String addMyItem(@Valid @ModelAttribute("item") ItemForm item, Errors result,
			@ModelAttribute("userSession") UserSession userSession) {
		System.out.println(item.getBestPrice());
		new PaintRegiValidator().validate(item, result); 
		if (result.hasErrors()) {
//			System.out.println("a");
			return "paintingRegister";
		}
//		System.out.println("b");
		item.setUserId(userSession.getAccount().getUserId());
		artSell.insertItem(item);	
		return "redirect:/myitem/list";
	}
	
	@GetMapping("/myitem/add")
	public String goEnterPaintPage() {
		
		return "paintingRegister";
	}
	
	@RequestMapping("/myitem/delete")
	public String deleteMyItem(@ModelAttribute("userSession") UserSession userSession, 
			@RequestParam("myItemId") String itemId) {
		String userId = userSession.getAccount().getUserId();
		artSell.deleteItem(userId, itemId);

		return "redirect:/myitem/list";
	}
	
	@RequestMapping("/myitem/list2")
	private void handleRequest2(
		@RequestParam("page") String page, 
		@ModelAttribute("myList") PagedListHolder<Item> itemList,
		BindingResult result) throws Exception {

		if ("next".equals(page)) {
			itemList.nextPage();
		} else if ("previous".equals(page)) {
			itemList.previousPage();
		} 

	}
}
