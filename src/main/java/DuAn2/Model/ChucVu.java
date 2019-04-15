package DuAn2.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="chucvu")
public class ChucVu {
@Id
private int maChucVu;
private String tenChucVu;

@OneToMany(mappedBy="chucVu")
private Collection<TaiKhoan> taikhoans;
public int getMaChucVu() {
	return maChucVu;
}
public void setMaChucVu(int maChucVu) {
	this.maChucVu = maChucVu;
}
public String getTenChucVu() {
	return tenChucVu;
}
public void setTenChucVu(String tenChucVu) {
	this.tenChucVu = tenChucVu;
}

public Collection<TaiKhoan> getTaikhoans() {
	return taikhoans;
}
public void setTaikhoans(Collection<TaiKhoan> taikhoans) {
	this.taikhoans = taikhoans;
}


}
