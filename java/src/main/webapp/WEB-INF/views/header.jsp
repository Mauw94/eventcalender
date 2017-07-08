<%--
  Created by IntelliJ IDEA.
  User: Mauwi
  Date: 8-7-2017
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mauwi Software</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- #fffde2 bg color -->
    <style>
        body {
            background: url("${pageContext.request.contextPath}/images/webbg.jpg") no-repeat fixed;
        }

        #sticky {
            width: 100%;
            padding: 20px 20px 16px;
            background: rgba(0, 0, 0, .25);
            color: white;
            font-size: 11px;
            text-align: center;
            position: fixed; /*Here's what sticks it*/
            bottom: 0; /*to the bottom of the body*/
            left: 0; /*and to the left of the body.*/

            /*EFFECTS*/
            transition: .33s linear;
        }

        #sticky:hover {
            background: black;
        }

        a:hover {
            text-decoration: none;
        }

        .logout {
            height: 100%;
            width: 100%;
            display: flex;
            position: fixed;
            align-items: center;
            justify-content: center;
        }

        .bodyDiv {
            width: 25%;
            margin: 0 auto;
            margin-top: 220px;
            align-items: center;
            justify-content: center;
        }

        .bodyDivAdd {
            width: 25%;
            margin: 0 auto;
            margin-top: 130px;
            align-items: center;
            justify-content: center;
        }

        .bodyDivTable {
            width: 50%;
            margin: 0 auto;
            margin-top: 220px;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<div class="w3-top">
    <div class="w3-bar w3-black w3-card-2">
        <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"><i
                class="fa fa-bars"></i></a>
        <a href="/eventcalender/login" class="w3-bar-item w3-button w3-padding-large">LOGIN</a>
        <a href="/eventcalender/logout" class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
        <a href="/eventcalender/events" class="w3-bar-item w3-button w3-padding-large w3-hide-small">AGENDA</a>
        <a href="/eventcalender/task" class="w3-bar-item w3-button w3-padding-large w3-hide-small">TASK MANAGEMENT</a>
    </div>
</div>
