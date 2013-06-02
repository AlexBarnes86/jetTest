<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h1>Hello From Spring &gt; Jetty &gt; Spring</h1>
	<h2>${msg}</h2>
	
	<form method="POST">
		<fieldset>
			<legend>POST Request</legend>
			<button type="submit">Push Me</button>
		</fieldset>
	</form>
</body>
</html>
