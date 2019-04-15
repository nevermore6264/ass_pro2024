package DuAn2.Controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.DichVu;
import DuAn2.Model.LoaiPhong;
import DuAn2.Model.Phong;
import DuAn2.Services.Ilsdtp;

@Controller
public class LsdtpController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@RequestMapping("/lsdtp")
	public String lsdtp(ModelMap model) {
		activemenu(model);
		List<DatPhong> l = (List<DatPhong>) ilsdtp.findAll();
		model.addAttribute("l", phantranglsdtp(vitrihientai, l));
		model.addAttribute("titlepage", "Lịch sử đặt trả phòng");
		model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
//		Calendar denngay = Calendar.getInstance();
//		DateFormat a = new SimpleDateFormat("yyyy-MM-dd");
//		model.addAttribute("denngay", a.format(denngay.getTime()));
//		model.addAttribute("tungay", a.format(denngay.getTime()));
//		
		vitrihientai = 1;
		return "lsdtp";
	}
	
	
	// từ thời gian này đến thời gian kia
//	List<DatPhong> ltim;
//	@RequestMapping("/timlsdtp")
//	public String timlsdtp(ModelMap model,@RequestParam("tungay")String tungay,@RequestParam("denngay")String denngay) throws ParseException  {
//		model.addAttribute("titlepage", "Lịch sử đặt trả phòng");
//		if(tungay.equals("")||denngay.equals("")) {
//			return lsdtp(model);
//		}else {
//		java.util.Date tungayy= new SimpleDateFormat("yyyy-MM-dd").parse(tungay);
//		java.util.Date denngayy= new SimpleDateFormat("yyyy-MM-dd").parse(denngay);
//		Date tungayyy = new Date(tungayy.getTime());
//		Date denngayyy = new Date(denngayy.getTime());
//		ltim = (List<DatPhong>) ilsdtp.timlsdtp(tungayyy, denngayyy);
//		vitrihientai=1;
//		model.addAttribute("l", phantranglsdtptim(vitrihientai, ltim));
//		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
//		model.addAttribute("titlepage", "Lịch sử đặt trả phòng");
//		if(!ltim.isEmpty()) {
//			model.addAttribute("danhsachtim",1);
//			}
//		model.addAttribute("danhsach",0);
//		return "lsdtp";
//		}
//	}
//	
	
	
	String data2 = "";
	@RequestMapping("/timlsdtp")
	public String timlsdtp(ModelMap model,@ModelAttribute("datphong")DatPhong DatPhong, HttpServletRequest httpServletRequest) {
		activemenu(model);
		String data2 = httpServletRequest.getParameter("data");
		this.data2 = data2;
		java.util.Date datefind;
		DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		List<DatPhong> ltim;
		if (data2.isEmpty()) {
			ltim = (List<DatPhong>) ilsdtp.findAll();
		} else {
			
			try {
				datefind = dateFormat.parse(data2);
				}catch (Exception e) {
					datefind = null;
				}
			
			try {
				int data1 = Integer.parseInt(data2);
				ltim = (List<DatPhong>) ilsdtp.timlsdtp(data1, data2,datefind);
			} catch (Exception e) {
				int data1 = 0;
				ltim = (List<DatPhong>) ilsdtp.timlsdtp(data1, data2,datefind);
			}

			
		}
		vitrihientai=1;
		model.addAttribute("danhsach",0);
		if(!ltim.isEmpty()) {
		model.addAttribute("danhsachtim",1);
		}
		model.addAttribute("l", phantranglsdtptim(vitrihientai, ltim));
		model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
		model.addAttribute("titlepage", "Danh sách dịch vụ");
		return "lsdtp";
	}
	
	
	
	//PHAN TRANG
		// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
			int vitrihientai=1;
			public List<DatPhong> phantranglsdtp(int vitrihientai,List<DatPhong> danhsach) {	
		List<DatPhong> l = danhsach;
		List<DatPhong> lreturn = new ArrayList<>() ;
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
			@RequestMapping("/lsdtppage")
			public String lsdtppage(ModelMap model,@RequestParam("page")int page) {
				activemenu(model);
				List<DatPhong> l = (List<DatPhong>) ilsdtp.findAll();
				model.addAttribute("titlepage", "Lịch sử đặt trả phòng");
				vitrihientai = page;
				
				model.addAttribute("l", phantranglsdtp(vitrihientai, l));
				model.addAttribute("listSoLuongTrang", listSoLuongTrang(l,model));
				
				
				model.addAttribute("vitrihientai", vitrihientai);
				return "lsdtp";
				
			}
			
			
			
			//phan trang tim
			// phân 10 item trên 1 trang. phải có vị trí để tính xuất 10 item thứ bao nhiêu
				
				public List<DatPhong> phantranglsdtptim(int vitrihientai,List<DatPhong> danhsach) {	
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
				@RequestMapping("/lsdtppagetim")
				public String lsdtppagetim(ModelMap model,@RequestParam("page")int page) {
					
					activemenu(model);
					
					java.util.Date datefind;
					DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
					List<DatPhong> ltim;
					if (data2.isEmpty()) {
						ltim = (List<DatPhong>) ilsdtp.findAll();
					} else {
						
						try {
							datefind = dateFormat.parse(data2);
							}catch (Exception e) {
								datefind = null;
							}
						
						try {
							int data1 = Integer.parseInt(data2);
							ltim = (List<DatPhong>) ilsdtp.timlsdtp(data1, data2,datefind);
						} catch (Exception e) {
							int data1 = 0;
							ltim = (List<DatPhong>) ilsdtp.timlsdtp(data1, data2,datefind);
						}

						
					}
					
					
					
					
					
					
					model.addAttribute("titlepage", "Lịch sử đặt trả phòng");
					vitrihientai = page;
					
					
					
					
					
					
					model.addAttribute("l", phantranglsdtptim(vitrihientai, ltim));
					model.addAttribute("listSoLuongTrang", listSoLuongTrangtim(ltim,model));
					model.addAttribute("vitrihientai", vitrihientai);
					model.addAttribute("danhsachtim",1);
					model.addAttribute("danhsach",0);
					return "lsdtp";
					
				}
				
				
				private void activemenu(ModelMap model) {
				
							//thong ke va bao cao
							model.addAttribute("chamshowtkvbc",".show");
							model.addAttribute("activelsdtp","active");
							model.addAttribute("activelsdv",null);
							model.addAttribute("activettdt",null);
							
						
				}

				

}
