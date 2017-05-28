<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Awesome book store</title>
</head>
<body>

<div>
    <table>
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>ISBN</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td><c:out value="${book.author.firstName}" /> <c:out value="${book.author.lastName}" /></td>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.isbn}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <h2>Add an author</h2>
    <form:form action="/addAuthor" method="post" modelAttribute="author">
        <table>
            <tr>
                <spring:bind path="firstName">
                    <td>
                        <form:label path="firstName">First name</form:label>
                    </td>
                    <td>
                        <form:input path="firstName" type="text"/>
                    </td>
                    <td>
                        <form:errors path="firstName" />
                    </td>
                </spring:bind>
            </tr>
            <tr>
                <spring:bind path="lastName">
                    <td>
                        <form:label path="lastName">Last name</form:label>
                    </td>
                    <td>
                        <form:input path="lastName" type="text"/>
                    </td>
                    <td>
                        <form:errors path="lastName" />
                    </td>
                </spring:bind>
            </tr>
            <tr>
                <spring:bind path="email">
                    <td>
                        <form:label path="email">Email</form:label>
                    </td>
                    <td>
                        <form:input path="email" type="text"/>
                    </td>
                    <td>
                        <form:errors path="email" />
                    </td>
                </spring:bind>
            </tr>
        </table>
        <button value="Submit" type="submit">Submit</button>
    </form:form>
</div>
<div>
    <h2>Add a book</h2>
    <form:form action="/addBook" method="post" modelAttribute="book">
        <table>
            <tr>
                <spring:bind path="isbn">
                    <td>
                        <form:label path="isbn">ISBN</form:label>
                    </td>
                    <td>
                        <form:input path="isbn" type="text"/>
                    </td>
                    <td>
                        <form:errors path="isbn" />
                    </td>
                </spring:bind>
            </tr>
            <tr>
                <spring:bind path="title">
                    <td>
                        <form:label path="title">Title</form:label>
                    </td>
                    <td>
                        <form:input path="title" type="text"/>
                    </td>
                    <td>
                        <form:errors path="title" />
                    </td>
                </spring:bind>
            </tr>
            <tr>
                <td>
                    <label for="authorId">Author</label>
                    <select name="authorId" id="authorId">
                        <c:forEach var="authorWithId" items="${authors}">
                            <option value="${authorWithId.id}">${authorWithId.firstName} ${authorWithId.lastName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <button value="Submit" type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>