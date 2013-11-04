<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Weather</title>
  </head>
  <body>
    <h1>Weather report</h1>
    <p>
      The time now is ${serverTime}.
    </p>


    <spring:url var="action" value='/report' />
    <form:form method="GET" commandName="weather" action="${action}">
      <form:errors path="*" cssClass="errorblock" element="div" />
<%--
      <div class="zipform"> 
        Zip code: 
        <form:input path="zipCode" size="5" /> 
        <form:errors path="zipCode" cssClass="error" />   
        <input type="submit" value="go"/>
      </div>
 --%>
    </form:form>
</body>
</html>
