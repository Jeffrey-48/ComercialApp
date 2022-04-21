package com.uniquindio.comercial_app.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
public class Client {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID")
	private Integer id;
	@Column(name = "CLIENT_USER")
	private String user;
	@Column(name = "CLIENT_PASSWORD")
	private String password;
	@Column(name = "CLIENT_NAME")
	private String name;
	@Column(name = "CLIENT_MAIL")
	private String email;
	@Column(name = "CLIENT_ADDRESS")
	private String address;
	@Column(name = "CLIENT_CELL_PHONE_NUMBER")
	private String cellPhoneNumber;
	@OneToMany
	private List<ShoppingCart> shoppingCarts;
	@Column(name = "CLIENT_AMOUNT")
	private Double amount;
	
	public Client(Integer id, String user, String password, String name, String email, String address,
			String cellPhoneNumber, List<ShoppingCart> shoppingCarts, Double amount) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.cellPhoneNumber = cellPhoneNumber;
		this.shoppingCarts = shoppingCarts;
		this.amount = amount;
	}
	
	public Client() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
