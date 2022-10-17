import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public static void main(String[] args) {
		
		List<Student> studentsList = setting();		
		int count = -1;
		
		while(count != 0) {
			
			count = 0;
			
			for(int i = 0; i + 1 < studentsList.size(); i++) {
				
				if(studentsList.get(i).getId() > studentsList.get(i+1).getId()) {
					Student temp = studentsList.get(i+1);
					studentsList.set(i+1, studentsList.get(i));
					studentsList.set(i, temp);
					count++;
				}	
			}
		}
		
		for(Student s : studentsList) 
			System.out.println(s.getId() + " / " + s.getName());

	}
	
	public static List<Student> setting() {
		
		List<Student> studentsList = new ArrayList<>();
		
		int[] idList = {13, 25, 9, 12, 34, 52, 49, 17, 5, 8};
		String[] nameList = {"afsd", "gsf","ter", "afdt", "yrt", "wwwt", "bcv", "sgdf", "sdgf", "ggd"};
		
		for(int i = 0;i < idList.length;i++) 
			studentsList.add(new Student(idList[i], nameList[i]));
		
		return studentsList;
	}

}

class Student {
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
