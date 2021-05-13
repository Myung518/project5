package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class UserController {
	private ArtSellFacade artSell;
	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}

	@RequestMapping("/user/login")
	public ModelAndView login(HttpServletRequest request,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		Account account = artSell.getAccount(userId, password);
		if (account == null) {
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(account);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("tiles/main");	// use Tiles
		}
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) throws Exception {
		session.removeAttribute("userSession");
		session.invalidate();
		return "tiles/login";	// use Tiles
	}
	
	@RequestMapping("/user/mypage")
	public String myPage(@ModelAttribute("userSession") UserSession userSession) throws Exception {
		//String userId = userSession.getAccount().getUserId();
		return "tiles/mypage";
	}
	
	//AccountFormController에 있어야 할 것 같음
//	@Autowired
//	private AccountFormValidator validator;
//	public void setValidator(AccountFormValidator validator) {
//		this.validator = validator;
//	}
}