package DuAn2.Controller;




import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.ChucVu;
import DuAn2.Model.DichVu;
import DuAn2.Model.TaiKhoan;
import DuAn2.Services.IChucvuSercives;
import DuAn2.Services.ITaikhoanServices;

@Controller
@Transactional
public class TaikhoanController {
	@Autowired
	ITaikhoanServices iTaikhoanServices;
	IChucvuSercives iChucvuSercives;
	private List<String> listcv = null;
	private List<ChucVu> getlcv =null;
	
	@RequestMapping("/qltk")
	public String listtk(ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
		List<TaiKhoan> ltk= (List<TaiKhoan>) iTaikhoanServices.findAll();// lấy list
		activemenu(model);
		vitrihientai = 1;
		
model.addAttribute("titlepage", "Danh sách tài khoản"); // tiêu đề cho trang
		model.addAttribute("lTaikhoans", phantrangtk(vitrihientai,ltk)); //hiện danh sách đã phân trang 10 item 1 trang
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(ltk,model));// số lượng các button chọn trang
		return "qltk"; //Tên trang index
	}
	
	
	@RequestMapping("/addtk")
	public String addtk(ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
		model.addAttribute("chamshowcd",".show");
		//show quan ly tai khoan
	model.addAttribute("chamshowqltk",".show");
	model.addAttribute("activedstk",null);
	model.addAttribute("activettk","active");
		
		
		
		model.addAttribute("titlepage", "Thêm mới tài khoản");
		return "addtk"; //Tên trang index
	}
	
	@RequestMapping("/actionaddtk")
	public String actionaddtk(ModelMap model,@Validated @ModelAttribute("taikhoan")TaiKhoan taikhoan,BindingResult errors) {
		model.addAttribute("chamshowcd",".show");
		//show quan ly tai khoan
	model.addAttribute("chamshowqltk",".show");
	model.addAttribute("activedstk",null);
	model.addAttribute("activettk","active");
		String a=null;
		try {
			a=iTaikhoanServices.findById(taikhoan.getTenDangNhap()).get().getTenDangNhap();
		}catch (Exception e) {
			a="null";
		}
		if(errors.hasErrors()) {
			model.addAttribute("titlepage", "Thêm mới tài khoản");
			model.addAttribute("errors", errors.getAllErrors());
			return "addtk";
		}else if(a.equals(taikhoan.getTenDangNhap())) {
			model.addAttribute("titlepage", "Thêm mới tài khoản");
			
			model.addAttribute("errortk", "- Tên đăng nhập đã tồn tại");
			return "addtk";
		}
		
		
		else{
			model.addAttribute("taikhoan", new TaiKhoan());
			model.addAttribute("message", " Thêm thành công");
			model.addAttribute("titlepage", "Thêm mới tài khoản");
			iTaikhoanServices.save(taikhoan);// nếu trùng id thì không thêm mà thành sửa.
			
			return "addtk"; //Thêm xong chạy lại trang hiển thị book
		}
		
	}
	
	
	
	
	@RequestMapping("/edittk")
	public String edittk(ModelMap model,@Validated @ModelAttribute("taikhoan")TaiKhoan taikhoan,BindingResult errors) {
		activemenu(model);
		if(errors.hasErrors()) {
			
			model.addAttribute("errors", errors.getAllErrors());
			return listtk(model,taikhoan);
		}else {
			model.addAttribute("message","Đã sửa thành công");
		iTaikhoanServices.save(taikhoan);// nếu trùng id thì không thêm mà thành sửa.
		return listtk(model,taikhoan); //sửa xong chạy lại trang hiển thị book
		}
	}
	
	
	
	@RequestMapping("/delete")
	public String delete(ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan,@RequestParam("tenDangNhap")String tenDangNhap) {
		activemenu(model);
		model.addAttribute("titlepage", "Danh sách tài khoản");
		
		taikhoan.setTenDangNhap(tenDangNhap); //Set id vào book
		
		iTaikhoanServices.delete(taikhoan);// Xóa theo id vì thế set id vào
		List<TaiKhoan> l= (List<TaiKhoan>) iTaikhoanServices.findAll();// lấy list
		
		if(vitrihientai==1) {
			model.addAttribute("lTaikhoans", phantrangtk(vitrihientai,l));
		}else
		if(phantrangtk(vitrihientai,l).isEmpty()) {
			model.addAttribute("lTaikhoans",phantrangtk(vitrihientai-1,l) );
			vitrihientai--;
		}else {
			model.addAttribute("lTaikhoans", phantrangtk(vitrihientai,l));
		}
		
		model.addAttribute("message","Đã xóa thành công");
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
		
		
		return listtk(model,taikhoan); //xóa xong chạy lại trang hiển thị book
	}
	
	
	
	List<TaiKhoan> ltim;
	@RequestMapping("/timkiemidornametk")
	public String timkiemidornametk(ModelMap model,@ModelAttribute("taikhoan")TaiKhoan taikhoan,HttpServletRequest request) {
		activemenu(model);
		String data = request.getParameter("data"); //lấy value từ trang web đưa vào đây
		ltim = iTaikhoanServices.ListFindtdnOrName(data);
		
		
		
		vitrihientai=1;
		model.addAttribute("danhsach",0);
		if(!ltim.isEmpty()) {
			model.addAttribute("danhsachtim",1);
			}
		
		model.addAttribute("lTaikhoans", phantrangtktim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
		model.addAttribute("titlepage", "Danh sách tài khoản");
		
		return "qltk"; //Chuyển sang trang timkiem
	}
	
	
	
	
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
		int vitrihientai=1;
		public List<TaiKhoan> phantrangtk(int vitrihientai,List<TaiKhoan> danhsach) {	
	List<TaiKhoan> l = danhsach;
	List<TaiKhoan> lreturn = new ArrayList<>();
	//lay ra 10 item
	for (int i = (vitrihientai-1)*10 ; i < (vitrihientai)*10 ; i++) {
		try {
		lreturn.add(l.get(i));
		}catch(Exception e) {
			break;
		}
	};
			return lreturn;
		}
		
		// số lượng button bấm chuyển trang
		public List<Integer> listSoLuongTrang(List<TaiKhoan> danhsach,ModelMap model){
			List<Integer> lreturn = new ArrayList<>();
			double temp = Double.parseDouble(danhsach.size()+"")/10.0;
			int tempfor = (int) Math.ceil(temp);
			int a = 3;
			int b=3;
			
			
			
			if(vitrihientai==1) {
				a=0;
				b=6;
			}
			if(vitrihientai==2) {
				a=1;
				b=5;
			}
			if(vitrihientai==3) {
				a=2;
				b=4;
			}
			if(vitrihientai==4) {
				a=3;
				b=3;
			}
			
			if(vitrihientai==tempfor) {
				a=6;
				b=0;
			}
			if(vitrihientai==(tempfor-1)) {
				a=5;
				b=1;
			}
			if(vitrihientai==(tempfor-2)) {
				a=4;
				b=2;
			}
			if(vitrihientai==(tempfor-3)) {
				a=3;
				b=3;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor ) {
				a=0;
				b=0;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 1 ) {
				a=0;
				b=1;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 2 ) {
				a=0;
				b=2;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 3 ) {
				a=0;
				b=3;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 4 ) {
				a=0;
				b=4;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 5 ) {
				a=0;
				b=5;
			}
			if(vitrihientai == 1 && vitrihientai == tempfor - 6 ) {
				a=0;
				b=6;
			}

	//-------------
			if(vitrihientai == 2 && vitrihientai == tempfor ) {
				a=1;
				b=0;
			}
			if(vitrihientai == 2 && vitrihientai == tempfor - 1 ) {
				a=1;
				b=1;
			}
			if(vitrihientai == 2 && vitrihientai == tempfor - 2 ) {
				a=1;
				b=2;
			}
			if(vitrihientai == 2 && vitrihientai == tempfor - 3 ) {
				a=1;
				b=3;
			}
			if(vitrihientai == 2 && vitrihientai == tempfor - 4 ) {
				a=1;
				b=4;
			}
			if(vitrihientai == 2 && vitrihientai == tempfor - 5 ) {
				a=1;
				b=5;
			}
			//-------------
					if(vitrihientai == 3 && vitrihientai == tempfor ) {
						a=2;
						b=0;
					}
					if(vitrihientai == 3 && vitrihientai == tempfor - 1 ) {
						a=2;
						b=1;
					}
					if(vitrihientai == 3 && vitrihientai == tempfor - 2 ) {
						a=2;
						b=2;
					}
					if(vitrihientai == 3 && vitrihientai == tempfor - 3 ) {
						a=2;
						b=3;
					}
					if(vitrihientai == 3 && vitrihientai == tempfor - 4 ) {
						a=2;
						b=4;
					}
					//-------------
					if(vitrihientai == 4 && vitrihientai == tempfor ) {
						a=3;
						b=0;
					}
					if(vitrihientai == 4 && vitrihientai == tempfor - 1 ) {
						a=3;
						b=1;
					}
					if(vitrihientai == 4 && vitrihientai == tempfor - 2 ) {
						a=3;
						b=2;
					}
					if(vitrihientai == 4 && vitrihientai == tempfor - 3 ) {
						a=3;
						b=3;
					}
					//-------------
					if(vitrihientai == 5 && vitrihientai == tempfor ) {
						a=4;
						b=0;
					}
					if(vitrihientai == 5 && vitrihientai == tempfor - 1 ) {
						a=4;
						b=1;
					}
					if(vitrihientai == 5 && vitrihientai == tempfor - 2 ) {
						a=4;
						b=2;
					}
					if(vitrihientai == 5 && vitrihientai == tempfor - 3 ) {
						a=4;
						b=3;
					}
					//-------------
					if(vitrihientai == 6 && vitrihientai == tempfor ) {
						a=5;
						b=0;
					}
					if(vitrihientai == 6 && vitrihientai == tempfor - 1 ) {
						a=5;
						b=1;
					}
					if(vitrihientai == 6 && vitrihientai == tempfor - 2 ) {
						a=5;
						b=2;
					}
					if(vitrihientai == 6 && vitrihientai == tempfor - 3 ) {
						a=5;
						b=3;
					}
			
			
			for (int i = vitrihientai-a; i <= vitrihientai+b; i++) {
				lreturn.add(i);
			}
			if(danhsach.isEmpty()) {
				lreturn.clear();
			}
			model.addAttribute("danhsach",danhsach.size());   // để ẩn thanh button trang khi danh sách trống
			model.addAttribute("trangdau",1);
			model.addAttribute("trangcuoi",tempfor);
			model.addAttribute("vitrihientai", vitrihientai);
			return lreturn;
		}
		
		
		// khi chọn button thì chạy cái này. lấy page xuất danh sách
		@RequestMapping("/tkpage")
		public String tkpage(ModelMap model,@RequestParam("page")int page,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
			activemenu(model);
			List<TaiKhoan> l = (List<TaiKhoan>) iTaikhoanServices.findAll();
			model.addAttribute("titlepage", "Danh sách tài khoản");
			vitrihientai = page;
			
			model.addAttribute("lTaikhoans", phantrangtk(vitrihientai,l));
			model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
			model.addAttribute("vitrihientai", vitrihientai);
			return "qltk";
			
		}
		
		
		
		//phan trang tim
		// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
			
			public List<TaiKhoan> phantrangtktim(int vitrihientai,List<TaiKhoan> danhsach) {	
		List<TaiKhoan> l = danhsach;
		List<TaiKhoan> lreturn = new ArrayList<>();
		//lay ra 10 item
		for (int i = (vitrihientai-1)*10 ; i < (vitrihientai)*10 ; i++) {
			try {
			lreturn.add(l.get(i));
			}catch(Exception e) {
				break;
			}
		};
				return lreturn;
			}
			
			// số lượng button bấm chuyển trang
			public List<Integer> listSoLuongTrangtim(List<TaiKhoan> danhsach,ModelMap model){
				List<Integer> lreturn = new ArrayList<>();
				double temp = Double.parseDouble(danhsach.size()+"")/10.0;
				int tempfor = (int) Math.ceil(temp);
				int a = 3;
				int b=3;
				
				
				
				if(vitrihientai==1) {
					a=0;
					b=6;
				}
				if(vitrihientai==2) {
					a=1;
					b=5;
				}
				if(vitrihientai==3) {
					a=2;
					b=4;
				}
				if(vitrihientai==4) {
					a=3;
					b=3;
				}
				
				if(vitrihientai==tempfor) {
					a=6;
					b=0;
				}
				if(vitrihientai==(tempfor-1)) {
					a=5;
					b=1;
				}
				if(vitrihientai==(tempfor-2)) {
					a=4;
					b=2;
				}
				if(vitrihientai==(tempfor-3)) {
					a=3;
					b=3;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor ) {
					a=0;
					b=0;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 1 ) {
					a=0;
					b=1;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 2 ) {
					a=0;
					b=2;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 3 ) {
					a=0;
					b=3;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 4 ) {
					a=0;
					b=4;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 5 ) {
					a=0;
					b=5;
				}
				if(vitrihientai == 1 && vitrihientai == tempfor - 6 ) {
					a=0;
					b=6;
				}

		//-------------
				if(vitrihientai == 2 && vitrihientai == tempfor ) {
					a=1;
					b=0;
				}
				if(vitrihientai == 2 && vitrihientai == tempfor - 1 ) {
					a=1;
					b=1;
				}
				if(vitrihientai == 2 && vitrihientai == tempfor - 2 ) {
					a=1;
					b=2;
				}
				if(vitrihientai == 2 && vitrihientai == tempfor - 3 ) {
					a=1;
					b=3;
				}
				if(vitrihientai == 2 && vitrihientai == tempfor - 4 ) {
					a=1;
					b=4;
				}
				if(vitrihientai == 2 && vitrihientai == tempfor - 5 ) {
					a=1;
					b=5;
				}
				//-------------
						if(vitrihientai == 3 && vitrihientai == tempfor ) {
							a=2;
							b=0;
						}
						if(vitrihientai == 3 && vitrihientai == tempfor - 1 ) {
							a=2;
							b=1;
						}
						if(vitrihientai == 3 && vitrihientai == tempfor - 2 ) {
							a=2;
							b=2;
						}
						if(vitrihientai == 3 && vitrihientai == tempfor - 3 ) {
							a=2;
							b=3;
						}
						if(vitrihientai == 3 && vitrihientai == tempfor - 4 ) {
							a=2;
							b=4;
						}
						//-------------
						if(vitrihientai == 4 && vitrihientai == tempfor ) {
							a=3;
							b=0;
						}
						if(vitrihientai == 4 && vitrihientai == tempfor - 1 ) {
							a=3;
							b=1;
						}
						if(vitrihientai == 4 && vitrihientai == tempfor - 2 ) {
							a=3;
							b=2;
						}
						if(vitrihientai == 4 && vitrihientai == tempfor - 3 ) {
							a=3;
							b=3;
						}
						//-------------
						if(vitrihientai == 5 && vitrihientai == tempfor ) {
							a=4;
							b=0;
						}
						if(vitrihientai == 5 && vitrihientai == tempfor - 1 ) {
							a=4;
							b=1;
						}
						if(vitrihientai == 5 && vitrihientai == tempfor - 2 ) {
							a=4;
							b=2;
						}
						if(vitrihientai == 5 && vitrihientai == tempfor - 3 ) {
							a=4;
							b=3;
						}
						//-------------
						if(vitrihientai == 6 && vitrihientai == tempfor ) {
							a=5;
							b=0;
						}
						if(vitrihientai == 6 && vitrihientai == tempfor - 1 ) {
							a=5;
							b=1;
						}
						if(vitrihientai == 6 && vitrihientai == tempfor - 2 ) {
							a=5;
							b=2;
						}
						if(vitrihientai == 6 && vitrihientai == tempfor - 3 ) {
							a=5;
							b=3;
						}
				
				
				for (int i = vitrihientai-a; i <= vitrihientai+b; i++) {
					lreturn.add(i);
				}
				if(danhsach.isEmpty()) {
					lreturn.clear();
				}
				
				model.addAttribute("trangdau",1);
				model.addAttribute("trangcuoi",tempfor);
				model.addAttribute("vitrihientai", vitrihientai);
				return lreturn;
			}
			
			// khi chọn button thì chạy cái này. lấy page xuất danh sách
			@RequestMapping("/tkpagetim")
			public String tkpagetim(ModelMap model,@RequestParam("page")int page,@ModelAttribute("taikhoan")TaiKhoan taikhoan) {
				activemenu(model);
				model.addAttribute("titlepage", "Danh sách tài khoản");
				vitrihientai = page;
				
				model.addAttribute("lTaikhoans", phantrangtktim(vitrihientai,ltim));
				model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
				model.addAttribute("vitrihientai", vitrihientai);
				model.addAttribute("danhsachtim",1);
				model.addAttribute("danhsach",0);
				return "qltk";
				
			}
			
			
			
			private void activemenu(ModelMap model) {
				
						
						//cai dat. tat ca duoi deu show tren cai dat --------------------
						model.addAttribute("chamshowcd",".show");
							//show quan ly tai khoan
						model.addAttribute("chamshowqltk",".show");
						model.addAttribute("activedstk","active");
						model.addAttribute("activettk",null);
						
							// quan ly loai phong
						model.addAttribute("chamshowqllp",null);
						model.addAttribute("activedslp",null);
						model.addAttribute("activetlp",null);
							
							//quan ly phong
						model.addAttribute("chamshowqlp",null);
						model.addAttribute("activedsp",null);
						model.addAttribute("activetp",null);
						
							// dich vu
						model.addAttribute("chamshowdv",null);
						model.addAttribute("activedv",null);
						model.addAttribute("activetdv",null);
			}

			
}


