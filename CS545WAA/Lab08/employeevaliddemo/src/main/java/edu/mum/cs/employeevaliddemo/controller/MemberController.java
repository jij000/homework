package edu.mum.cs.employeevaliddemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.employeevaliddemo.domain.Member;
import edu.mum.cs.employeevaliddemo.validator.MemberValidator;

@Controller
@RequestMapping("/member")
public class MemberController {

	// private Validator memberValidator;
	//
	// @Autowired
	// public MemberController(Validator memberValidator) {
	// this.memberValidator = memberValidator;
	// }

	@RequestMapping(value = { "", "member_input" }, method = RequestMethod.GET)
	public String inputEmployee(@ModelAttribute("member") Member member) {
		return "MemberForm";
	}

	@RequestMapping(value = { "", "member_input" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult,
			Model model) {

		// memberValidator.validate(member, bindingResult);

		if (bindingResult.hasErrors()) {
			return "MemberForm";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}

		// save product here
		model.addAttribute("member", member);

		return "MemberDetails";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// binder.setDisallowedFields(new String[]{"firstName"});
		binder.addValidators(new MemberValidator());

	}
}
