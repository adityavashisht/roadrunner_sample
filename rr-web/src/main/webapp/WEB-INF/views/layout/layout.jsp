<%@ include file="../common/includes.jsp" %>
<tiles:insertAttribute name="html-header"/>
<body>
<!-- ClickTale Top part -->
<script type="text/javascript">
    var WRInitTime=(new Date()).getTime();
</script>
<!-- ClickTale end of Top part -->
<tiles:insertAttribute name="banner"/>
<div id="wrap">
   <div class="container mt20">
        <div class="center">
            <h3 class="hd">&nbsp;</h3>
        </div>
    </div>
    <tiles:insertAttribute name="body"/>
    <div id="push"></div>
</div>
<tiles:insertAttribute name="footer"/>
<script>
    $(function () {
        $(".positive").numeric({ negative: false }, function () {
            this.value = "";
            this.focus();
        });
    });
</script>
<%--CRAZY EGG--%>
<script type="text/javascript">
    setTimeout(function () {
        var a = document.createElement("script");
        var b = document.getElementsByTagName("script")[0];
        a.src = document.location.protocol + "//dnn506yrbagrg.cloudfront.net/pages/scripts/0016/5518.js?" + Math.floor(new Date().getTime() / 3600000);
        a.async = true;
        a.type = "text/javascript";
        b.parentNode.insertBefore(a, b)
    }, 1);
</script>
<%--OPTIMIZELY--%>
<script src="//cdn.optimizely.com/js/191389174.js"></script>

<%--GOOGLE TRACKER--%>
<script type="text/javascript">

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-38448309-2']);
    _gaq.push(['_setDomainName', 'gorrshuttle.com']);
    _gaq.push(['_setAllowLinker', true]);
    _gaq.push(['_trackPageview']);

    (function () {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();

</script>

<script src="<c:url value='/ui/jquery-validate/jquery.validate.min.js'/>"></script>
<script src="<c:url value='/ui/jquery-validate/additional-methods.min.js'/>"></script>

<%--CLICKTALE--%>
<!-- ClickTale Bottom part -->
<div id="ClickTaleDiv" style="display: none;"></div>
<script type='text/javascript'>
    document.write(unescape("%3Cscript%20src='"+
            (document.location.protocol=='https:'?
                    'https://clicktalecdn.sslcs.cdngc.net/www/':
                    'http://s.clicktale.net/')+
            "WRd.js'%20type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
    ClickTaleFetchFromWithCookies.setFromCookie("JSESSIONID");
    // add a similar line for each additional cookie variable

    ClickTaleFetchFrom = ClickTaleFetchFromWithCookies.constructFetchFromUrl();
    var ClickTaleSSL=1;
    if(typeof ClickTale=='function') ClickTale([!YOUR PARAMETERS!]);
</script>
<!-- ClickTale end of Bottom part -->
</body>
</html>