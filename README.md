- School Management System
    

    -DATABASE

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





REQUIREMENT - Functional and non Functional