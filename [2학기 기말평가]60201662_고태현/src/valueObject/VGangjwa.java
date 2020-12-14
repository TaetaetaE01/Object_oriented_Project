package valueObject;

public class VGangjwa {
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;

	public VGangjwa() {
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.credit = credit;
		this.time = time;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}
}
