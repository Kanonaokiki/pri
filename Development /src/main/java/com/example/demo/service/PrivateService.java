package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.PrivateEntity;
import com.example.demo.form.PrivateForm;
import com.example.demo.repository.PrivateRepository;

@Service
@Transactional
public class PrivateService {
	@Autowired
	PrivateRepository privateRepository;

	//  DBから全件取得
	public List<PrivateEntity> findAllByOrderIdAsc() {
		return privateRepository.findAllByOrderByIdAsc();
	}

	public PrivateEntity findById(Integer id) {
		return privateRepository.getOne(id);
	}

	public void insert(PrivateForm privateForm) {
		PrivateEntity privateEntity = new PrivateEntity();
		privateEntity.setId(privateForm.getId());
		privateEntity.setName(privateForm.getName());
		privateEntity.setBirthday(privateForm.getBirthday());
		privateEntity.setSex(privateForm.getSex());
		privateEntity.setBirthplace(privateForm.getBirthplace());
		// データベースに登録する
		privateRepository.save(privateEntity);
	}

	public void update(PrivateForm privateForm) {
		PrivateEntity privateEntity = new PrivateEntity();
		privateEntity.setId(privateForm.getId());
		privateEntity.setName(privateForm.getName());
		privateEntity.setBirthday(privateForm.getBirthday());
		privateEntity.setSex(privateForm.getSex());
		privateEntity.setBirthplace(privateForm.getBirthplace());
		privateRepository.save(privateEntity);
	}

	public void delete(Integer id) {
		PrivateEntity privateEntity = findById(id);
		privateRepository.delete(privateEntity);
	}
}
