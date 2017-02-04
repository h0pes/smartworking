<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/includes/header_user.jsp" />
<jsp:include page="/includes/column_left_home.jsp" />

<!-- start the middle column -->

<section>
    <h1>Welcome to the Smart Working application!</h1>
    <h3>User login successful. You are now logged in as: <%=session.getAttribute("name")%></h3>

    <p>You can use this application to plan your smart working days
    accordingly to the rules given by the Head of Office. You can plan
    a maximum of two days per week for the next two weeks.
    Managers must approve your planning or reject it.</p>
    
    <p>You can also check the Holiday planning for each member of the Office
    and easily export such calendar in Excel format.</p>

    <p>If you encounter any technical issue, please contact the technical
    department of the Office. Thank you very much for your collaboration.</p>
</section>

<!-- end the middle column -->

<jsp:include page="/includes/column_right_news.jsp" />
<jsp:include page="/includes/footer.jsp" />