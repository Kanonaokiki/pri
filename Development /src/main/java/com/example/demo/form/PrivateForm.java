package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PrivateForm {
	@NotNull(message = "IDを入力してください")
	private Integer id;

	@NotEmpty(message = "名前を入力してください")
	private String name;

	@NotNull(message = "誕生日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
//
	@NotEmpty(message = "性別を入力してください")
	private String sex;

	@NotEmpty(message = "出身地を入力してください")
	private String birthplace;
}
