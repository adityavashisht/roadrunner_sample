<%@ include file="../common/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>RoadRunner Shuttle Service</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
    <!-- Le styles -->
    <link href="<c:url value='/ui/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    <style type="text/css">
        html, body {
            height: 100%;
        }
        html {
            /*background: url(../../../ui/images/bg-k.png) repeat scroll 0 0 #585858;
            color: #333333;*/
            background: url("<c:url value='/ui/images/darkgrain.png'/>") repeat scroll 0 0 #EEEEEE;
        }
        body {
            /*background: url("//s3.amazonaws.com/wrapbootstrap/live/imgs/darkgrain.png") repeat scroll 0 0 #EEEEEE;*/
            background:url("<c:url value='/ui/images/background-top-shadow.png'/>") repeat-x scroll 0 0 transparent;
            font-size: 14px;
            font-family: "Lato","Helvetica Neue",Arial,sans-serif;
            margin:0;
        }

    </style>
    <link href="<c:url value='/ui/bootstrap/css/bootstrap-responsive.css'/>" rel="stylesheet">
    <link href="<c:url value='/ui/roadrunner/rr-override.css'/>" rel="stylesheet">
    <link href="<c:url value='/ui/yui2/container.css'/>" rel="stylesheet">
    <%--Datepicker css--%>
    <link rel="stylesheet" href="<c:url value='/ui/datepicker/css/datepicker.css'/>"/>

    <link rel="stylesheet" href="<c:url value='/ui/fontawesome/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/ui/roadrunner/rr.css'/>"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="<c:url value='/ui/fontawesome/css/font-awesome-ie7.min.css'/>"/>
    <![endif]-->
    <%--<!-- Fav and touch icons -->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- Le fav and touch icons -->--%>
    <% /** JQuery */ %>
    <script src="<c:url value='/ui/jquery/jquery.js'/>"></script>
    <script src="<c:url value='/ui/jquery/jquery.cookie.js'/>"></script>
    <script src="<c:url value='/ui/jquery/jquery.numeric.js'/>"></script>
    <script src="<c:url value='/ui/bootstrap/js/bootstrap.min.js'/>"></script>
    <%--Datepicker--%>
    <script src="<c:url value='/ui/datepicker/js/bootstrap-datepicker.js'/>"></script>
    <script src="<c:url value='/ui/underscore/underscore-min.js'/>"></script>

</head>

