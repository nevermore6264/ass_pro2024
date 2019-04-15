package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.Phong;




public interface QuanLyPhongService extends CrudRepository<Phong, Integer> {
	@Query("SELECT p FROM Phong p WHERE p.maPhong = ?1 or p.soPhong = ?1 or p.tang = ?1")
	public List<Phong> TimMaPhong(int id);
	


}
