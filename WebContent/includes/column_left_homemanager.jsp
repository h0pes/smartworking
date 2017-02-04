<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
      <ul>
          <li><a class="current" href="<c:url value='.' />">
                  Logout</a></li>
          <li><a class="current" href="<c:url value='/managerhome' />">
                  My Home Page</a></li>
          <li><a href="<c:url value='/search-holidays' />">
                  View Office holidays</a></li>                   
          <li><a href="<c:url value='/view-requests' />">
                  View Requests for approval</a></li>
      </ul>
    </nav>
</aside>