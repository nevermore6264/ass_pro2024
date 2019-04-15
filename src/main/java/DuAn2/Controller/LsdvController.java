package DuAn2.Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.DonDichVu;
import DuAn2.Services.Ilsdv;

@Controller
public class LsdvController {

	@Autowired
	Ilsdv ilsdv;
	
	@RequestMapping("/lsdv")
	public String lsdv(ModelMap model) {
		activemenu(model);
		vitrihientai = 1;
List<DonDichVu> l = (List<DonDichVu>) ilsdv.findAll();
model.addAttribute("titlepage", "Lịch sử dịch vụ");
model.addAttribute("l", phantranglsdv(vitrihientai, l));
model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
		return "lsdv";
	}
	
	List<DonDichVu> ltim;
	@RequestMapping("/timlsdv")
	public String timlsdtp(ModelMap model,@RequestParam("data")String data)  {
		activemenu(model);
		model.addAttribute("titlepage", "Lịch sử dịch vụ");
		java.util.Date datefind;
		DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		if(data.equals("")) {
			return lsdv(model);
		}
		Integer data1=null;
		Integer data2=null;
		
		try {
			datefind = dateFormat.parse(data);
			}catch (Exception e) {
				datefind = null;
			}
		try {
			data1= Integer.parseInt(data);
			data2= Integer.parseInt(data);
		}catch (Exception e) {
			data1=null;
			data2=null;
		}
		ltim = (List<DonDichVu>) ilsdv.timlsdv(data1, data2, data,datefind);
		vitrihientai=1;
		model.addAttribute("danhsach",0);
		if(!ltim.isEmpty()) {
		model.addAttribute("danhsachtim",1);
		}
		model.addAttribute("l", phantranglsdvtim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
		
		return "lsdv";
		
	}
	
	
	
	//PHAN TRANG
			// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
				int vitrihientai=1;
				public List<DonDichVu> phantranglsdv(int vitrihientai,List<DonDichVu> danhsach) {	
			List<DonDichVu> l = danhsach;
			List<DonDichVu> lreturn = new ArrayList<>() ;
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
				public List<Integer> listSoLuongTrang(List<DonDichVu> danhsach,ModelMap model){
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
				@RequestMapping("/lsdvpage")
				public String lsdvpage(ModelMap model,@RequestParam("page")int page) {
					activemenu(model);
					List<DonDichVu> l = (List<DonDichVu>) ilsdv.findAll();
					model.addAttribute("titlepage", "Lịch sử dịch vụ");
					vitrihientai = page;
					
					model.addAttribute("l", phantranglsdv(vitrihientai, l));
					model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
					
					
					model.addAttribute("vitrihientai", vitrihientai);
					return "lsdv";
					
				}
				
				
				//phan trang tim
				// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
					
					public List<DonDichVu> phantranglsdvtim(int vitrihientai,List<DonDichVu> danhsach) {	
				List<DonDichVu> l = danhsach;
				List<DonDichVu> lreturn = new ArrayList<>();
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
					public List<Integer> listSoLuongTrangtim(List<DonDichVu> danhsach,ModelMap model){
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
					@RequestMapping("/lsdvpagetim")
					public String lsdvpagetim(ModelMap model,@RequestParam("page")int page) {
						activemenu(model);
						model.addAttribute("titlepage", "Lịch sử dịch vụ");
						vitrihientai = page;
						
						model.addAttribute("l", phantranglsdvtim(vitrihientai, ltim));
						model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
						model.addAttribute("vitrihientai", vitrihientai);
						model.addAttribute("danhsachtim",1);
						model.addAttribute("danhsach",0);
						return "lsdv";
						
					}
					
					
					
					private void activemenu(ModelMap model) {
					
								//thong ke va bao cao
								model.addAttribute("chamshowtkvbc",".show");
								model.addAttribute("activelsdtp",null);
								model.addAttribute("activelsdv","active");
								model.addAttribute("activettdt",null);
								
							
					}
					
	
}
