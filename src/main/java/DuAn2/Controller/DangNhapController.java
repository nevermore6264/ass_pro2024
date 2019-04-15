package DuAn2.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import DuAn2.Model.ChucVu;
import DuAn2.Model.TaiKhoan;
import DuAn2.Services.DangNhapService;
import DuAn2.Services.ITaikhoanServices;

@Controller
@Transactional
public class DangNhapController {

	@Autowired
	ITaikhoanServices dangnhapservice;

	int checklogin=0;

	@RequestMapping("/dangnhap")
	public String login(ModelMap model) {
if(checklogin==1) {
	model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng");
	checklogin=0;
}
		// TODO Auto-generated method stub
		return "login";
	}

	@RequestMapping("/actionlogin")
	public String actiondangnhap(ModelMap model, HttpServletRequest httpServletRequest,HttpServletResponse response,@RequestParam("tendangnhap")String tendangnhap,@RequestParam("matkhau")String matkhau) {


		
		List<TaiKhoan> l = dangnhapservice.findUser(tendangnhap, matkhau);

		if (l.isEmpty()) {
			checklogin = 1;
			
			
			
			return "redirect:/dangnhap";
		} else {
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("nguoidung", tendangnhap);
			session.setAttribute("chucvu", l.get(0).getChucVu().getMaChucVu()+"");// 1 giam doc 2 nhan vien
			
			
			return "redirect:/dptp";
		}

	}
	
	@RequestMapping("/dangxuat")
	public String dangxuat(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		session.invalidate();
		return "redirect:/dangnhap";
	}
	
	@RequestMapping("/doimatkhau")
	public String doimatkhau(HttpServletRequest httpServletRequest,ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
		HttpSession session = httpServletRequest.getSession();
		TaiKhoan gettaikhoan = dangnhapservice.findById(session.getAttribute("nguoidung").toString()).get();
		model.addAttribute("gettaikhoan", gettaikhoan);
		
			return "doimatkhau";
		}
		
		@RequestMapping("/actiondoimatkhau")
		public String actiondoimatkhau(HttpServletRequest httpServletRequest,ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
			String matkhaucu = httpServletRequest.getParameter("matkhaucu");
			String matkhaumoi = httpServletRequest.getParameter("matkhaumoi");
			
			model.addAttribute("titlepage", "Đổi mật khẩu");
			
			HttpSession session = httpServletRequest.getSession();
			TaiKhoan gettaikhoan = dangnhapservice.findById(session.getAttribute("nguoidung").toString()).get();
			
			
			if(!matkhaucu.equals(gettaikhoan.getMatKhau())) {
				model.addAttribute("messageloi", "Mật khẩu cũ không chính xác");
				taikhoan.setMatKhau("");
				return "doimatkhau";
			}else if(!matkhaumoi.equals(taikhoan.getMatKhau())) {
				model.addAttribute("messageloi", "Xác nhận lại mật khẩu mới không chính xác");
				taikhoan.setMatKhau("");
				return "doimatkhau";
			}else if (matkhaumoi.length()<9) {
				taikhoan.setMatKhau("");
				model.addAttribute("messageloi", "Mật khẩu phải từ 8 kí tự trở lên");
				return "doimatkhau";
			}else {
				
			
			
				dangnhapservice.save(taikhoan);
				model.addAttribute("message", "Đổi mật khẩu thành công");
				taikhoan.setMatKhau("");
				return "doimatkhau";
				
				}
				
				
			}
		
	
		
	}


