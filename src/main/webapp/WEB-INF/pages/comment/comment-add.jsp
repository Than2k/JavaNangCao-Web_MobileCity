<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <c:forEach var="comment" items="${listComment }">     					 	
          <c:if test="${comment.hoTen ==  kh.hoten }">
               <!-- Message to the right -->
             <div class="direct-chat-msg right">
               <div class="direct-chat-info clearfix">
                 <span class="direct-chat-name pull-right">${comment.hoTen }</span>
                 <span class="direct-chat-timestamp pull-left">${comment.ngayBinhLuan }</span>
               </div>
               <!-- /.direct-chat-info -->
                <img class="direct-chat-img" src="../dist/img/user3-128x128.jpg" alt="message"> 
               <!-- /.direct-chat-img -->
               <div class="direct-chat-text">
                 ${comment.noiDung }
               </div>
               <!-- /.direct-chat-text -->
             </div>
             <!-- /.direct-chat-msg -->
          </c:if>
          <c:if test="${comment.hoTen !=  kh.hoten }">
                <!-- Message. Default to the left -->
             <div class="direct-chat-msg">
               <div class="direct-chat-info clearfix">
                 <span class="direct-chat-name pull-left">${comment.hoTen }</span>
                 <span class="direct-chat-timestamp pull-right">${comment.ngayBinhLuan }</span>
               </div>
               <!-- /.direct-chat-info -->
               <img class="direct-chat-img" src="../dist/img/user1-128x128.jpg" alt="message user image">
               <!-- /.direct-chat-img -->
               <div class="direct-chat-text">
                 ${comment.noiDung }
               </div>
               <!-- /.direct-chat-text -->
             </div>
             <!-- /.direct-chat-msg -->

          </c:if>
      </c:forEach>
   
