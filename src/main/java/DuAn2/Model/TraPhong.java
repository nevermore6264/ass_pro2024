package DuAn2.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="traphong")
public class TraPhong {
	@Id
	private int maTraPhong;
	
	@ManyToOne
	@JoinColumn(name="maDatPhong")
	private DatPhong datPhong;
	private Date ngayTra;
	@DateTimeFormat(pattern="HH:mm")
	private java.util.Date gioTra;
	private Double tongTien;
	public int getMaTraPhong() {
		return maTraPhong;
	}
	public void setMaTraPhong(int maTraPhong) {
		this.maTraPhong = maTraPhong;
	}
	public DatPhong getDatPhong() {
		return datPhong;
	}
	public void setDatPhong(DatPhong datPhong) {
		this.datPhong = datPhong;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public java.util.Date getGioTra() {
		return gioTra;
	}
	public void setGioTra(java.util.Date gioTra) {
		this.gioTra = gioTra;
	}
	public Double getTongTien() {
		return tongTien;
	}
	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
	
	
	
}
