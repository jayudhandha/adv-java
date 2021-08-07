<html>
<body>
<!-- <h2>Hello World!</h2> -->

<!-- <form method="POST" action="saveStudents">
	<input type="text" name="name" placeholder="Name"/>
	<input type="text" name="email" placeholder="Email"/>
	<input type="text" name="rollNo" placeholder="RollNo"/>
	<input type="submit" />
</form>
 -->
 
 <!-- 
 1. Scriptlet tag : Used to write java code inside jsp
 2. Expression tag : Used to print some expressions (or messages) on browser
 3. Declaration tag : Used to declare variables & functions
 
 
  <% 
  	out.println("Hello Scriptlet tag");
  %>
  
   <%= "Hello from Expression tag"%> 
  
-->
 <%! String name = "Jayesh"; %>
 
  <%! int square(int n) {
	  return n*n;
  }; %>
 
 <%= "Hello "+name%> 
 </br>
  <%= "Square of 5 : "+square(5)%> 
 
  
 </body>
</html>
