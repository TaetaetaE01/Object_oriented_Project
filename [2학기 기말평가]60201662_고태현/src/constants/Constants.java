package constants;

public class Constants {
	
	public enum EMainClock{
		title("MJU 수강신청 프로그램 : 시계");
		
		private String text;
		private EMainClock(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt(){
			return Integer.parseInt(text);
		}
	}
	
	public enum EConfigurations{
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S");

		private String text;
		private EConfigurations(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum EPResultPanel{
		gangjwaNo("강좌번호"),
		gangjwaName("강좌명"),
		credit("학 점");

		private String text;
		private EPResultPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPGangjwaSelectionPanel{
		gangjwaNo("강좌번호"),
		gangjwaName("강좌명"),
		damdangGyosu("담당교수"),
		hakjeom("학점"),
		time("시간");
		

		private String text;
		private EPGangjwaSelectionPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPHakgwaSelectionPanel{
		rootFileName("root"),
		campus("캠퍼스"),
		college("대학"),
		hakgwa("학과");
		
		private String text;
		private EPHakgwaSelectionPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum ELoginDialog {
		width("600"),
		height("400"),
		nameLabel("ID"),
		sizeNameText("20"),
		passwordLabel("비밀번호"),
		sizePasswordText("20"),
		okButtonLabel("로그인"),
		cancelButtonLabel("취 소"),
		registerButtonLabel("회원가입"),
		idFnButtonLable("아이디 찾기"),
		pwFnButtonLable("비밀번호 찾기"),
		lginFailed("아이디와 패스워드가 틀림"),
		lginFailed1("로그언 정보가 일치하지 않습니다"),
		lginFailed2("계정이 존재하지 않습니다."),
		lginFailed3("빈칸이 있습니다!"),
		lginSuccess("님 환영합니다!"),
		error("비밀번호를 3회 틀리셨습니다."),
		title("명지대 수강신청 프로그램 : Login");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ERegister {
		width("500"),
		height("700"),
		idLabel("ID : "),
		idConfrimButtonLabel("ID 중복확인"),
		sizeNameText("20"),
		passwordLabel("PW :"),
		sizePasswordText("20"),
		passwordConfirmLabel("PW 확인 : "),
		nameLabel("NAME :"),
		stNumLabel("학번 :"),
		emailLabel("E-mail :"),
		telLabel("전화번호 :"),
		birthLabel("생년월일 :"),
		seoulRadio("서울 캠퍼스"),
		yonginRadio("용인 캠퍼스"),
		informationCheck("개인정보 수집 동의"),
		telMessage("* - 는 생략합니다"),
		birthMessage("Ex) 20010216"),
		okButtonLabel("로그인"),
		backButtonLabel("뒤로 가기"),
		registerButtonLabel("회원가입"),
		idConfirmAble("ID 사용이 가능 합니다"),
		idConfirmUnable("ID 사용이 불가능 합니다"),
		lginFailed("아이디와 패스워드가 틀림"),
		registerError("회원가입 정보에 빈칸이 있습니다."),
		registerPwCheck("pw가 pw확인과 일치하지 않습니다"),
		regitserDuplication("아이디 중복확인을 눌러주세요"),
		registerSuccess("회원가입 완료되었습니다!"),
		registerCheckBox("개인정보 동의 박스에 체크 해 주세요"),
		registerIdEnglish("아아디는 영어와 숫자로 입력해주세요!"),
		title("명지대 수강신청 프로그램 : Register");
		
		private String text;
		private ERegister(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EIdFind {
		width("450"),
		height("300"),
		idLabel("이름 : "),
		sizeNameText("20"),
		stnumLabel("학번 : "),
		sizestnumText("20"),
		title("MJU 수강신청 : IdFind"),
		backButtonLabel("뒤로 가기"),
		idFnButtonLable("아이디 찾기"),
		lginFailed("아이디와 패스워드가 틀림");
		
		private String text;
		private EIdFind(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPwFind {
		width("450"),
		height("300"),
		idLabel("ID : "),
		sizeNameText("20"),
		stnumLabel("학번 : "),
		sizestnumText("20"),
		title("MJU 수강신청 : PwFind"),
		backButtonLabel("뒤로 가기"),
		idFnButtonLable("비밀번호 찾기"),
		lginFailed("아이디와 패스워드가 틀림");
		
		private String text;
		private EPwFind(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	public enum EMainFrame{
		width("1000"),
		height("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt(){
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EMenuBar {
		eFile("파일");
		
		
		String text;
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		eLogiout("로그 아웃"),
		ePersonalInfo("개인 정보");

		String text;
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	//색변경으로 바꿀 거
	public enum EEditMenu {
		eCopy("복사"),
		eCut("잘라내기"),
		ePaste("붙이기"),
		eDelete("삭제");
		
		String text;
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EMenuPersonalInfo {
		width("400"),
		height("600"),
		idLabel("아이디 : "),
		sizeidText("20"),
		passwordLabel("비밀번호 : "),
		sizePasswordText("20"),
		campusLabel("소속 캠퍼스 : "),
		nameLabel("이름 : "),
		stNumeLabel("학번 : "),
		emailLabel("e-mail : "),
		pwConfirmBtnLabel("비밀번호 확인"),
		pwChangeBtnLabel("비밀번호 수정"),
		cancelButtonLabel("뒤로 가기"),
		lginFailed("빈칸이 있습니다!"),
		lginSuccess("비밀번호가 수정되었습니다!"),
		title("명지대 수강신청 프로그램 : PesonalInfo");
		
		private String text;
		private EMenuPersonalInfo(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPlan {
		width("900"),
		height("600"),
		campusLabel("캠퍼스"),
		professorLabel("교수명"),
		creditLabel("학 점"),
		nameLabel("강의명"),
		sizeNameText("20"),
		title("MJU 수강신청 : 강의 계획서"),
		backButtonLabel("뒤로 가기"),
		resetButtonLable("강의 계획서"),
		searchButtonLable("검 색"),
		lginFailed("아이디와 패스워드가 틀림");
		
		private String text;
		private EPlan(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EplanTable{
		gangjwaNo("강좌번호"),
		gangjwaName("강좌명"),
		credit("학 점");

		private String text;
		private EplanTable(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
}
