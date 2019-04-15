package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.TaiKhoan;

public interface ITaikhoanServices extends CrudRepository<TaiKhoan, String> {

	@Query("select tk from TaiKhoan tk where tk.tenDangNhap = ?1 or tk.hoTen = ?1 or tk.cmnd = ?1 or tk.soDT = ?1 or tk.email = ?1")
	public List<TaiKhoan> ListFindtdnOrName(String data);
	
	@Query("select tk from TaiKhoan tk where tk.tenDangNhap = ?1 and tk.matKhau = ?2")
	public List<TaiKhoan> findUser(String tendangnhap, String matkhau);
}
