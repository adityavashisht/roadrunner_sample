<%@ include file="../../views/common/includes.jsp" %>
<div class="span3 inner">
    <img src="<c:url value='/ui/images/banner-launch.png'/>"/>
    <%--<div class="panelHead">CUSTOMER PORTAL</div>
    <div class="panelBody">

        &lt;%&ndash;<ul class="nav nav-list">
            <li class="nav-header">Reservations</li>
            <li class=""><a href="#">My Reservations</a></li>
            <li><a href="#">Cancellations</a></li>
            <li><a href="#">Vehicle Locator</a></li>
            <li><a href="#">Email Confirmation</a></li>
            <li class="divider"></li>
            <li><a href="#">Help</a></li>
        </ul>&ndash;%&gt;

    </div>--%>

    <%-- <div class="panelHead">Customer Support</div>
     <div class="panelBody">
         <h4 class="muted blue">
             <i class="icon-phone-sign cyan"></i> 1-800-316-9252
         </h4>

     </div>--%>

    <div class="panelHead mt10">Sign Up</div>
    <div class="panelBody">
        <div class="row-fluid">
            <div class="span12">
                <div class="input-prepend">
                    <span class="add-on"><i class="icon-envelope green"></i></span>
                    <input class="span10" id="prependedInput" class="span10" type="text" placeholder="Sign Up Email">
                </div>
            </div>
        </div>
        <div class="row-fluid mt10">
            <div class="span12">
                <button class="btn btn-block btn-info">Sign Up</button>
            </div>
        </div>
    </div>

    <div class="panelHead">Recent Tweets</div>
    <div class="panelBody">
        <a class="twitter-timeline" href="https://twitter.com/rrshuttle" data-widget-id="326399856748924928">Tweets by
            @rrshuttle</a>
        <script>!function (d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
            if (!d.getElementById(id)) {
                js = d.createElement(s);
                js.id = id;
                js.src = p + "://platform.twitter.com/widgets.js";
                fjs.parentNode.insertBefore(js, fjs);
            }
        }(document, "script", "twitter-wjs");</script>

    </div>


</div>