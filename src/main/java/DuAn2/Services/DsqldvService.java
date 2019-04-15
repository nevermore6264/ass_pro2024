package DuAn2.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import DuAn2.Model.DichVu;


public interface DsqldvService extends CrudRepository<DichVu, Integer> {
	
	@Query("select d from DichVu d where d.maDichVu = ?1 or d.tenDichVu = ?2")
	public List<DichVu> timldsdv(int data1, String data2);
	
	@Query("select d from DichVu d where d.loaiDichVu = 0")
	public List<DichVu> selectanuong();

	@Query("select d from DichVu d where d.loaiDichVu = 1")
	public List<DichVu> selectgiatui();
	
	@Query("select d from DichVu d where d.loaiDichVu = 2")
	public List<DichVu> selectthugian();
}
