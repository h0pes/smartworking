<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header_manager.jsp" />
<jsp:include page="/includes/column_left_homemanager.jsp" />

<!-- start the middle column -->

<section>
    <h1>Welcome to the Smart Working application!</h1>
    <h3>Manager login successful. You are now logged in as: <%=session.getAttribute("name")%></h3>

    <p>You can use this application to approve or reject smart working days
    requested by Office employees. It's also possible to see the employees Holidays
    planning and export it in Excel format.</p>

    <p>If you encounter any technical issue, please contact the technical
    department of the Office. Thank you very much for your collaboration.</p>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />
