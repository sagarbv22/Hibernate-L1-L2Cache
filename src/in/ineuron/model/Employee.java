package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@DynamicUpdate(value = true)
@Entity
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO
	private Integer eid;
	private String ename;
	private LocalDate dob;
	private String ecompany;
	private LocalDate doj;
	private String ecity;
	@Version
	private Integer versionCount;

	
	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcompany() {
		return ecompany;
	}

	public void setEcompany(String ecompany) {
		this.ecompany = ecompany;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dob=" + dob + ", ecompany=" + ecompany + ", doj=" + doj
				+ ", ecity=" + ecity + ", versionCount=" + versionCount + "]";
	}

	

}
