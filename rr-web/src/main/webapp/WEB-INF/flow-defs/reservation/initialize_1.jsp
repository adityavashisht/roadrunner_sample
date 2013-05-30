<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../views/common/includes.jsp" %>
<div class="container">
<form:form name="reservationForm" modelAttribute="reservationForm" id="reservationForm"
           action="${flowExecutionUrl}" method="POST" cssClass="form-horizontal">
<input name="_eventId" id="_eventId" type="hidden"/>
<input type="hidden" name="_flowExecutionKey" id="_flowExecutionKey" value="${flowExecutionKey}"/>

<div class="row-fluid">

<div class="span9 inner">
<div class="panelHead b">Fare Quote &amp; Reservations - Start Here!</div>
<div class="panelBody inner">
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

<div class="row-fluid">
    <div class="span1"></div>
    <div class="span5 center">

        <label class="pt5 b f13em lbl"> Which way are you going <i class="icon-question-sign"></i></label>

        <div class="btn-group" data-toggle="buttons-radio">
            <c:choose>
                <c:when test="${reservationForm.routeStepOne.routeType.direction ne null}">
                    <script>
                        $(function () {
                            var selected = '${reservationForm.routeStepOne.routeType.direction}';
                            if (selected != undefined && selected == 'F') {
                                $("#fromButtonRadio").prop('checked', true);
                                $("#fromAirport").addClass('btn-warning active');
                            }
                            else if (selected != undefined && selected == 'T') {
                                $("#toButtonRadio").prop('checked', true);
                                $("#toAirport").addClass('btn-warning active');
                            }
                            /*else if (selected != undefined && selected == 'A') {
                             $("#atoAButtonRadio").prop('checked', true);
                             $("#airportToAirPort").addClass('btn-warning active');
                             }*/
                        });
                    </script>
                </c:when>
                <c:otherwise>
                    <script>
                        $(function () {
                            //Default
                            $("#fromButtonRadio").val('T');
                        });
                    </script>
                </c:otherwise>
            </c:choose>

            <button type="button" class="btn btn-small" id="fromAirport">
                From Airport
            </button>
            <button type="button" class="btn btn-small" id="toAirport">
                To Airport
            </button>
            <%--  <button type="button" class="btn btn-small" id="airportToAirPort">
                  Airport To Airport
              </button>--%>
            <form:hidden path="routeStepOne.routeType" id="fromButtonRadio"/>

            <script>
                $(function () {

                    $('#fromAirport').click(function () {
                        var $this = $(this);
                        // $this will contain a reference to the checkbox
                        if ($this.length == 1) {
                            $this.addClass("btn-warning active");
                            $("#toAirport").removeClass("btn-warning active");
                            $("#airportToAirPort").removeClass("btn-warning active");
                            $("#fromButtonRadio").val('F');
                        }
                    });

                    $('#toAirport').click(function () {
                        var $this = $(this);
                        // $this will contain a reference to the checkbox
                        if ($this.length == 1) {
                            $this.addClass("btn-warning");
                            $("#fromAirport").removeClass("btn-warning");
                            $("#airportToAirPort").removeClass("btn-warning");
                            $("#fromButtonRadio").val('T');
                        }
                    });

                    $('#airportToAirPort').click(function () {
                        var $this = $(this);
                        // $this will contain a reference to the checkbox
                        if ($this.length == 1) {
                            $this.addClass("btn-warning");
                            $("#fromAirport").removeClass("btn-warning");
                            $("#toAirport").removeClass("btn-warning");
                            $("#fromButtonRadio").val('A');
                        }
                    });

                });
            </script>


        </div>

        <form:errors path="routeStepOne.routeType" cssClass="red"/>
        <hr class="soften"/>
    </div>
    <div class="span5 center">
        <label class="pt5 b f13em lbl"> Round Trip <i class="icon-question-sign"></i></label>

        <div class="row-fluid">
            <div class="btn-group" data-toggle="buttons-radio">

                <c:if test="${reservationForm.routeStepOne.directionType.direction ne null}">
                    <script>
                        $(function () {
                            var selected = '${reservationForm.routeStepOne.directionType.direction}';
                            if (selected != undefined && selected == 'O') {
                                $("#oneWayRadio").prop('checked', true);
                                $("#oneWayButton").addClass('btn-warning active');
                            }
                            else if (selected != undefined && selected == 'R') {
                                $("#roundTripRadio").prop('checked', true);
                                $("#roundTripButton").addClass('btn-warning active');
                            }

                        });
                    </script>
                </c:if>

                <button type="button" class="btn btn-small btn-warning" id="oneWayButton">
                    One Way
                </button>

                <button type="button" class="btn btn-small" id="roundTripButton">
                    Round Trip
                </button>
                <form:hidden path="routeStepOne.directionType" id="roundTripRadio"/>
                <script>

                    $(function () {
                        //Default
                        $("#roundTripRadio").val('O');

                        $('#roundTripButton').click(function () {
                            var $this = $(this);
                            // $this will contain a reference to the checkbox
                            if ($this.length == 1) {
                                $this.addClass("btn-warning");
                                $("#oneWayButton").removeClass("btn-warning");
                                $("#roundTripRadio").val('R');
                                $("#passengerSelect").show();
                            }

                        });

                        $('#oneWayButton').click(function () {
                            var $this = $(this);
                            if ($this.length == 1) {
                                $this.addClass("btn-warning");
                                $("#roundTripButton").removeClass("btn-warning");
                                $("#roundTripRadio").val('O');
                                $("#passengerSelect").hide();
                                $("#roundTrip").hide();
                            }
                        });

                    });
                </script>

            </div>
        </div>
        <form:errors path="routeStepOne.directionType" cssClass="red"/>
        <hr class="soften"/>
    </div>
    <div class="span1"></div>
</div>


<div class="row-fluid mt5">
    <div class="span1"></div>
    <div class="span5 well well-small">
        <label class="b lbl">Airport <span class="red">*</span></label>
        <form:select path="routeStepOne.airport" cssClass="span12" id="airportCode">
            <form:option value="-1">Select</form:option>
            <form:options items="${airports}" itemValue="code" itemLabel="name"/>
        </form:select>
        <span class="help-inline"> <form:errors path="routeStepOne.airport" cssClass="red"/></span>


        <%--<label class="b lbl">Zip Code <span class="red">*</span></label>--%>
        <%-- <script>
             /* $(function () {
              toggleZipLandmarkSelect();
              });*/

             function toggleZipLandmarkSelect() {
                 var selection = $("#zipLandmarkSelect").val();
                 if (selection != undefined && 'Z' == selection) {
                     $("#zipCodeDiv").show();
                     //$("#landmarkDiv").hide();
                 }
                 else {
                     $("#zipCodeDiv").hide();
                     //$("#landmarkDiv").show();
                 }
             }
         </script>--%>
        <%--  <form:select path="routeStepOne.zipOrLandMarkSelect" cssClass="span12" id="zipLandmarkSelect">
              &lt;%&ndash;onchange="toggleZipLandmarkSelect();"&ndash;%&gt;
              <form:options items="${zipLandmarkSelect}" itemValue="code" itemLabel="selection"/>
          </form:select>--%>

        <div class="row-fluid" id="zipCodeDiv" <%--style="display:none;"--%>>
            <div class="span8">
                <label class="b lbl">Zip Code <span class="red">*</span></label>
                <form:input path="routeStepOne.zipCode" cssClass="span12 positive" maxlength="5"/>
                <span class="help-inline"> <form:errors path="routeStepOne.zipCode" cssClass="red"/></span>
            </div>
        </div>

        <div class="row-fluid pt15" id="landmarkDiv" style="display:none;">
            <div class="span8">
                <label class="b lbl">Landmark <span class="red">*</span> </label>
                <form:input path="routeStepOne.landmark" cssClass="span10" maxlength="50"/>
                <span class="help-inline"> <form:errors path="routeStepOne.landmark"
                                                        cssClass="red"/></span>
            </div>

        </div>

    </div>
    <div class="span5">
        <script>
            $(function () {
                $('#checkDifferentPassenger').click(function () {
                    var $this = $(this);
                    // $this will contain a reference to the checkbox
                    if ($this.is(':checked')) {
                        $("#roundTrip").show();
                    } else {
                        $("#roundTrip").hide();
                    }
                });
            });
        </script>

        <c:if test="${reservationForm.routeStepOne.differentPassengerCount}">
            <script>
                $(function () {
                    $("#passengerSelect").show();
                    $("#roundTrip").show();
                });
            </script>
        </c:if>

        <div class="row-fluid mt5" id="passengerSelect" style="display:none;">
            <div class="span12">
                <label class="checkbox b">
                    <form:checkbox path="routeStepOne.differentPassengerCount" id="checkDifferentPassenger"/>
                    # Passengers count different
                </label>
            </div>

        </div>

        <div id="onwardPassenger" class="row-fluid bg-blue mt5"><label id="passenger">Passengers</label></div>
        <div class="row-fluid mt10" id="oneWay">
            <div class="span6">
                <label class="b lbl">Adults</label>
                <form:select path="routeStepOne.onwardAdultCount" class="span10">
                    <form:option value="1"/>
                    <form:option value="2"/>
                    <form:option value="3"/>
                    <form:option value="4"/>
                    <form:option value="5"/>
                    <form:option value="6"/>
                    <form:option value="7"/>
                    <form:option value="8"/>
                </form:select>
            </div>
            <div class="span6">
                <label class="b lbl">Children <span class="muted f09em">Under 3 years</span></label>
                <form:select path="routeStepOne.onwardChildCount" class="span10">
                    <form:option value="0"/>
                    <form:option value="1"/>
                    <form:option value="2"/>
                    <form:option value="3"/>
                    <form:option value="4"/>
                    <form:option value="5"/>
                    <form:option value="6"/>
                    <form:option value="7"/>
                    <form:option value="8"/>
                </form:select>
            </div>
        </div>


        <div id="roundTrip" style="display: none;" class="mt10">
            <div id="returnPassenger" class="row-fluid bg-blue mt5"><label>Return Passengers</label></div>
            <div class="row-fluid">
                <div class="span6">
                    <label class="b lbl">Adults</label>
                    <form:select path="routeStepOne.returnAdultCount" class="span10">
                        <form:option value="1"/>
                        <form:option value="2"/>
                        <form:option value="3"/>
                        <form:option value="4"/>
                        <form:option value="5"/>
                        <form:option value="6"/>
                        <form:option value="7"/>
                        <form:option value="8"/>
                    </form:select>
                </div>
                <div class="span6">
                    <label class="b lbl">Children <span class="muted f09em">Under 3 years</span></label>
                    <form:select path="routeStepOne.returnChildCount" class="span10">
                        <form:option value="0"/>
                        <form:option value="1"/>
                        <form:option value="2"/>
                        <form:option value="3"/>
                        <form:option value="4"/>
                        <form:option value="5"/>
                        <form:option value="6"/>
                        <form:option value="7"/>
                        <form:option value="8"/>
                    </form:select>
                </div>
            </div>
        </div>

        <div class="row-fluid" id="promoCode">
            <label class="pt5 b lbl"> Promotion Code</label>
            <form:input path="routeStepOne.promotionCode" cssClass="span10"/>
        </div>


        <label class="checkbox b mt10 lbl">
            <input type="checkbox" value="" id="wheelChair">
            Wheel Chair Accessible?
        </label>


    </div>
    <div class="span1"></div>
</div>

<div class="row-fluid mb20 ">
    <div class="span1"></div>
    <div class="span10 center">
        <hr class="straight"/>
        <div class="row-fluid mt15">
            <button id="search-btn" class="btn btn-primary btn-large"><i class="icon-search icon-large"></i>Search
            </button>
            <button id="reset-btn" class="btn btn-large"><i class="icon-refresh icon-large"></i> Reset</button>
            <script>
                $(function () {
                    $('#search-btn').click(function (event) {
                        document.getElementById("_eventId").value = "yes";
                    });
                    $('#reset-btn').click(function (event) {
                        document.getElementById("_eventId").value = "clean";
                    });
                });
            </script>
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