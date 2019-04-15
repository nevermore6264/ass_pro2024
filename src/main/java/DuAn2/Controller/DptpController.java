package DuAn2.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DuAn2.Model.DatPhong;
import DuAn2.Model.DonDichVu;
import DuAn2.Model.LoaiPhong;
import DuAn2.Model.Phong;
import DuAn2.Model.TraPhong;
import DuAn2.Services.ILoaiphongSercives;
import DuAn2.Services.ITraPhong;
import DuAn2.Services.Idv;
import DuAn2.Services.Ilsdtp;
import DuAn2.Services.Ittp;

@Controller
@Transactional
public class DptpController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@Autowired
	Idv idv;
	
	@Autowired
	Ittp ittp;
	
	@Autowired
	ITraPhong iTraPhong;
	
	@Autowired
	ILoaiphongSercives iLoaiphongSercives;
	
	
	
	private void activemenu(ModelMap model) {
		// active trên menu
				model.addAttribute("activedptp","active");
				
	}
	
	@RequestMapping("/dptp")
	public String dptp(ModelMap model) {
		activemenu(model);
		
		
		List<Phong> l = (List<Phong>) ittp.findAll();
		model.addAttribute("l", l);
		
		List<Integer> ltang = new ArrayList<>();
		// kiem tra da ton tai chua
		for (int i = 0; i < l.size(); i++) {
			if(!ltang.contains(l.get(i).getTang())) {
			ltang.add(l.get(i).getTang());
			}
		}
		
if(l.isEmpty()) {
			
			model.addAttribute("message", "Không có phòng nào");
		}
		model.addAttribute("ltang", ltang);
		model.addAttribute("titlepage", "Đặt phòng / trả phòng");
		return "dptp";
	}
	
	@RequestMapping("/actionclickdptp")
	public String actionclickdptp(ModelMap model,@ModelAttribute("datphong")DatPhong datphong,@ModelAttribute("traphong")TraPhong traphong,@RequestParam("maPhong")int maPhong,@RequestParam("trangThai")int trangThai,@RequestParam("soPhong")int soPhong,HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("soPhong", soPhong);
		model.addAttribute("maPhong", maPhong);
		HttpSession session = httpServletRequest.getSession();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		model.addAttribute("ngayhientai", dateFormat.format(cal.getTime()));
		model.addAttribute("giohientai", timeFormat.format(cal.getTime()));
		model.addAttribute("ngayhientaii", cal.getTime());
		model.addAttribute("nguoidung", session.getAttribute("nguoidung").toString());
		if(trangThai==0) {
			
			Phong ttphong = ittp.findById(maPhong).get();
			model.addAttribute("thongtinphong", ttphong);
			
			model.addAttribute("titlepage", "Đặt phòng số "+soPhong );
			return "dptp/dp";
		}else {
			
			
			
			Integer maDatPhong=null;
			double tongTiendv=0;
			double tongTiendp=0;
			double tongTien=0;
			List<DatPhong> ldp = ilsdtp.timphongchuatra(maPhong); // tìm ra đơn đặt phòng chưa trả phòng
			for (int i = 0; i < ldp.size(); i++) {
				if(ldp.get(i).getTraPhongs().isEmpty()) {
					maDatPhong=ldp.get(i).getMaDatPhong(); // đã tìm ra mã đặt phòng của đơn đặt phòng chưa trả
					break;
				}
			}
			
			List<DonDichVu> lddv = idv.datdichvu(maDatPhong); // tìm tất cả các dịch vụ đã đặt của đơn đặt phòng
			for (int i = 0; i < lddv.size(); i++) {
				tongTiendv += lddv.get(i).getSoLuong() * lddv.get(i).getDichVu().getGiaDichVu();
			}
			
			
			DatPhong getdatphong= ilsdtp.findById(maDatPhong).get();
			
			long ngaydatru= cal.getTime().getTime() - getdatphong.getNgayDat().getTime();
			
			long diffDays = ngaydatru / (24 * 60 * 60 * 1000);
			Integer songaythue = Integer.parseInt(diffDays+""); // đã tính ra số ngày thuê
			if(songaythue==0) {
				songaythue=1;
			}
			tongTiendp =  (songaythue * getdatphong.getPhong().getGiaPhong())*((100-Double.parseDouble(getdatphong.getPhong().getKhuyenMai()))/100);

			
			tongTien = tongTiendp+tongTiendv-getdatphong.getTienCoc();
			
			model.addAttribute("sophong", soPhong);
			model.addAttribute("tiencoc", getdatphong.getTienCoc());
			model.addAttribute("getdatphong", getdatphong);
			model.addAttribute("titlepage", "Trả phòng số "+soPhong );
			model.addAttribute("maDatPhong", maDatPhong);
			model.addAttribute("tongTien", tongTien);
			model.addAttribute("tongTiendv", tongTiendv);
			model.addAttribute("tongTiendp", tongTiendp);
			model.addAttribute("listdv", lddv);
			model.addAttribute("songaythue", songaythue);
			model.addAttribute("giamgia", Integer.parseInt(getdatphong.getPhong().getKhuyenMai()));
			return "dptp/tp";
			
			
			
		}
		
		
	}
	
	
	@RequestMapping("/actiontraphong")
	public String actiontraphong(ModelMap model,@ModelAttribute("traphong")TraPhong traphong,@RequestParam("maPhong")int maPhong) {
		iTraPhong.save(traphong);
		activemenu(model);
		Phong p = ittp.findById(maPhong).get();
		p.setTrangThai(0);
		ittp.save(p);
		model.addAttribute("message", "Trả phòng thành công");
		return dptp(model);
	}
	
	@RequestMapping("/themddp")
	public String themddp(ModelMap model,@ModelAttribute("datphong")DatPhong datphong) {
		activemenu(model);
		ilsdtp.save(datphong);
		Phong p = ittp.findById(datphong.getPhong().getMaPhong()).get();
		p.setTrangThai(1);
		ittp.save(p);
		model.addAttribute("message", "Đặt phòng thành công");
		return dptp(model);
	}
}
