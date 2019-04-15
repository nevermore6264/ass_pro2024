package DuAn2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/home")
	public String home(ModelMap model) {
		
		
		model.addAttribute("titlepage", "Trang chủ");
		return "home";
	}
}
