<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="model.Film" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous"><link rel="stylesheet" href="coursework.css">
<link rel="stylesheet" href="/css/coursework.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">

<title>Bones films</title>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Bones Films</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="create.html">Add Films</a>
        </li>
        </ul>
        <form class="d-flex" action="controller" method="POST">
        <input class="form-control me-sm-2" type="text" placeholder="Search" name="id" >
        <input class="btn btn-secondary my-2 my-sm-0" type="submit" value="SEARCH">
      </form>
    </div>
  </div>
</nav>
</head>
<body>
<ul>
	<c:forEach items="${films}" var="s">
	<li><b> ${s.getId()} </b><li>
	<li> Title: ${s.getTitle()} <li>
	<li> Year: ${s.getYear()} <li>
	<li> Director: ${s.getDirector()} <li>
	<li> Stars: ${s.getStars()} <li>
	<li> Review: ${s.getReview()} <li>
	<form action="update" method="get">
	<input type="hidden" value="${s.getId()}" name="id">
	<input type="submit" value="UPDATE">
	</form>
	<form action="delete" method="POST">
	<input type="hidden" value="${s.getId()}" name="id">
	<input type="submit" value="DELETE">
	</form>
	</c:forEach>
</ul>


</body>
</html>