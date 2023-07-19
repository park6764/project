package com.korea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.korea.k2.cart.CartService;
import com.korea.k2.cart.CartVO;
import com.korea.k2.cart.OrderJumunseoVO;
import com.korea.k2.cart.OrderMoneyVO;
import com.korea.k2.cart.OrderOneVO;


@Controller
public class CatrController {

	@Autowired
	private CartService  service;
	
	
	
    @RequestMapping("/orderList.do")
	String  orderList(  Model model  ) throws Exception { 
 
    	model.addAttribute("li",service.orderList());
    	
		return "/cart/orderList.jsp";		
	}
    
    @RequestMapping("/orderOne.do")
	String  orderOne(  Model model, OrderOneVO vo   ) throws Exception { 
 
    	model.addAttribute("li",service.orderOne(vo));
    	
		return "/cart/orderOne.jsp";		
	}
	  
	    
	
    @RequestMapping("/cartUpdate.do")
	String  cartUpdate(
			@RequestParam String[] cartId,
			@RequestParam String[] custNo,
			@RequestParam String[] productId,
			@RequestParam String[] amount    ) throws Exception { 
    	
    	String custNoStr ="";
    	for (int i=0 ; i < cartId.length ; i++) {    		
    	 CartVO vo = new 	CartVO();
    	   custNoStr  = custNo[i];
    	   vo.setCartId(Integer.parseInt(cartId[i]));
    	   vo.setAmount(Integer.parseInt(amount[i]));    	 
    	 service.update(vo);     	
    	}
    	return "redirect:/cartList.do?custNo="+custNoStr;	
    }
    	
    @RequestMapping("/cartOrder.do")
	String  cartOrder(
			@RequestParam String[] cartId,
			@RequestParam String[] custNo,
			@RequestParam String[] productId,
			@RequestParam String[] productName,
			@RequestParam String[] amount ,
			OrderMoneyVO mvo   ) throws Exception { 
    	
    	mvo.setOcustNo(Integer.parseInt(custNo[0]));
    	service.insertOrderMoney(mvo);
    	OrderMoneyVO vo = service.orderG(mvo);
    	
    	int custNoStr = 0;
    	OrderJumunseoVO  Ovo =null;
    	for (int i=0 ; i < cartId.length ; i++) {    		
    	   Ovo = new 	OrderJumunseoVO();
    	   custNoStr  = Integer.parseInt(custNo[i]);
    	   Ovo.setCustNo(Integer.parseInt(custNo[i]));
    	   Ovo.setCartId(Integer.parseInt(cartId[i]));
    	   Ovo.setProductId(Integer.parseInt(productId[i]));
    	   Ovo.setProductName(productName[i]);
    	   Ovo.setAmount(Integer.parseInt(amount[i]));
    	   Ovo.setOrderG(vo.getIdx());
    	   service.insertOrderJumunseo(Ovo);
    	   
    	} 
    	
    	//  장바구니 삭제하기 
    	CartVO cartVO = new CartVO();
    	cartVO.setCustNo(custNoStr);
    	service.deleteAll(cartVO);
    	
    	String custNoK = String.valueOf(custNoStr);
		return "redirect:/cartList.do?custNo="+custNoK;	
		
	}
    
	
	
    @RequestMapping("/cartInsert.do")
	String  cartInsert( CartVO vo  ) throws Exception { 
    	System.out.println("cartInsert:" + vo);
    	service.insert(vo);
		return "/cartList.do";		
	}
    
    @RequestMapping("/cartDeleteOne.do")
	String  cartDeleteOne( CartVO vo  ) throws Exception { 
    	service.deleteOne(vo);
		return "/cartList.do";		
	}
    
    @RequestMapping("/cartDeleteAll.do")
	String  cartDeleteAll( CartVO vo  ) throws Exception { 
    	service.deleteAll(vo);
		return "/cartList.do";		
	}
    
    
    @RequestMapping("/cartList.do")
	String  cartList( CartVO vo, Model model  ) throws Exception { 
 
    	model.addAttribute("li",service.selectAll(vo) );
    	
		return "/cart/cartList.jsp";		
	}
    
    
}
