package com.javacodegeeks.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {


	@GetMapping(value = "/welcome")
	public String sayHello() {
		return "hello";
	}

	@GetMapping(value = "/intro")
	public ModelAndView sayNice() {
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return  m;
	}

	@GetMapping(value = "/home")
	public String giveInput(Model model) {
		model.addAttribute("message","PPA");
		return "home";
	}

	@GetMapping("/homepage")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}

	@PostMapping("/homepage")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		String reply1 = encryptMessage(greeting.getContent(), 3);
		String reply2 = decryptMessage(greeting.getEncryptedContent(), 3);
		greeting.setContentReply(reply1);
		greeting.setEncryptContentReply(reply2);
		model.addAttribute("greeting", greeting);
		return "result";
	}

	private String encryptMessage(String content, int key) {
		String ans = "";
		int l = content.length();
		for(int i=0;i<l;++i){
			char t = content.charAt(i);
			if(t<='9' && t>='0'){
				int new_char = ((t-'0') + key + 10)%10;
				char t_new = (char) ('0' + new_char);
				ans += t_new;
				continue;
			}

			int new_char = ((t - 'a') + key) % 26;
			char t_new = (char) ('A' + new_char);

			ans += t_new;
		}

		System.out.println(ans);
		return ans;
	}

	private String decryptMessage(String encryptedContent, int key){
		String ans = "";
		int l = encryptedContent.length();
		for(int i=0;i<l;++i){
			char t = encryptedContent.charAt(i);
			if(t<='9' && t>='0'){
				int new_char = ((t-'0') - key + 10)%10;
				char t_new = (char) ('0' + new_char);
				ans += t_new;
				continue;
			}

			int new_char = ((t - 'A') - key + 26) % 26;
			char t_new = (char) ('a' + new_char);

			ans += t_new;
		}

		return ans;
	}
}
