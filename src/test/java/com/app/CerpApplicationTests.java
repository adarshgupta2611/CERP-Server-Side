package com.app;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Admin;
import com.app.entities.Attendance;
import com.app.entities.Course;
import com.app.entities.Schedule;
import com.app.entities.Student;
import com.app.entities.Subject;
import com.app.repository.AdminRepository;
import com.app.repository.AttendanceRepository;
import com.app.repository.CourseRepository;
import com.app.repository.ScheduleRepository;
import com.app.repository.StudentRepository;
import com.app.repository.SubjectRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class CerpApplicationTests {

	@Autowired
	CourseRepository cr;
	
	@Test
	void courseData() {
		cr.saveAll(List.of(new Course("PG-DAC"),new Course("PG-DBDA")));
	}

	@Autowired
	StudentRepository sr;
	
	@Test
	void studentData() {
			
			List<Course> cs = cr.findAll();
			Course cs1 = cs.get(0);
			Course cs2 = cs.get(1);

		sr.saveAll(List.of(new Student("Disha", "Murarka","dishamurarka1117@gmail.com","Female", "Dish@111", "Pune", cs1),
				new Student("Rakshit", "Jain","rakshitjain@gmail.com","Male", "Rakshit@111", "Pune", cs1),
				new Student("Saud","Mukhair","saud@gmail.com","Male","Saud@789","Mumbai",cs1),
				new Student("Anu","Joshi","anu@gmail.com","Female","Anu@789","Nashik",cs1),
				new Student("Mahak","Jain","mahak@gmail.com","Female","Mahak@789","Agra",cs2),
				new Student("Sneha","Choudhari","sneha@gmail.com","Female","Sneha@789","Nashik",cs2),
				new Student("Paras","Kesare","paras@gmail.com","Male","Paras@789","Gondia",cs2),
				new Student("Jitendra","Rajput","jitendra@gmail.com","Male","Jitendra@789","Amravati",cs2),
				new Student("Nikhil","Gupta","nikhil@gmail.com","Male","nikhil@789","Delhi",cs2),
				new Student("Ashi","Jain","ashi@gmail.com","Female","Ashi@789","Nimaj",cs1),
				new Student("Nipun","Taunk","nipun@gmail.com","Male","Nipun@789","Surat",cs1),
				new Student("Aman","Bhadoriya","aman@gmail.com","Male","Aman@789","Gwalior",cs1),
				new Student("Abhinav","Shukla","abhinav@gmail.com","Male","Abhinav@789","Allahabad",cs1),
				new Student("Yashvardhan","Chauhan","yash@gmail.com","Male","Yash@789","Indore",cs1),
				new Student("Pratik","Agrawal","pratik@gmail.com","Male","Pratik@789","Pune",cs1),
				new Student("Deepesh","Kuwar","deepesh@gmail.com","Male","Deepesh@789","Allahabad",cs1),
				new Student("Kajal","Khidalkar","kajal@gmail.com","Female","Kajal@789","Nagpur",cs1),
				new Student("Divyangi","Aggarwal","divyangi@gmail.com","Female","Divyangi@789","Delhi",cs1),
				new Student("Kajal","Kesare","kajalk@gmail.com","Female","Kajalk@789","Pune",cs2),
				new Student("Chaitrali","Shinde","chaitrali@gmail.com","Female","Chaitrali@789","Pune",cs2),
				new Student("Juilee","Bhave","juilee@gmail.com","Male","Juilee@789","Ratnagiri",cs2),
				new Student("Harshada","Choudhari","harshada@gmail.com","Female","Harshada@789","Dhule",cs2),
				new Student("Aishwarya","Dabhole","aishwarya@gmail.com","Female","Aishwarya@789","Islampur",cs2),
				new Student("Madhav","Mundhada","madhav@gmail.com","Male","Madhav@789","Amravati",cs2),
				new Student("Utkarsh","Deshmukh","utkarsh@gmail.com","Female","Utkarsh@789","Amravati",cs2),
				new Student("Mrunmayee","Chaudhari","mrunmayee@gmail.com","Female","Mrunmayee@789","Amravati",cs2),
				new Student("Dnyanvi","Bante","dnyanvi@gmail.com","Female","Dnyanvi@789","Nagpur",cs2),
				new Student("Jayesh","Jaiswal","jayesh@gmail.com","Male","Jayesh@789","Pune",cs2),
				new Student("Kanak","Murarka","kanak@gmail.com","Female","Kanak@789","Aurangabad",cs1),
				new Student("Tanmay","Bagdiya","tanmay@gmail.com","Male","Tanmay@789","Aurangabad",cs1)));
	}
	
	
	@Autowired
	SubjectRepository sbr;
	
	
	
	@Test
	void subjectData() {
		List<Course> cs = cr.findAll();
		Course cs1 = cs.get(0);
		Course cs2 = cs.get(1);
		sbr.saveAll(List.of(new Subject("Core Java", cs1),new Subject("DSA", cs1),new Subject("DBT", cs1), new Subject("WPT", cs1), new Subject("OS", cs1), new Subject("DOTNET", cs1), new Subject("J2EE",cs1), new Subject("SDM", cs1),
				new Subject("Linux Programming", cs2),new Subject("DBMS", cs2),new Subject("Python", cs2),new Subject("OOP Java", cs2),new Subject("Big Data Technologies", cs2),new Subject("Data Visualization", cs2),new Subject("Statistics", cs2),new Subject("Machine Learning", cs2)));
	}
	
	
	@Autowired
	AttendanceRepository ar;
	
	
	
	
	@Test
	void AttendanceData() {
		
		List<Student> s = sr.findAll();
		Student s1 = s.get(0);
		Student s2 = s.get(1);
		Student s3 = s.get(2);
		Student s4 = s.get(3);
		Student s5 = s.get(4);
		Student s6 = s.get(5);
		Student s7 = s.get(6);
		Student s8 = s.get(7);
		Student s9 = s.get(8);
		Student s10 = s.get(9);
		Student s11 = s.get(10);
		Student s12 = s.get(11);
		Student s13 = s.get(12);
		Student s14 = s.get(13);
		Student s15 = s.get(14);
		Student s16 = s.get(15);
		Student s17 = s.get(16);
		Student s18 = s.get(17);
		Student s19 = s.get(18);
		Student s20 = s.get(19);

		
		List<Subject> sb = sbr.findAll();
		Subject sb1 = sb.get(0);
		Subject sb2 = sb.get(1);
		Subject sb3 = sb.get(2);
		Subject sb4 = sb.get(3);
		Subject sb5 = sb.get(4);
		Subject sb6 = sb.get(5);
		Subject sb7 = sb.get(6);
		Subject sb8 = sb.get(7);
		Subject sb9 = sb.get(8);
		Subject sb10 = sb.get(9);
		Subject sb11 = sb.get(10);
		Subject sb12 = sb.get(11);
		Subject sb13 = sb.get(12);
		Subject sb14 = sb.get(13);
		Subject sb15 = sb.get(14);
		Subject sb16 = sb.get(15);

		ar.saveAll(List.of(new Attendance(80, sb1, s1),new Attendance(90, sb2, s1),new Attendance(85, sb3, s1), new Attendance(70, sb4, s1), new Attendance(100, sb5, s1),new Attendance(80, sb6, s1),new Attendance(75, sb7, s1), new Attendance(60, sb8, s1),
				new Attendance(60, sb1, s2),new Attendance(75, sb2, s2),new Attendance(85, sb3, s2), new Attendance(70, sb4, s2), new Attendance(99, sb5, s2),new Attendance(80, sb6, s2),new Attendance(76, sb7, s2), new Attendance(95, sb8, s2),
				new Attendance(70, sb1, s3),new Attendance(70, sb2, s3),new Attendance(85, sb3, s3), new Attendance(60, sb4, s3), new Attendance(76, sb5, s3),new Attendance(81, sb6, s3),new Attendance(77, sb7, s3), new Attendance(97, sb8, s3),
				new Attendance(90, sb1, s4),new Attendance(100, sb2, s4),new Attendance(90, sb3, s4), new Attendance(99, sb4, s4), new Attendance(87, sb5, s4),new Attendance(84, sb6, s4),new Attendance(79, sb7, s4), new Attendance(99, sb8, s4),
				new Attendance(80, sb9, s5),new Attendance(99, sb10, s5),new Attendance(85, sb11, s5), new Attendance(99, sb12, s5), new Attendance(89, sb13, s5),new Attendance(86, sb14, s5),new Attendance(78, sb15, s5), new Attendance(91, sb16, s5),
				new Attendance(95, sb9, s6),new Attendance(89, sb10, s6),new Attendance(75, sb11, s6), new Attendance(70, sb12, s6), new Attendance(98, sb13, s6),new Attendance(87, sb14, s6),new Attendance(80, sb15, s6), new Attendance(90, sb16, s6),
				new Attendance(61, sb9, s7),new Attendance(89, sb10, s7),new Attendance(85, sb11, s7), new Attendance(80, sb12, s7), new Attendance(97, sb13, s7),new Attendance(88, sb14, s7),new Attendance(81, sb15, s7), new Attendance(92, sb16, s7),
				new Attendance(77, sb9, s8),new Attendance(98, sb10, s8),new Attendance(85, sb11, s8), new Attendance(70, sb12, s8), new Attendance(79, sb13, s8),new Attendance(89, sb14, s8),new Attendance(85, sb15, s8), new Attendance(81, sb16, s8),
				new Attendance(67, sb9, s9),new Attendance(97, sb10, s9),new Attendance(65, sb11, s9), new Attendance(80, sb12, s9), new Attendance(68, sb13, s9),new Attendance(90, sb14, s9),new Attendance(89, sb15, s9), new Attendance(82, sb16, s9),
				new Attendance(78, sb1, s10),new Attendance(90, sb2, s10),new Attendance(85, sb3, s10), new Attendance(70, sb4, s10), new Attendance(69, sb5, s10),new Attendance(91, sb6, s10),new Attendance(85, sb7, s10), new Attendance(83, sb8, s10),
				new Attendance(88, sb1, s11),new Attendance(90, sb2, s11),new Attendance(80, sb3, s11), new Attendance(90, sb4, s11), new Attendance(99, sb5, s11),new Attendance(92, sb6, s11),new Attendance(85, sb7, s11), new Attendance(84, sb8, s11),
				new Attendance(89, sb1, s12),new Attendance(90, sb2, s12),new Attendance(85, sb3, s12), new Attendance(90, sb4, s12), new Attendance(78, sb5, s12),new Attendance(93, sb6, s12),new Attendance(95, sb7, s12), new Attendance(85, sb8, s12),
				new Attendance(81, sb1, s13),new Attendance(90, sb2, s13),new Attendance(95, sb3, s13), new Attendance(80, sb4, s13), new Attendance(87, sb5, s13),new Attendance(94, sb6, s13),new Attendance(95, sb7, s13), new Attendance(86, sb8, s13),
				new Attendance(80, sb1, s14),new Attendance(89, sb2, s14),new Attendance(90, sb3, s14), new Attendance(70, sb4, s14), new Attendance(88, sb5, s14),new Attendance(95, sb6, s14),new Attendance(78, sb7, s14), new Attendance(87, sb8, s14),
				new Attendance(92, sb1, s15),new Attendance(76, sb2, s15),new Attendance(85, sb3, s15), new Attendance(70, sb4, s15), new Attendance(98, sb5, s15),new Attendance(96, sb6, s15),new Attendance(79, sb7, s15), new Attendance(88, sb8, s15),
				new Attendance(98, sb1, s16),new Attendance(75, sb2, s16),new Attendance(85, sb3, s16), new Attendance(80, sb4, s16), new Attendance(89, sb5, s16),new Attendance(97, sb6, s16),new Attendance(88, sb7, s16), new Attendance(95, sb8, s16),
				new Attendance(99, sb1, s17),new Attendance(80, sb2, s17),new Attendance(90, sb3, s17), new Attendance(70, sb4, s17), new Attendance(90, sb5, s17),new Attendance(98, sb6, s17),new Attendance(89, sb7, s17), new Attendance(94, sb8, s17),
				new Attendance(97, sb1, s18),new Attendance(85, sb2, s18),new Attendance(85, sb3, s18), new Attendance(99, sb4, s18), new Attendance(99, sb5, s18),new Attendance(99, sb6, s18),new Attendance(98, sb7, s18), new Attendance(93, sb8, s18),
				new Attendance(94, sb9, s19),new Attendance(80, sb10, s19),new Attendance(85, sb11, s19), new Attendance(88, sb12, s19), new Attendance(89, sb13, s19),new Attendance(89, sb14, s19),new Attendance(90, sb15, s19), new Attendance(97, sb16, s19),
				new Attendance(67, sb9, s20),new Attendance(90, sb10, s20),new Attendance(85, sb11, s20), new Attendance(77, sb12, s20), new Attendance(99, sb13, s20),new Attendance(80, sb14, s20),new Attendance(90, sb15, s20), new Attendance(99, sb16, s20)));
	
	}

	
	@Autowired
	AdminRepository adr;	
	
	@Test
	void AdminData() {
		adr.saveAll(List.of(new Admin("admin@gmail.com", "Admin@123"),new Admin("adarsh@gmail.com","Adarsh@789")));

	}
	
	@Autowired
	ScheduleRepository sch;
	
	@Test
	void scheduleData() {
		List<Course> cs = cr.findAll();
		Course cs1 = cs.get(0);
		Course cs2 = cs.get(1);
		
		List<Subject> sb = sbr.findAll();
		Subject sb1 = sb.get(0);
		Subject sb2 = sb.get(1);
		Subject sb3 = sb.get(2);
		Subject sb4 = sb.get(3);
		Subject sb5 = sb.get(4);
		Subject sb6 = sb.get(5);
		Subject sb7 = sb.get(6);
		Subject sb8 = sb.get(7);
		Subject sb9 = sb.get(8);
		Subject sb10 = sb.get(9);
		Subject sb11 = sb.get(10);
		Subject sb12 = sb.get(11);
		Subject sb13 = sb.get(12);
		Subject sb14 = sb.get(13);
		Subject sb15 = sb.get(14);
		Subject sb16 = sb.get(15);
		
		sch.saveAll(List.of(new Schedule(LocalDateTime.parse("2023-03-14T08:00:00"),LocalDateTime.parse("2023-03-14T11:30:00"),"Class 001",cs1,sb1),
				new Schedule(LocalDateTime.parse("2023-03-14T13:00:00"),LocalDateTime.parse("2023-03-14T16:00:00"),"Class 001",cs1,sb8),
				new Schedule(LocalDateTime.parse("2023-03-15T09:00:00"),LocalDateTime.parse("2023-03-15T12:00:00"),"Class 001",cs1,sb4),
				new Schedule(LocalDateTime.parse("2023-03-15T18:00:00"),LocalDateTime.parse("2023-03-15T21:30:00"),"Class 001",cs1,sb2),
				new Schedule(LocalDateTime.parse("2023-03-16T10:00:00"),LocalDateTime.parse("2023-03-16T13:00:00"),"Class 001",cs1,sb5),
				new Schedule(LocalDateTime.parse("2023-03-16T15:00:00"),LocalDateTime.parse("2023-03-16T18:00:00"),"Class 001",cs1,sb7),
				new Schedule(LocalDateTime.parse("2023-03-14T10:00:00"),LocalDateTime.parse("2023-03-14T13:00:00"),"Lab 102",cs2,sb11),
				new Schedule(LocalDateTime.parse("2023-03-14T08:00:00"),LocalDateTime.parse("2023-03-14T12:00:00"),"Lab 102",cs2,sb12),
				new Schedule(LocalDateTime.parse("2023-03-16T09:30:00"),LocalDateTime.parse("2023-03-16T13:30:00"),"Lab 102",cs2,sb9),
				new Schedule(LocalDateTime.parse("2023-03-16T13:00:00"),LocalDateTime.parse("2023-03-16T16:00:00"),"Lab 102",cs2,sb15),
				new Schedule(LocalDateTime.parse("2023-03-17T18:00:00"),LocalDateTime.parse("2023-03-17T20:00:00"),"Lab 102",cs2,sb12)));
	}
}
	