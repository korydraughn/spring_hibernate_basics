<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName" />
			<br /><br />
				
			Last Name: <form:input path="lastName" />
			<br /><br />
			
			Country:
			<form:select path="country">
				<form:options items="${student.countryOptions}" />
			</form:select>
			<br /><br />
			
			Favorite Language:<br />
			<form:radiobutton path="favoriteLanguage" value="C++" /> C++<br />
			<form:radiobutton path="favoriteLanguage" value="Java" /> Java<br />
			<form:radiobutton path="favoriteLanguage" value="JavaScript" /> JavaScript<br />
			<form:radiobutton path="favoriteLanguage" value="Python" /> Python
			<br /><br />

			Operating Systems:<br />
			<form:checkbox path="operatingSystems" value="Linux" /> Linux<br />
			<form:checkbox path="operatingSystems" value="Mac OS" /> Mac OS<br />
			<form:checkbox path="operatingSystems" value="MS Windows" /> MS Windows
			<br /><br />

			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>