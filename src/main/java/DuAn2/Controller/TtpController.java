package DuAn2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.Phong;
import DuAn2.Services.Ittp;
import DuAn2.Services.QuanLyPhongService;


@Controller
public class TtpController {

	@Autowired
	Ittp ittp;
	@Autowired
	QuanLyPhongService quanlyphongService;
	@RequestMapping("/ttp")
	public String ttp(ModelMap model) {
		List<Phong> l = (List<Phong>) ittp.findAll();
		activemenu(model);
		vitrihientai = 1;
	
		model.addAttribute("lPhongs", phantrangttp(vitrihientai, l));
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
		model.addAttribute("titlepage", "Thông tin phòng");
		return "ttp";
	}
	

	
	List<Phong> ltim;
	@RequestMapping("/timttp")
	public String timttp(ModelMap model,@ModelAttribute("phong") Phong phong,HttpServletRequest httpServletRequest) {
		activemenu(model);
		ltim = (List<Phong>) quanlyphongService.TimMaPhong(Integer.parseInt(httpServletRequest.getParameter("data")));
		vitrihientai=1;
		model.addAttribute("lPhongs", phantrangphongtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
		model.addAttribute("titlepage", "Thông tin phòng");
		if(!ltim.isEmpty()) {
			model.addAttribute("danhsachtim",1);
			}
		model.addAttribute("danhsach",0);
		return "ttp";
	}
	
	
	
	//PHAN TRANG
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
		int vitrihientai=1;
		public List<Phong> phantrangttp(int vitrihientai,List<Phong> danhsach) {	
			
	List<Phong> l = danhsach;
	List<Phong> lreturn = new ArrayList<>();
	//lay ra 10 item
	for (int i = (vitrihientai-1)*5 ; i < (vitrihientai)*5 ; i++) {
		try {
		lreturn.add(l.get(i));
		}catch(Exception e) {
			break;
		}
	};
			return lreturn;
		}
		
		// số lượng button bấm chuyển trang
		public List<Integer> listSoLuongTrang(List<Phong> danhsach,ModelMap model){
			List<Integer> lreturn = new ArrayList<>();
			double temp = Double.parseDouble(danhsach.size()+"")/5.0;
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
		@RequestMapping("/ttppage")
		public String ttppage(ModelMap model,@RequestParam("page")int page,@ModelAttribute("phong")Phong phong) {
			activemenu(model);
			List<Phong> l = (List<Phong>) ittp.findAll();
			model.addAttribute("titlepage", "Thông tin phòng");
			vitrihientai = page;
			
			model.addAttribute("lPhongs", phantrangttp(vitrihientai, l));
			model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
			
			
			model.addAttribute("vitrihientai", vitrihientai);
			return "ttp";
			
		}
		
		
		
		//phan trang tim
		// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
			
			public List<Phong> phantrangphongtim(int vitrihientai,List<Phong> danhsach) {	
		List<Phong> l = danhsach;
		List<Phong> lreturn = new ArrayList<>();
		//lay ra 10 item
		for (int i = (vitrihientai-1)*5 ; i < (vitrihientai)*5 ; i++) {
			try {
			lreturn.add(l.get(i));
			}catch(Exception e) {
				break;
			}
		};
				return lreturn;
			}
			
			// số lượng button bấm chuyển trang
			public List<Integer> listSoLuongTrangtim(List<Phong> danhsach,ModelMap model){
				List<Integer> lreturn = new ArrayList<>();
				double temp = Double.parseDouble(danhsach.size()+"")/5.0;
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
			@RequestMapping("/ttppagetim")
			public String ttppagetim(ModelMap model,@RequestParam("page")int page,@ModelAttribute("phong")Phong phong) {
				activemenu(model);
				
				model.addAttribute("titlepage", "Thông tin phòng");
				vitrihientai = page;
				
				model.addAttribute("lPhongs", phantrangphongtim(vitrihientai,ltim));
				model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
				model.addAttribute("vitrihientai", vitrihientai);
				model.addAttribute("danhsachtim",1);
				model.addAttribute("danhsach",0);
				return "ttp";
				
			}
			
			private void activemenu(ModelMap model) {
				
				
				//tim kiem thong tin
				model.addAttribute("chamshowtktt",".show");
				model.addAttribute("activettkh",null);
				model.addAttribute("activettp","active");
				
			
	}
}
