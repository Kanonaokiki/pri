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

//	@PostMapping("/private")
//	public String top2( Model model) {
//		model.addAttribute("privateForm",new PrivateForm());
//		return "/privatelist";
//	}

//	@PostMapping("/edit/update")
//	public String edit( Model model) {
//		model.addAttribute("privateForm",new PrivateForm());
//		return "/update";
//	}

	@PostMapping("/back")
	public String edit2( Model model) {
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
	/**
	 * 経費申請登録
	 * @param expencesForm リクエストデータ
	 * @param model Model
	 * @return 経費一覧画面
	 */
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

//	@PostMapping("/update")
//	public String update(@Validated @ModelAttribute PrivateForm privateForm, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("privateForm", privateForm);
//			model.addAttribute("validationError", errorList);
//			return "/update";
//		}
//		// ユーザー情報の更新
//		privateService.update(privateForm);
//		model.addAttribute("privateForm",privateForm);
//		return "redirect:/privatelist";
//	}
}