package DuAn2.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import DuAn2.Model.DonDichVu;

public interface Ilsdv extends CrudRepository<DonDichVu, Integer> {

	@Query("SELECT ddv FROM DonDichVu ddv WHERE ddv.maDonDichVu = ?1 OR ddv.datPhong.maDatPhong = ?2 OR ddv.dichVu.tenDichVu = ?3 or ddv.dichVu.loaiDichVu = ?3 or ddv.ngayDat = ?4")
	public List<DonDichVu> timlsdv(Integer maddv, Integer madp, String tendv, java.util.Date ngaydat);
	
	@Query("SELECT ddv FROM DonDichVu ddv WHERE ddv.ngayDat BETWEEN ?1 and ?2")
	public List<DonDichVu> timdsvtungaydenngay(java.util.Date tungay, java.util.Date denngay);
}
