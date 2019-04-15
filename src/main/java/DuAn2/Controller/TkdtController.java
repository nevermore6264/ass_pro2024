package DuAn2.Controller;



import java.sql.Date;
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
import DuAn2.Model.DichVu;
import DuAn2.Model.DoanhThuDichVu;
import DuAn2.Model.DoanhThuPhong;
import DuAn2.Model.DonDichVu;
import DuAn2.Model.Phong;
import DuAn2.Model.TraPhong;
import DuAn2.Services.DsqldvService;
import DuAn2.Services.ITraPhong;
import DuAn2.Services.Ilsdv;
import DuAn2.Services.Ittp;

@Controller
public class TkdtController {

	@Autowired
	ITraPhong iTraPhong;
	@Autowired
	Ilsdv ilsdv;
	
	@Autowired
	DsqldvService dsqldvService;
	
	@Autowired
	Ittp ittp;
	
	@RequestMapping("/tkdt")
	public String tkdt(ModelMap model) {
		activemenu(model);
		tungayyy = null;
		denngayyy = null;
		checkctdtctp=null;
		checkctdtdv=null;
		model.addAttribute("titlepage", "Thống kê doanh thu");
		double tongTienDatPhong = 0;
		double tongTienDichVu = 0;
		List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.findAll();
		for (int i = 0; i < lTraPhong.size(); i++) {
			tongTienDatPhong+= lTraPhong.get(i).getTongTien();
		}
		
		List<DonDichVu> lDonDichVu =(List<DonDichVu>) ilsdv.findAll();
		for (int i = 0; i < lDonDichVu.size(); i++) {
			tongTienDichVu+= lDonDichVu.get(i).getSoLuong()*lDonDichVu.get(i).getDichVu().getGiaDichVu();
		}
		
		model.addAttribute("tongTien",tongTienDatPhong);
		model.addAttribute("tongTienDichVu",tongTienDichVu);
		return "tkdt";
	}
	
	Date tungayyy = null;
	Date denngayyy = null;
	@RequestMapping("/timtkdt")
	public String timtkdt(ModelMap model,@RequestParam("tungay")String tungay,@RequestParam("denngay")String denngay) throws ParseException  {
		checkctdtctp=null;
		checkctdtdv=null;
		activemenu(model);
		if(tungay.equals("")||denngay.equals("")) {
			return tkdt(model);
		}else {
		java.util.Date tungayy= new SimpleDateFormat("yyyy-MM-dd").parse(tungay);
		java.util.Date denngayy= new SimpleDateFormat("yyyy-MM-dd").parse(denngay);
		
		Date tungayyy = new Date(tungayy.getTime());
		Date denngayyy = new Date(denngayy.getTime());
		
		this.tungayyy=tungayyy;
		this.denngayyy=denngayyy;
		
		if(tungayyy.after(denngayy)) {
			model.addAttribute("titlepage", "Thống kê doanh thu");
			model.addAttribute("message", "Thời gian không hợp lệ");
			return "tkdt";
		}
		
		double tongTienDatPhong = 0;
		double tongTienDichVu = 0;
		List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.timtkdt(tungayyy, denngayyy);
		for (int i = 0; i < lTraPhong.size(); i++) {
			tongTienDatPhong += lTraPhong.get(i).getTongTien();
		}
		
		
		List<DonDichVu> lDonDichVu = ilsdv.timdsvtungaydenngay(tungayyy, denngayyy);
		
		for (int i = 0; i < lDonDichVu.size(); i++) {
			tongTienDichVu += lDonDichVu.get(i).getSoLuong() * lDonDichVu.get(i).getDichVu().getGiaDichVu();
		}
		
		model.addAttribute("titlepage", "Thống kê doanh thu");
		model.addAttribute("tongTien",tongTienDatPhong);
		model.addAttribute("tongTienDichVu",tongTienDichVu);
		model.addAttribute("tungay", tungay);
		model.addAttribute("denngay", denngay);
		return "tkdt";
		}
	}
	
	
	
	
	
	Integer checkctdtdv=null;//hiển thị khi bấm vào xem chi tiết dịch vụ
	@RequestMapping("/ctdtdv")
	public String ctdtdv(ModelMap model) {
		
		activemenu(model);
		List<DichVu> ldv=(List<DichVu>) dsqldvService.findAll();
		List<DonDichVu> lddv;
		List<DoanhThuDichVu> l=new ArrayList<>();
		for (int i = 0; i < ldv.size(); i++) {
			
			
			
			lddv=(List<DonDichVu>) ldv.get(i).getDonDichVus();
			double tongsoluong=0;
			
			
			if(tungayyy==null&&denngayyy==null) {
				for (int j = 0; j < lddv.size(); j++) {
					tongsoluong+=lddv.get(j).getSoLuong();			
				}
			}else {
				
				
				for (int j = 0; j < lddv.size(); j++) {
					
if(
		(lddv.get(j).getNgayDat().after(tungayyy)||lddv.get(j).getNgayDat().equals(tungayyy))
		&&
		(lddv.get(j).getNgayDat().before(denngayyy)||lddv.get(j).getNgayDat().equals(denngayyy))
		) {
					
						
						tongsoluong+=lddv.get(j).getSoLuong();
				}
				
				
			}
			
			
			}
			
			
			
			double tonggia = tongsoluong*ldv.get(i).getGiaDichVu();
			l.add(new DoanhThuDichVu(ldv.get(i).getTenDichVu(), tongsoluong, tonggia));
			
			
			
			
		}
		checkctdtdv=1;
		checkctdtctp=null;
model.addAttribute("ctdtdv", l);
model.addAttribute("checkctdtdv", checkctdtdv);
		

if(tungayyy==null&&denngayyy==null) {
//xuất list đầu tiên
model.addAttribute("titlepage", "Thống kê doanh thu");
double tongTienDatPhong = 0;
double tongTienDichVu = 0;
List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.findAll();
for (int i = 0; i < lTraPhong.size(); i++) {
	tongTienDatPhong+= lTraPhong.get(i).getTongTien();
}

List<DonDichVu> lDonDichVu =(List<DonDichVu>) ilsdv.findAll();
for (int i = 0; i < lDonDichVu.size(); i++) {
	tongTienDichVu+= lDonDichVu.get(i).getSoLuong()*lDonDichVu.get(i).getDichVu().getGiaDichVu();
}

model.addAttribute("tongTien",tongTienDatPhong);
model.addAttribute("tongTienDichVu",tongTienDichVu);
}else {
	
	
	//xuất list đầu tiên
	model.addAttribute("titlepage", "Thống kê doanh thu");
	double tongTienDatPhong = 0;
	double tongTienDichVu = 0;
	List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.timtkdt(tungayyy, denngayyy);
	for (int i = 0; i < lTraPhong.size(); i++) {
		tongTienDatPhong+= lTraPhong.get(i).getTongTien();
	}

	List<DonDichVu> lDonDichVu = ilsdv.timdsvtungaydenngay(tungayyy, denngayyy);
	for (int i = 0; i < lDonDichVu.size(); i++) {
		tongTienDichVu+= lDonDichVu.get(i).getSoLuong()*lDonDichVu.get(i).getDichVu().getGiaDichVu();
	}

	model.addAttribute("tongTien",tongTienDatPhong);
	model.addAttribute("tongTienDichVu",tongTienDichVu);
	
	
	
	
}
		return "tkdt";
	}
	
	
	
	
	Integer checkctdtctp=null;//hiển thị khi bấm vào xem chi tiết doanh thu cho thue phong
	@RequestMapping("/ctdtctp")
	public String ctdtctp(ModelMap model) {
		activemenu(model);
		List<Phong> phong = (List<Phong>) ittp.findAll();
		List<DatPhong> donDatPhong;
		List<DoanhThuPhong> l=new ArrayList<>();
		
		for (int i = 0; i < phong.size(); i++) {
			donDatPhong=(List<DatPhong>) phong.get(i).getDatPhongs();
			Integer tongSoLanDat=0;
			double tongGia=0;
			
			
			for (int j = 0; j < donDatPhong.size(); j++) {
				
				
				
				if(!donDatPhong.get(j).getTraPhongs().isEmpty()) {
					
					
					
					
					List<TraPhong> traphong = (List<TraPhong>) donDatPhong.get(j).getTraPhongs();
					if(tungayyy==null||denngayyy==null) {
						tongSoLanDat++;
						tongGia+= traphong.get(0).getTongTien();	
					}else {
					if(
							(traphong.get(0).getNgayTra().after(tungayyy)||traphong.get(0).getNgayTra().equals(tungayyy))
							&&
							(traphong.get(0).getNgayTra().before(denngayyy)||traphong.get(0).getNgayTra().equals(denngayyy))
							
							) {
					tongSoLanDat++;
					tongGia+= traphong.get(0).getTongTien();	
					}
					
					}
					
				
				}
				
				
			}
			
			l.add(new DoanhThuPhong(phong.get(i).getSoPhong(), tongSoLanDat, tongGia));		
			}
			
			
			
			
			
		checkctdtdv=null;
		checkctdtctp=1;
model.addAttribute("ctdtctp", l);
model.addAttribute("checkctdtctp", checkctdtctp);
		


if(tungayyy==null&&denngayyy==null) {
//xuất list đầu tiên
model.addAttribute("titlepage", "Thống kê doanh thu");
double tongTienDatPhong = 0;
double tongTienDichVu = 0;
List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.findAll();
for (int i = 0; i < lTraPhong.size(); i++) {
	tongTienDatPhong+= lTraPhong.get(i).getTongTien();
}

List<DonDichVu> lDonDichVu =(List<DonDichVu>) ilsdv.findAll();
for (int i = 0; i < lDonDichVu.size(); i++) {
	tongTienDichVu+= lDonDichVu.get(i).getSoLuong()*lDonDichVu.get(i).getDichVu().getGiaDichVu();
}

model.addAttribute("tongTien",tongTienDatPhong);
model.addAttribute("tongTienDichVu",tongTienDichVu);
}else {
	
	
	
	//xuất list đầu tiên
	model.addAttribute("titlepage", "Thống kê doanh thu");
	double tongTienDatPhong = 0;
	double tongTienDichVu = 0;
	List<TraPhong> lTraPhong =(List<TraPhong>) iTraPhong.timtkdt(tungayyy, denngayyy);
	for (int i = 0; i < lTraPhong.size(); i++) {
		tongTienDatPhong+= lTraPhong.get(i).getTongTien();
	}

	List<DonDichVu> lDonDichVu = ilsdv.timdsvtungaydenngay(tungayyy, denngayyy);
	for (int i = 0; i < lDonDichVu.size(); i++) {
		tongTienDichVu+= lDonDichVu.get(i).getSoLuong()*lDonDichVu.get(i).getDichVu().getGiaDichVu();
	}

	model.addAttribute("tongTien",tongTienDatPhong);
	model.addAttribute("tongTienDichVu",tongTienDichVu);
	
	
	
	
	
}
		return "tkdt";
	}
	
	
	
	

	private void activemenu(ModelMap model) {
	
				//thong ke va bao cao
				model.addAttribute("chamshowtkvbc",".show");
				model.addAttribute("activelsdtp",null);
				model.addAttribute("activelsdv",null);
				model.addAttribute("activettdt","active");
				
			
	}
	
}
