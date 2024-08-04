package com.example.java6.Entity.store;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.*;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	@NotBlank(message = "Username không được để trống")
	@Size(min = 4, max = 20, message = "Username phải có từ 4 đến 20 ký tự")
	private String username;

	@NotBlank(message = "Password không được để trống")
	@Size(min = 3, message = "Password phải có từ 3 ký tự")
	private String password;

	@NotBlank(message = "Họ tên không được để trống")
	@Size(max = 100, message = "Họ tên không được dài hơn 100 ký tự")
	private String fullname;

	@Email(message = "Email không hợp lệ")
	private String email;

	@NotBlank(message = "Ảnh không được để trống")
	private String photo;

	@JsonIgnore
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	List<Order> orders;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
}
