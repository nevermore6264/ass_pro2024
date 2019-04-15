package DuAn2.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dondichvu")
public class DonDichVu {
@Id
private int maDonDichVu;
@ManyToOne
@JoinColumn(name="maDatPhong")
private DatPhong datPhong;

@ManyToOne
@JoinColumn(name="maDichVu")
private DichVu dichVu;
private Integer soLuong;
@Temporal(TemporalType.DATE)
private Date ngayDat;
public int getMaDonDichVu() {
	return maDonDichVu;
}

public Date getNgayDat() {
	return ngayDat;
}

public void setNgayDat(Date ngayDat) {
	this.ngayDat = ngayDat;
}

public void setMaDonDichVu(int maDonDichVu) {
	this.maDonDichVu = maDonDichVu;
}
public DatPhong getDatPhong() {
	return datPhong;
}
public void setDatPhong(DatPhong datPhong) {
	this.datPhong = datPhong;
}
public DichVu getDichVu() {
	return dichVu;
}
public void setDichVu(DichVu dichVu) {
	this.dichVu = dichVu;
}
public Integer getSoLuong() {
	return soLuong;
}
public void setSoLuong(Integer soLuong) {
	this.soLuong = soLuong;
}



}
