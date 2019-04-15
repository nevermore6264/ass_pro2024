package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DatPhong;


public interface IttkhService extends CrudRepository<DatPhong, Integer>{


	@Query("SELECT dp from DatPhong dp WHERE dp.hoTen = ?1 or dp.soDT = ?1 or dp.soCMND = ?1")
	public List<DatPhong> timttkh(String id);
}
