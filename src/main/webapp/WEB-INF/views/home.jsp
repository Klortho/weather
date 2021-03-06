<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Weather</title>
    <link type="text/css" rel="stylesheet" 
      href="//dev-static.pubmed.gov/portal/portal3rc.fcgi/202457/css/202470/1725/202430.css" />
    <style>
      .error {
        color: #ff0000;
      }

      .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
      }
      #main {
        float: left;
        margin-left: 30%;
      }
    </style>
  </head>
  <body>
    <h1>Weather report</h1>
    <p>
      The time now is ${serverTime}.
    </p>
    <c:if test="${not empty weather.message}">
      <h3>
        <em><div class="climate nice">${weather.message}</div></em>
      </h3>
    </c:if>


    <form:form method="GET" commandName="weather">
      <form:errors path="*" cssClass="errorblock" element="div" />
      <div class="zipform"> 
        Zip code: 
        <form:input path="zipcode" size="5" /> 
        <form:errors path="zipcode" cssClass="error" />   
        <input type="submit" value="go"/>
      </div>

      <c:if test="${weather.isSubmit()}">
        <h2>Current Conditions</h2>
        <div class="cc">
          <div class="ccwrap">
            <h2>${weather.city}, ${weather.region}</h2>
            <div class="wimg">
              <img src="${weather.img}" alt="Image of current weather conditions" />
            </div>
            <div class="temp">${weather.temp} F</div>
            <div class="zip">Zip: ${weather.zipcode}</div>
          </div>
        </div>
  
        <h2>Forecast</h2>
        <div class="cf">
          <div class="cfwrap">
            <h3>For the ${weather.zipcode} area</h3>
            <c:forEach var="yWF" items="${weather.yWF_list}">
              <dl>
                <dt>${yWF.day}, ${yWF.date}</dt>
                <dd>
                  <p>Condition: ${yWF.text} with a high of ${yWF.high} and a low of 
                    ${yWF.low}</p>
                </dd>
              </dl>
            </c:forEach>
          </div>
        </div>
      </c:if>
    </form:form>
</body>
</html>
