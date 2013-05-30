<%@ include file="../../views/common/includes.jsp" %>
<div class="container">
    <div class="row-fluid">
        <div class="span9 inner">
            <div class="panelHead b">RESERVATION - SUCCESS</div>
            <div class="panelBody">
                <div class="row-fluid mt5">
                    <div class="span1"></div>
                    <div class="span10 f12em">
                        <c:choose>
                            <c:when test="${! empty reservationNumber}">
                                <div class="alert alert-success">
                                    <i class="icon-1x icon-check"></i> <span class="b">Success.</span> Your confirmation
                                    number
                                    is : <span
                                        class="b"># ${reservationNumber}</span>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="alert alert-danger">
                                    <i class="icon-1x icon-remove"></i> <span class="b">System error.</span>
                                    <span class="b red"><form:errors path="routeStepOne.systemError"
                                                                     cssClass="red"/></span>
                                </div>

                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="span1"></div>
                </div>

                <c:if test="${! empty reservationNumber}">
                    <hr class="soften"/>

                    <div class="row-fluid center"><h4><i class="icon-print icon-large"
                                                         onclick="javascript:window.print();"></i> Reservation Summary
                    </h4>
                    </div>
                    <div class="row-fluid">
                        <div class="span1"></div>
                        <div class="span10">
                            <jsp:include page="trip_summary_read_only.jsp"/>
                            <c:choose>
                                <c:when test="${reservationForm.routeStepOne.directionType.direction eq 'R'}">
                                    <jsp:include page="arrival_read_only.jsp"/>
                                    <jsp:include page="departure_read_only.jsp"/>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${reservationForm.routeStepOne.routeType.direction eq 'F'}">
                                        <jsp:include page="arrival_read_only.jsp"/>
                                    </c:if>
                                    <c:if test="${reservationForm.routeStepOne.routeType.direction eq 'T'}">
                                        <jsp:include page="departure_read_only.jsp"/>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                            <jsp:include page="passenger_read_only.jsp"/>
                        </div>
                        <div class="span1"></div>
                    </div>
                </c:if>


            </div>
            <jsp:include page="shuttle.jsp" flush="true"/>


        </div>
        <jsp:include page="right_menu.jsp"/>
    </div>

</div>
<%--MSN CONVERSION CODE--%>
<script type="text/javascript"> if (!window.mstag) mstag = {loadTag: function () {
}, time: (new Date()).getTime()};</script>
<script id="mstag_tops" type="text/javascript"
        src="//flex.atdmt.com/mstag/site/8ce2ee54-e260-4377-ae40-76fa1833ab58/mstag.js"></script>
<script type="text/javascript"> mstag.loadTag("analytics", {dedup: "1", domainId: "2262509", type: "1", revenue: "", actionid: "118945"})</script>
<noscript>
    <iframe src="//flex.atdmt.com/mstag/tag/8ce2ee54-e260-4377-ae40-76fa1833ab58/analytics.html?dedup=1&domainId=2262509&type=1&revenue=&actionid=118945"
            frameborder="0" scrolling="no" width="1" height="1" style="visibility:hidden;display:none"></iframe>
</noscript>
<!-- Google Code for Order Conversion Page -->
<script type="text/javascript">
    /* <![CDATA[ */
    var google_conversion_id = 988736665;
    var google_conversion_language = "en";
    var google_conversion_format = "3";
    var google_conversion_color = "ffffff";
    var google_conversion_label = "s9S_CMf6ggUQmdm71wM";
    var google_conversion_value = 40;
    /* ]]> */
</script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
    <div style="display:inline;">
        <img height="1" width="1" style="border-style:none;" alt=""
             src="//www.googleadservices.com/pagead/conversion/988736665/?value=40&amp;label=s9S_CMf6ggUQmdm71wM&amp;guid=ON&amp;script=0"/>
    </div>
</noscript>
