package com.springboot.web.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.modal.Userinfo;
import com.springboot.web.repository.UserInfoRepository;

import jakarta.validation.Valid;

@Service
public class UserItemServiceImpl {

	@Autowired

	private UserInfoRepository repo;

	public List<Userinfo> findAllValues() throws Exception {

		List<Userinfo> logList = repo.findAll();

		if (logList.isEmpty()) {

			throw new Exception("User not found");

		}

		return logList;

	}

	public Userinfo findOne(Long id) throws Exception {

		Optional<Userinfo> log = repo.findById(id);

		try {

			Userinfo login = log.get();

			return login;

		} catch (Exception e) {

			throw new Exception("Id:" + id + " does not exists");

		}

	}

	public Userinfo save(@Valid Userinfo ob) throws Exception {

		if (ob.getId() == null) { // it's mean user id not provided so create new user in

			List<Userinfo> logList = findAllValues(); // taking all list values

			for (Userinfo i : logList) {

				if (i.getEmail().equals(ob.getEmail())) {

					throw new Exception("user already registered"); // it mean user already registered

				}

			}

			ob.setRole("User");

			Userinfo log = repo.save(ob);

			return log;

		} else { // it's mean user id provided

			Long id = ob.getId();

			findOne(id); // checking valid id

			return repo.save(ob);

		}

	}

	public String delete(Long idd) throws Exception {
		try {
			repo.findById(idd).get();
			repo.deleteById(idd);
			return "Record removed Successfully";
		} catch (Exception e) {
			throw new Exception("Id:" + idd + " does not exists");
		}
	}

	public Userinfo update(Userinfo ob) throws Exception {
		Long id = ob.getId();
		findOne(id); // checking valid id
		ob.setRole("User");
		return repo.save(ob);
	}

	public Userinfo logIn(@Valid String email, @Valid String pass) throws Exception {

		List<Userinfo> logList = findAllValues(); // taking all list values

		for (Userinfo i : logList) {

			if (i.getEmail().equals(email) && i.getPassword().equals(pass)) {

				return i;

			}

		}

		throw new Exception("Either passowrd or email is incorrect");

	}

}
