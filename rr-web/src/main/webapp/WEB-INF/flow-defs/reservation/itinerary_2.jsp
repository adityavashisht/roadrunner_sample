<%@ include file="../../views/common/includes.jsp" %>
<c:choose>
    <c:when test="${reservationForm.routeStepOne.directionType.direction eq 'R'}">
        <jsp:include page="round_trip_pickup.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="pickup.jsp"/>
    </c:otherwise>
</c:choose>
<div class="container">
<form:form name="reservationForm" modelAttribute="reservationForm" id="reservationForm"
           action="${flowExecutionUrl}" method="POST" cssClass="form-horizontal">
<input name="_eventId" id="_eventId" type="hidden"/>
<input type="hidden" name="_flowExecutionKey" id="_flowExecutionKey" value="${flowExecutionKey}"/>
<%--
STORE THE DURATION OF TRAVEL BETWEEN TWO ZIP CODES
FROM (ZIP) - AIRPORT(ZIP)
--%>
<input type="hidden" name="routeStepTwo.amOrPm" id="amOrPm" value="AM"/>
<input type="hidden" name="routeStepTeo.flightTimeAmPm" id="flightTimeAmPm" value=""/>
<input type="hidden" name="routeStepTwo.pickUpTime" id="pickUpTimeValue" value=""/>
<input type="hidden" name="routeStepTwo.routeStepTwo.pickUpTimeHourMinuteOnly" id="pickUpTimeHourMinuteOnly" value=""/>
<input type="hidden" name="routeStepTwo.timeToTravel" id="timeToTravelValue" value=""/>

<c:if test="${reservationForm.routeStepOne.directionType.direction eq 'R'}">
    <input type="hidden" name="routeStepTwo.departureAmPm" id="depAmOrPm" value="AM"/>
    <input type="hidden" name="routeStepTeo.departureFlightTimeAmPm" id="depFlightTimeAmPm" value=""/>
    <input type="hidden" name="routeStepTwo.departurePickUpTime" id="depPickUpTimeValue" value=""/>
    <input type="hidden" name="routeStepTwo.departurePickUpTimeHourMinuteOnly" id="depPickUpTimeHourMinuteOnly"
           value=""/>
</c:if>

<div class="row-fluid">
<div class="span9 inner">
<div class="panelHead b">RESERVATION - TRAVEL DETAILS</div>
<div class="panelBody">
<spring:bind path="*">
    <c:if test="${not empty status.errorMessages}">
        <div class="row-fluid bbg">
            <div class="span1"></div>
            <div class="span10 red center f12em b">
                <i class="icon-ban-circle red"></i> There are errors. Please correct <br/>
                <span class="help-inline"> <form:errors path="routeStepOne.systemError" cssClass="red"/></span>
            </div>
            <div class="span1"></div>
        </div>
    </c:if>
</spring:bind>

<div class="row-fluid mt15">
    <div class="span1"></div>

    <div class="span7">
        <span class="f13em muted mb5"><i class="icon-briefcase"></i> Travel Summary</span>

        <table class="formTable twoColumn vTop">
            <tbody>
            <tr>
                <th>Ride Type</th>
                <td> ${reservationForm.routeStepTwo.reservationFare.vehicleType}</td>
            </tr>
            <tr>
                <th> Trip Selection</th>
                <td>${reservationForm.routeStepOne.routeType.displayValue}
                    | ${reservationForm.routeStepOne.directionType.displayValue} </td>
            </tr>

            <tr>
                <th>Airport</th>
                <td>${reservationForm.routeStepOne.airportDisplayValue}</td>
            </tr>

            <tr>
                <th>ZipCode</th>
                <td>${reservationForm.routeStepOne.zipCode}</td>
            </tr>

            <tr>
                <th>Total Passengers</th>
                <td>${reservationForm.routeStepOne.onwardAdultCount} Adults
                    <c:if test="${reservationForm.routeStepOne.onwardChildCount ne '0'}">
                        - ${reservationForm.routeStepOne.onwardChildCount} Children
                    </c:if>
                </td>
            </tr>


            </tbody>
        </table>


    </div>
    <div class="span3 center">
        <label class="b f11em lbl pt1 bg-blue-nopad pl5">Total Price</label>

        <div class="frame">
            <div class="row-fluid">
                    <span class="green f14em b"
                          id="fareAmount">$ ${reservationForm.routeStepTwo.reservationFare.amount}</span>
            </div>
            <div id="showOriginal" class="row-fluid" style="display: none">
                <div><b>Fare</b>: ${reservationForm.routeStepTwo.reservationFare.amount}</div>
                <div><b>Gratuity</b>: <span
                        id="gratuityPercentage"></span>
                </div>
            </div>

            <div class="btn-group mt10" data-toggle="buttons-radio">
                <button type="button" class="btn btn-small" id="15">
                    15%
                </button>
                <button type="button" class="btn btn-small" id="20">
                    20%
                </button>

                <script>
                    $(function () {
                        //Default

                        $('#15').click(function () {
                            var $this = $(this);
                            // $this will contain a reference to the checkbox
                            if ($this.length == 1) {
                                $this.addClass("btn-warning active");
                                $("#20").removeClass("btn-warning");
                                $("#gratuity").val('15');
                                calculateFareWithGratuity();
                            }
                        });
                        $('#20').click(function () {
                            var $this = $(this);
                            // $this will contain a reference to the checkbox
                            if ($this.length == 1) {
                                $this.addClass("btn-warning");
                                $("#15").removeClass("btn-warning");
                                $("#gratuity").val('20');
                                calculateFareWithGratuity();
                            }
                        });
                    });
                </script>
            </div>
            <script>
                var originalFare = ${reservationForm.routeStepTwo.reservationFare.amount};
                /**
                 *
                 */
                $(function () {
                    var p = '' + ${reservationForm.routeStepTwo.reservationFare.gratuityPercentage};
                    if (p != '0') {
                        $("#gratuity").val(p);
                        calculateFareWithGratuity();

                        var selectorId = '#' + p;
                        var selected = $(selectorId);
                        if (selected != undefined) {
                            $(selected).addClass("btn-warning");
                        }
                    }
                });

                /**
                 *
                 * @param percentage
                 */
                function calculateFareWithGratuity() {
                    var percentage = $("#gratuity").val();
                    if (percentage != undefined && percentage != '0') {
                        var p = parseInt(percentage);
                        var pct = p / 100;
                        percentage = 1 + pct;
                        var total = percentage * originalFare;
                        var gratuity = pct * originalFare;
                        gratuity = parseFloat(gratuity).toFixed(2);
                        total = parseFloat(total).toFixed(2);
                        var origFare = $("#fareAmount");
                        origFare.empty();
                        origFare.html(total);
                        $("#showOriginal").show();
                        $("#gratuityPercentage").html(gratuity);
                    }
                }
            </script>

            <div class="row-fluid mt10">
                <div class="span6 bbg"><label class="pt3 f09em lbl b">Gratuity %</label></div>
                <div class="span6"> <form:input path="routeStepTwo.reservationFare.gratuityPercentage" cssClass="span10 positive" id="gratuity"
                                                onchange="calculateFareWithGratuity();"
                                                maxlength="2"/></div>
            </div>



        </div>
    </div>
</div>

<c:choose>
    <c:when test="${reservationForm.routeStepOne.directionType.direction eq 'R'}">
        <jsp:include page="include_arrival.jsp"/>
        <jsp:include page="include_departure.jsp"/>
    </c:when>
    <c:otherwise>
        <c:if test="${reservationForm.routeStepOne.routeType.direction eq 'F'}">
            <jsp:include page="include_arrival.jsp"/>
        </c:if>
        <c:if test="${reservationForm.routeStepOne.routeType.direction eq 'T'}">
            <jsp:include page="include_departure.jsp"/>
        </c:if>
    </c:otherwise>
</c:choose>


<div class="row-fluid mt0">
    <div class="span1"></div>
    <div class="span10">
        <span class="f13em muted">
        <i class="icon-user blue"></i> Passenger Information</span>
    </div>
    <div class="span1"></div>
</div>

<div class="row-fluid">
    <div class="span1"></div>
    <div class="span10 well well-small">
        <div class="row-fluid pt3">
            <div class="span2  bbg"><label class="lbl b">First Name <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.travelerInfo.contactInformation.firstName" cssClass="span12"/>
            </div>
            <div class="span2  bbg"><label class="lbl b">Last Name <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.travelerInfo.contactInformation.lastName" cssClass="span12"/>
            </div>
        </div>

        <div class="row-fluid pt3">
            <div class="span2  bbg"><label class="lbl b"> Cell Phone <span class="red">*</span> <%--<span
                    class="muted f08em">(day of travel)</span><span class="red">*</span>--%></label></div>
            <div class="span4">
                <script>
                    function digitsOnly(s) {
                        var re = /\D/g;
                        return s.replace(re, "");
                    }

                    function formatPhone(phone) {
                        var phoneValue = digitsOnly(phone.value);
                        phone.value = phoneValue;
                        if (phoneValue.length > 6) {
                            var areaCode = phoneValue.slice(0, 3);
                            var value1 = phoneValue.slice(3, 6);
                            var value2 = phoneValue.slice(6, Math.min(10, phoneValue.length));
                            var finalVal = areaCode + "-" + value1 + "-" + value2;
                            phone.value = finalVal;

                        } else {
                            if (phoneValue.length > 3) {
                                var areaCode = phoneValue.slice(0, 3);
                                var value1 = phoneValue.slice(3, Math.min(6, phoneValue.length));
                                phone.value = areaCode + "-" + value1;
                            }
                        }
                    }
                </script>
                <form:input path="routeStepTwo.travelerInfo.contactInformation.cellPhone.number" cssClass="span12"
                            maxlength="12" id="phoneNumber" onchange="formatPhone(this);"/>

            </div>
            <div class="span2  bbg"><label class="lbl b">Email <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.travelerInfo.contactInformation.email" cssClass="span12" maxlength="50"/>
                <form:errors path="routeStepTwo.travelerInfo.contactInformation.email" cssClass="red"/>
            </div>
        </div>

        <div class="row-fluid pt3">
            <c:choose>
                <c:when test="${reservationForm.routeStepOne.routeType.direction eq 'F'}">
                    <div class="span2  bbg"><label class="lbl b">Drop Off<span class="red">*</span></label></div>
                </c:when>
                <c:when test="${reservationForm.routeStepOne.routeType.direction eq 'T'}">
                    <div class="span2  bbg"><label class="lbl b">Pickup<span class="red">*</span></label></div>
                </c:when>
                <c:otherwise/>
            </c:choose>

            <div class="span4">
                <form:input path="routeStepTwo.travelerInfo.contactInformation.address.addressLine" cssClass="span12"  placeholder="Street Address (ex. 532 Main St)"
                            maxlength="50" />
                <form:errors path="routeStepTwo.travelerInfo.contactInformation.address.addressLine" cssClass="red"/>
            </div>
            <div class="span2  bbg"><label class="lbl b">City<span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.travelerInfo.contactInformation.address.city" cssClass="span12"
                            maxlength="20"/>
                <form:errors path="routeStepTwo.travelerInfo.contactInformation.address.city" cssClass="red"/>
            </div>
        </div>

            <%--<div class="row-fluid pt3">
                <div class="span2  bbg"><label class="lbl b">State <span class="red">*</span></label></div>
                <div class="span4">
                    <form:input path="routeStepTwo.arrivalInfo.travelInfo.address.state" cssClass="span12"
                                maxlength="20"/>
                    <form:errors path="routeStepTwo.arrivalInfo.travelInfo.address.state" cssClass="red"/>
                </div>
                <div class="span2  bbg"><label class="lbl b">Zip Code <span class="red">*</span></label></div>
                <div class="span4">
                    <form:input path="routeStepTwo.arrivalInfo.travelInfo.address.zip"
                                value="${reservationForm.routeStepOne.zipCode}" cssClass="span12 positive" maxlength="5"
                                readonly="true"/>
                    <form:errors path="routeStepTwo.arrivalInfo.travelInfo.address.zip" cssClass="red"/>
                </div>
            </div>--%>

    </div>
    <div class="span1"></div>
</div>


<div class="row-fluid">
    <div class="span1"></div>
    <div class="span10 form-actions">
        <div class="row-fluid">
            <div class="span1"></div>
            <div class="span10">
                <button id="back-btn" class="btn btn-large "><i
                        class="icon-arrow-left icon-large"></i> BACK
                </button>

                <button id="search-btn" class="btn btn-primary btn-large"><i
                        class="icon-arrow-right icon-large"></i> CONTINUE
                </button>
                <script>
                    $(function () {
                        $('#search-btn').click(function (event) {
                            document.getElementById("_eventId").value = "yes";
                        });

                        $('#back-btn').click(function (event) {
                            document.getElementById("_eventId").value = "no";
                        });
                    });
                </script>
            </div>
            <div class="span1"></div>
        </div>
    </div>
</div>


</div>

<jsp:include page="shuttle.jsp" flush="true"/>

</div>
<jsp:include page="right_menu.jsp"/>
</div>
</form:form>


</div>