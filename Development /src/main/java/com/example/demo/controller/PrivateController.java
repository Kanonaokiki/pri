package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.PrivateEntity;
import com.example.demo.form.PrivateForm;
import com.example.demo.service.PrivateService;

@Controller
public class PrivateController {
	@Autowired
	PrivateService privateService;

	@GetMapping("/private")
	public String top( Model model) {
		model.addAttribute("privateForm",new PrivateForm());
		return "/private";
	}

	@GetMapping("/privatelist")
	public String privateList( Model model) {
		// serviceを使って、申請の一覧をDBから取得する
		List<PrivateEntity> privatelist = privateService.findAllByOrderIdAsc();
		// modelに経費の一覧を設定して、画面に渡す
		model.addAttribute("privatelist", privatelist);
		return "/privatelist";
	}

	@PostMapping("/private")
	public String privateInsert(@Validated @ModelAttribute PrivateForm privateForm,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("expencesForm",privateForm);
			model.addAttribute("validationError", errorList);
			//	    			プルダウンの値を保持する
			return "/private";
		}
		privateService.insert(privateForm);
		//		     // 経費一覧画面にリダイレクト
		return "redirect:/privatelist";
	}

//	@PostMapping("/user/private/delete")
	  @GetMapping("/{id}")
	  public String delete(@PathVariable Integer id, Model model) {
	    // ユーザー情報の削除
	    privateService.delete(id);
	    return "redirect:/privatelist";
	  }
	public String delete(Integer id,PrivateForm privateForm, Model model) {
		// ユーザー情報の削除
		privateService.delete(id);
		return "redirect:/privatelist";
	}
}