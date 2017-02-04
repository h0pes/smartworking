<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <nav>
      <ul>
          <li><a class="current" href="<c:url value='.' />">
                  Logout</a></li>
          <li><a class="current" href="<c:url value='/userhome' />">
                  My Home Page</a></li>
          <li><a href="<c:url value='/input-planning' />">
                  Add smart working planning</a></li>        
          <li><a href="<c:url value='/view-my-requests' />">
                  View my smart working requests</a></li>
          <li><a href="<c:url value='/edit-my-requests' />">
                  Edit my smart working requests</a></li>        
          <li><a href="<c:url value='/view-all-requests' />">
                  View Office smart working requests</a></li>
          <li><a href="<c:url value='/search-holidays' />">
                  View Office holidays</a></li>                         
          <li><a href="<c:url value='/send-email' />">
                  Send email</a></li>
      </ul>
    </nav>
</aside>