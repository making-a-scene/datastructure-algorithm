package search;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterpolationSearch {

	public static void main(String[] args) {
	// https://velog.io/@seochan99/자료구조-탐색Search-1
		List<Student> studentList = setting();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색하고자 하는 학생의 id를 입력해주세요.");
		final int keyId = scanner.nextInt();
		
		int lowIdx = 0;
		int lowId = studentList.get(lowIdx).getId();
		
		int highIdx = studentList.size() - 1;
		int highId = studentList.get(highIdx).getId();
		
		int posIdx = (lowIdx + highIdx) / 2;
		int posId = studentList.get(posIdx).getId();
		
				
		for(;lowIdx <= posIdx && posIdx <= highIdx; posId = studentList.get(posIdx).getId()) {
			
			if(posId == keyId) {
				System.out.println("검색하신 학생의 이름은 "+studentList.get(posIdx).getName()+"입니다.");
				break;
			}
			else if(posId > keyId) {
				highIdx = posIdx - 1;
				highId = studentList.get(highIdx).getId();
				posIdx = interpolationSearchPosIdxCalculator(posIdx, lowIdx, highIdx, posId, lowId, highId);
				
			}
			else if(posId < keyId) {
				lowIdx = posIdx + 1;
				lowId = studentList.get(lowIdx).getId();
				posIdx = interpolationSearchPosIdxCalculator(posIdx, lowIdx, highIdx, posId, lowId, highId);
				
			}
		}
		if(posId != keyId) {
			System.out.println("입력하신 id와 일치하는 학생 정보가 리스트에 존재하지 않습니다.");
		}
		scanner.close();
	}
	
	public static int interpolationSearchPosIdxCalculator(int posIdx, int lowIdx, int highIdx, int posId, int lowId, int highId) {
		return (int) ((posId - lowId) * (highIdx - lowIdx) / (highId - lowId)) + lowIdx;
		
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
