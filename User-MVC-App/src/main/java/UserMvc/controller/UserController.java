package UserMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import UserMvc.dao.UserDao;
import UserMvc.model.User;

@Controller
public class UserController {
	// Dependency for UserDao
	@Autowired
	private UserDao dao;

	/*
	 * Request Mapping is used to handle web request & value is given ModelAndView
	 * are of 2 different class (Model, View) It has the information of both data &
	 * presentation of an application It is used to return both model & view in
	 * single return value
	 */
	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value = "/open-update")
	public ModelAndView openUpdate(ModelAndView modelAndView) {
		modelAndView.addObject("u", new User());
		modelAndView.setViewName("update");
		return modelAndView;
	}

	@RequestMapping(value = "open-view")
	public String openView(@RequestParam String view) {
		return view;
	}

	/*
	 * Methods for CRUD operations & validation is given ResponeBody is used where
	 * the methods return a value PostMapping is used to handle http Post request
	 * Further end points such as value is given accordingly
	 */

	@ResponseBody
	@PostMapping(value = "/save")
	public String saveUser(@ModelAttribute(name = "u") User user) {
		user = dao.saveUser(user);
		return "User saved with Id:" + user.getId();
	}

	@ResponseBody
	@PostMapping(value = "/update")
	public String UpdateUser(@ModelAttribute(name = "u") User user) {
		user = dao.updateUser(user);
		if (user != null)
			return "User  with Id:" + user.getId() + " is updated";
		return "Cannot Update User as Id is Invalid";
	}

	// Request Param is to bind the method parameters with web request parameter
	@PostMapping("verify-by-phone")
	public ModelAndView verifyUser(@RequestParam long phone, @RequestParam String password) {
		User u = dao.verifyUser(phone, password);
		ModelAndView modelAndView = new ModelAndView();
		if (u != null) {
			modelAndView.setViewName("print");
			modelAndView.addObject("u", u);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", "Invalid Phone Number or Password");
		return modelAndView;
	}

	@PostMapping("verify-by-id")
	public ModelAndView verifyUser(@RequestParam int id, @RequestParam String password) {
		User u = dao.verifyUser(id, password);
		ModelAndView modelAndView = new ModelAndView();
		if (u != null) {
			modelAndView.setViewName("print");
			modelAndView.addObject("u", u);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", "Invalid Id or Password");
		return modelAndView;
	}

	@PostMapping("verify-by-email")
	public ModelAndView verifyUser(@RequestParam String email, @RequestParam String password) {
		User u = dao.verifyUser(email, password);
		ModelAndView modelAndView = new ModelAndView();
		if (u != null) {
			modelAndView.setViewName("print");
			modelAndView.addObject("u", u);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", "Invalid Email Id or Password");
		return modelAndView;
	}

	@GetMapping("find-by-id")
	public ModelAndView findById(@RequestParam int id) {
		User u = dao.FindById(id);
		ModelAndView modelAndView = new ModelAndView();
		if (u != null) {
			modelAndView.setViewName("print");
			modelAndView.addObject("u", u);
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", "Invalid Id");
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id, ModelAndView modelAndView) {
		boolean deleted = dao.deleteUser(id);
		if (deleted) {
			modelAndView.setViewName("error");
			modelAndView.addObject("msg", "user deleted");
			return modelAndView;
		}
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", "cannot delete user as Id is Invalid");
		return modelAndView;
	}
}