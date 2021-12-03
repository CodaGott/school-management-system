# School Management System
    

#DATABASE

- Student
  
            -firstName
            -lastName;
            -age;
            -email;
            -Parent
            -Address
            -Class
            -List<Course>
            -List<Teacher>
            -Role
            -scores;
- Teacher
  
            -firstName
            -lastName
            -age
            -email
            -Address
            -List<Course>
            -List<Class>
            -List<Student>
            -Role
        

- Courses
    
            -name
            -time
            -List<Student>
            -score
            -remark
  
- Class

      -name
      -List<Course>
      -List<Student>
      -List<Teacher>
  
      
- Guardian

      -firstName
      -lastName
      -email
      -Role
      -Address
      -List<Student>




- Admin

        -firstName
        -lastName
        -email
        -Role
        -Address
        -List<Student>





#REQUIREMENT - Functional and non-Functional

#Functional Requirements

- Teacher can
  
      -Register
      -Confirm email
      -Login
      -Logout
      -Add Student
      -Enter Courses for Students
      -Delete Student
      -Update Student Info(Add Scores)
      -View All Students
      -View Course Assigned to Him/Her
      -Search For Specific Student
      -Update Profile
      -Change Password
      -Change Password

- Admin can

      -Register
      -Confirm email
      -Login
      -Logout
      -Add Teacher, Student
      -Enter Courses for Students
      -Delete Student, Teacher, Parent
      -Update Student, Teacher, Parent Info
      -Assign Course Teacher
      -View Course Assigned to Him/Her
      -Search For Specific Student, Teacher
      -Search For All Students, Teachers
      -Update Profile
      -Change Password
      -Change Password


- Guardian

      -Register
      -Confirm email
      -Login
      -Logout
      -Update Profile
      -Change Password
      -Change Password
      -View Student's (Child's) Profile

- Student

      -Register
      -Confirm email
      -Login
      -Logout
      -Update Profile
      -Change Password
      -Change Password
