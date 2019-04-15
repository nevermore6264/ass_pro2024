package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import DuAn2.Model.Phong;

public interface Ittp extends CrudRepository<Phong, Integer> {

	@Query("SELECT p FROM Phong p WHERE p.soPhong = ?1 or p.loaiPhong.tenLoaiPhong = ?2")
	public List<Phong> TimPhong(Integer soPhong, String loaiPhong);
	
	
}
