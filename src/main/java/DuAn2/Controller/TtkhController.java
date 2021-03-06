package DuAn2.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.DichVu;
import DuAn2.Services.IttkhService;

@Controller
public class TtkhController {
@Autowired
IttkhService ittkhService;


	@RequestMapping("ttkh")
	public String ttkh(ModelMap model) {
		activemenu(model);
		List<DatPhong> l =  (List<DatPhong>) ittkhService.findAll();
		vitrihientai = 1;
		model.addAttribute("titlepage", "Thông tin khách hàng");
		model.addAttribute("l", phantrangttkh(vitrihientai,l));
		vitrihientai = 1;
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));// số lượng các button chọn trang
		return "ttkh";
	}
	
	String datatemp="";
	@RequestMapping("timttkh")
	public String timttkh(ModelMap model,@RequestParam("data")String data) {
		activemenu(model);
		List<DatPhong> ltim =  ittkhService.timttkh(data);;
		datatemp= data;
		
		
		
		vitrihientai=1;
		model.addAttribute("danhsach",0);
		if(!ltim.isEmpty()) {
		model.addAttribute("danhsachtim",1);
		}
		model.addAttribute("l", phantrangttkhtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
		model.addAttribute("titlepage", "Thông tin khách hàng");
		return "ttkh";
	}
	
	
	
	
	// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
		int vitrihientai=1;
		public List<DatPhong> phantrangttkh(int vitrihientai,List<DatPhong> danhsach) {	
	List<DatPhong> l = danhsach;
	List<DatPhong> lreturn = new ArrayList<>();
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
		public List<Integer> listSoLuongTrang(List<DatPhong> danhsach,ModelMap model){
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
		@RequestMapping("/ttkhpage")
		public String ttkhpage(ModelMap model,@RequestParam("page")int page) {
			activemenu(model);
			List<DatPhong> l = (List<DatPhong>) ittkhService.findAll();
			model.addAttribute("titlepage", "Thông tin khách hàng");
			vitrihientai = page;
			
			model.addAttribute("l", phantrangttkh(vitrihientai,l));
			model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
			model.addAttribute("vitrihientai", vitrihientai);
			return "ttkh";
			
		}
		
		
		
		//phan trang tim
		// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
			
			public List<DatPhong> phantrangttkhtim(int vitrihientai,List<DatPhong> danhsach) {	
		List<DatPhong> l = danhsach;
		List<DatPhong> lreturn = new ArrayList<>();
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
			public List<Integer> listSoLuongTrangtim(List<DatPhong> danhsach,ModelMap model){
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
			@RequestMapping("/ttkhpagetim")
			public String ttkhpagetim(ModelMap model,@RequestParam("page")int page) {
				activemenu(model);
				List<DatPhong> ltim =  ittkhService.timttkh(datatemp);
				model.addAttribute("titlepage", "Thông tin khách hàng");
				vitrihientai = page;
				
				model.addAttribute("l", phantrangttkhtim(vitrihientai,ltim));
				model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
				model.addAttribute("vitrihientai", vitrihientai);
				model.addAttribute("danhsachtim",1);
				model.addAttribute("danhsach",0);
				return "ttkh";
				
			}
			
			
			private void activemenu(ModelMap model) {
				
						
						//tim kiem thong tin
						model.addAttribute("chamshowtktt",".show");
						model.addAttribute("activettkh","active");
						model.addAttribute("activettp",null);
						
					
			}

			
}
