import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색하려는 학생의 id 값을 입력해주세요.");
		int keyId = scanner.nextInt();
		
		List<Student> studentList = setting();
		
		int left = 0;
		int median = studentList.size() / 2;
		int right = studentList.size() - 1;
	
		for(int medianId = studentList.get(median).getId(); left <= median && median <= right;) {
			
			if(medianId == keyId) {
				System.out.println("해당 학생의 이름은 "+studentList.get(median).getName()+"입니다.");
				break;
			}
			// 0, 1, 2 -> 0, 0,1
			else if(medianId > keyId) {
				right = median - 1;
				median = (left + right) / 2;
			}
			else if(medianId < keyId) {
				left = median + 1;
				median = (left + right) / 2;
			}
			medianId = studentList.get(median).getId();
		}
		
		if(left > median || median > right) {
			System.out.println("입력하신 id 값과 일치하는 학생이 리스트에 존재하지 않습니다.");

		}
		scanner.close();

	}
	
	static class Student {
		private int id;
		private String name;
		
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
	}
	
	
	public static List<Student> setting() {
		
		String[] studentName = {"dgs", "sgf", "agf", "twe", "piu", "gsdfc", "cxb", "gsfgd", "agfr", "hjw"};
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(3, studentName[0]));
		studentList.add(new Student(7, studentName[1]));
		studentList.add(new Student(8, studentName[2]));
		studentList.add(new Student(13, studentName[3]));
		studentList.add(new Student(19, studentName[4]));
		studentList.add(new Student(23, studentName[5]));
		studentList.add(new Student(25, studentName[6]));
		studentList.add(new Student(30, studentName[7]));
		studentList.add(new Student(31, studentName[8]));
		studentList.add(new Student(33, studentName[9]));
		
		return studentList;
		
	}

}
