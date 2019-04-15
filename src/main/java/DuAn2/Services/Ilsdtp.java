package DuAn2.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DatPhong;


public interface Ilsdtp extends CrudRepository<DatPhong, Integer>{

	@Query("SELECT dp FROM DatPhong dp WHERE dp.ngayDat BETWEEN ?1 and ?2")
	public List<DatPhong> timlsdtp(Date tungay, Date denngay);
	
	@Query("SELECT p FROM DatPhong p where p.phong.trangThai=1")
	public List<DatPhong> timtrangthai();
	
	@Query("SELECT p FROM DatPhong p WHERE p.phong.maPhong = ?1")
	public List<DatPhong> timphongchuatra(int maPhong);
	
	@Query("SELECT p FROM DatPhong p WHERE p.maDatPhong = ?1 or p.hoTen=?2 or p.soDT=?2 or p.soCMND = ?2 or p.phong.soPhong = ?2 or p.ngayDat=?3 or p.taiKhoan.tenDangNhap=?2")
	public List<DatPhong> timlsdtp(int maPhong, String data, java.util.Date date);
	
	
	@Query("SELECT p.phong FROM DatPhong p WHERE p.phong.trangThai = 1")
	public List<DatPhong> timtang();
}
