package com.my.ziapro.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CartItemVO {
	
    
	private List<ProductVO> cartItems;
    
    private int pnum;
    private String pname;
    private String imagePath;
    private int price;
    private int discount;
    private int stock;
    private LocalDate startDate;

    public CartItemVO(int pnum, int price, int discount, int stock, String pname, String imagePath, LocalDate startDate) {
        this.pnum = pnum;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.pname = pname;
        this.imagePath = imagePath;
        this.startDate = startDate;
        this.cartItems = new ArrayList<>(); 
    }


    public CartItemVO() {
		this.cartItems = new ArrayList<>();
	}
	
	
	public boolean add(ProductVO pro) {
		return cartItems.add(pro);
	}
	

	public List<ProductVO> getProducts() {
		return cartItems;
	}

	public void setcartItems(List<ProductVO> cartItems) {
		this.cartItems = cartItems;
	}

}
