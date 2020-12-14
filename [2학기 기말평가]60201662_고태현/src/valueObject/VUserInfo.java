package valueObject;

public class VUserInfo {
	private String Id;
	private String Pw;
	private String Name;
	private String StNum;
	private String yonginBtn;
	private String seoulBtn;
	private String Email;
	private String Tel;
	private String Birth;
	private String ConfirmId;
	private String ConfirmPw;
	private String master;

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getConfirmId() {
		return ConfirmId;
	}

	public void setConfirmId(String confirmId) {
		ConfirmId = confirmId;
	}

	public String getConfirmPw() {
		return ConfirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		ConfirmPw = confirmPw;
	}

	public String getBirth() {
		return Birth;
	}

	public void setBirth(String birth) {
		Birth = birth;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPw() {
		return Pw;
	}

	public void setPw(String pw) {
		Pw = pw;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStNum() {
		return StNum;
	}

	public void setStNum(String stNum) {
		StNum = stNum;
	}

	public String getYonginBtn() {
		return yonginBtn;
	}

	public void setYonginBtn(String yonginBtn) {
		this.yonginBtn = yonginBtn;
	}

	public String getSeoulBtn() {
		return seoulBtn;
	}

	public void setSeoulBtn(String seoulBtn) {
		this.seoulBtn = seoulBtn;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public VUserInfo() {

	}
}
