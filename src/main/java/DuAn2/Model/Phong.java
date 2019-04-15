package DuAn2.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="phong")
public class Phong {
	@Id
	private int maPhong;
	@NotNull(message="- Số phòng không được trống")
	private Integer soPhong;
	@NotNull(message="- Số tầng không được trống")
	private Integer tang;
	private String tienNghi;
	@ManyToOne
	@JoinColumn(name="maLoaiPhong")
	private LoaiPhong loaiPhong;
	
	private String hinhAnh;
	@NotNull(message="- Giá không được trống")
	private Double giaPhong;
	@NotNull(message="- Khuyến mãi không được trống")
	private String khuyenMai;
	private Integer trangThai;
	
	@OneToMany(mappedBy="phong")
	
	private Collection<DatPhong> datPhongs;

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public Integer getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Integer soPhong) {
		this.soPhong = soPhong;
	}

	public Integer getTang() {
		return tang;
	}

	public void setTang(Integer tang) {
		this.tang = tang;
	}

	public String getTienNghi() {
		return tienNghi;
	}

	public void setTienNghi(String tienNghi) {
		this.tienNghi = tienNghi;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(Double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(String khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public Collection<DatPhong> getDatPhongs() {
		return datPhongs;
	}

	public void setDatPhongs(Collection<DatPhong> datPhongs) {
		this.datPhongs = datPhongs;
	}

	
	
}
