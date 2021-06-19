package com.example.artsell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.artsell.domain.Account;
import com.example.artsell.domain.AuctionItem;
import com.example.artsell.service.AccountFormValidator;
import com.example.artsell.service.AccountValidator;
import com.example.artsell.service.ArtSellFacade;

@Controller
@SessionAttributes("userSession")
public class UserController {
	private ArtSellFacade artSell;

	@Autowired
	public void setArtSell(ArtSellFacade artSell) {
		this.artSell = artSell;
	}

	@Autowired
	private AccountValidator validator;

	public void setValidator(AccountValidator validator) {
		this.validator = validator;
	}

	@RequestMapping("/loginform")
	public String home(HttpServletRequest request) throws Exception {
		return "thyme/login";
	}

	@ModelAttribute("loginAccount")
	public Account formBackingObject(HttpServletRequest request)
			throws Exception {
		System.out.println("로그인 폼백킹.");
		return new Account();

	}

	@RequestMapping("/user/login")
	public ModelAndView login(HttpServletRequest request, @ModelAttribute("loginAccount") Account loginAccount, BindingResult result,
			@RequestParam(value = "loginForwardAction", required = false) String loginForwardAction, Model model)
			throws Exception {
		
		System.out.println("로그인메소드로 넘어옴" + loginAccount);
		validator.validate(loginAccount, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("thyme/login");

		} else {
			Account account = artSell.getAccount(loginAccount.getUserId());
			UserSession userSession = new UserSession(account);
			model.addAttribute("userSession", userSession);
			if (loginForwardAction != null) {
				return new ModelAndView("redirect:" + loginForwardAction);
			} else
				return new ModelAndView("redirect:/user/main"); // ny수정 redirect:/user/main
		}
	}

	@RequestMapping("/user/logout")
	public String logout(HttpSession session, SessionStatus sessionStatus) throws Exception { // ny수정
		session.removeAttribute("userSession");
		session.invalidate();
		sessionStatus.setComplete();
		// return "tiles/login"; // use Tiles
		return "redirect:/loginform"; // ny수정
	}

	@RequestMapping("/user/mypage")
	public String myPage(@ModelAttribute("userSession") UserSession userSession) throws Exception {
		// String userId = userSession.getAccount().getUserId();
		return "myPage";
	}

	// 2차수정
	@RequestMapping("/user/delete")
	public String deleteAccount(HttpSession session) throws Exception {
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		String userId = userSession.getAccount().getUserId();
		artSell.deleteAccount(userId);

		session.removeAttribute("userSession");
		session.invalidate();

		System.out.println("계정이 삭제되었습니다.");
		return "main";
	}

}