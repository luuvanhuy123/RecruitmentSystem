package recruitment.system.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recruiter database table.
 * 
 */
@Entity
@NamedQuery(name="Recruiter.findAll", query="SELECT r FROM Recruiter r")
public class Recruiter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Lob
	private String address;

	@Lob
	@Column(name="company_address")
	private String companyAddress;

	@Lob
	@Column(name="company_information")
	private String companyInformation;

	@Lob
	@Column(name="company_name")
	private String companyName;

	@Lob
	@Column(name="company_phone")
	private String companyPhone;

	@Lob
	private String name;

	private String sex;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="email")
	private User user;

	//bi-directional many-to-one association to RecruiterHi
	@OneToMany(mappedBy="recruiter")
	private List<RecruiterHi> recruiterHis;

	public Recruiter() {
	}

	public Recruiter(String email, String address, String companyAddress, String companyInformation, String companyName,
			String companyPhone, String name, String sex, User user) {
		super();
		this.email = email;
		this.address = address;
		this.companyAddress = companyAddress;
		this.companyInformation = companyInformation;
		this.companyName = companyName;
		this.companyPhone = companyPhone;
		this.name = name;
		this.sex = sex;
		this.user = user;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyInformation() {
		return this.companyInformation;
	}

	public void setCompanyInformation(String companyInformation) {
		this.companyInformation = companyInformation;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<RecruiterHi> getRecruiterHis() {
		return this.recruiterHis;
	}

	public void setRecruiterHis(List<RecruiterHi> recruiterHis) {
		this.recruiterHis = recruiterHis;
	}

	public RecruiterHi addRecruiterHi(RecruiterHi recruiterHi) {
		getRecruiterHis().add(recruiterHi);
		recruiterHi.setRecruiter(this);

		return recruiterHi;
	}

	public RecruiterHi removeRecruiterHi(RecruiterHi recruiterHi) {
		getRecruiterHis().remove(recruiterHi);
		recruiterHi.setRecruiter(null);

		return recruiterHi;
	}

	@Override
	public String toString() {
		return "Recruiter [email=" + email + ", address=" + address + ", companyAddress=" + companyAddress
				+ ", companyInformation=" + companyInformation + ", companyName=" + companyName + ", companyPhone="
				+ companyPhone + ", name=" + name + ", sex=" + sex + ", " + user.toStringPassword() + "]";
	}
	public String toStringJobpost(){
		return "companyAddress= "+companyAddress+" , companyName= "+companyName+" , companyPhone= "+companyPhone+" , email="+email;
	}
}