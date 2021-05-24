package com.example.artsell.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Category;
import com.example.artsell.domain.Item;
import com.example.artsell.service.ArtSellFacade;

@Controller
public class SearchController {
	private ArtSellFacade artSell;
	
	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}
	
	@RequestMapping("/search/item")
	public ModelAndView handleRequest(HttpServletRequest request, @RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="artist", required=false) String artist, @RequestParam(value="categoryId", required=false) String categoryId,
			@RequestParam(value="page", required=false) String page, @RequestParam(value="job", required=false) String job) throws Exception
	{
		if ("화가명".equals(job)) {
			artist = keyword;
			keyword = null;
		} else if ("작품명".equals(job)){
			artist = "all";
		}
		
		ModelAndView mv;
		int total;
		if (keyword != null || artist != null) {
			if (!StringUtils.hasLength(keyword) && "all".equals(artist)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for or select artist, then press the search button.");
			}
			total = this.artSell.searchItemList(keyword, artist, categoryId).size();
			
			PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.artSell.searchItemList(keyword, artist, categoryId));
			System.out.println("keyword: " + keyword + " artist: " + artist + " categoryId: " + categoryId);
			
			itemList.setPageSize(10);
			request.getSession().setAttribute("SearchController_itemList", itemList);
			mv = new ModelAndView("searchResult", "itemList", itemList);
		} else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Item> itemList = (PagedListHolder<Item>)request.getSession().getAttribute("SearchController_itemList");
			if (itemList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				itemList.nextPage();
			} else if ("previous".equals(page)) {
				itemList.previousPage();
			}
			
			total = this.artSell.searchItemList(keyword, artist, categoryId).size();
			mv = new ModelAndView("searchResult", "itemList", itemList);
		}
		List<String> artistList = new ArrayList<String>(this.artSell.getArtistList());
		mv.addObject("artistList", artistList);
		mv.addObject("total", total);
		
		String categoryName = null;
		if (categoryId != null && !"".equals(categoryId)) {
			categoryName = this.artSell.getCategory(categoryId).getName();
		}
		mv.addObject("categoryName", categoryName);
		
		List<Category> categoryList = new ArrayList<Category>(this.artSell.getCategoryList());
		mv.addObject("categoryList", categoryList);
		
		return mv;
	}
}
