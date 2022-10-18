package com.project;

public class Product {

	    private int productId;
		private String productName;
		private String productDescription;
		private int quantity;
		private double unitPrice;
		Product (int productId, String productName,String productDescription, int quantity, double unitPrice) {
			this.productId = productId;
			this.productName = productName;
			this.productDescription = productDescription;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}
		public String toString() {
			String s = "Product Name : " +this.productName;
			s = s + "\n"+"Product Id : "+this.productId+"\n"+ "Description: "+ this.productDescription + "\n"+ "Quantity : "+ this.quantity + "\n" + "Price : "+ this.unitPrice + "\n" + "...." ;
			return s;
		}
		public String getProductName() {
			return this.productName;
		}
		public int getQuantity() {
			return this.quantity;
		}
		public double getUnitPrice() {
			return this.unitPrice;
		}

	}


