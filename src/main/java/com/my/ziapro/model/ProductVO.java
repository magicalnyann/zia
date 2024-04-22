package com.my.ziapro.model;

import java.time.LocalDate;
import lombok.Data;


@Data
public class ProductVO 
{
	private int pnum; 
    private String scode; 
    private String imagePath; 
    private String pname; 
    private int stock;
    private int categoryId;
    private int price; 
    private int discount; 
    private LocalDate startDate; 
	
   
	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", scode=" + scode + ", imagePath=" + imagePath + ", pname=" + pname
				+ ", stock=" + stock + ", categoryId=" + categoryId + ", price=" + price + ", discount=" + discount
				+ ", startDate=" + startDate + "]";
	}

    
}