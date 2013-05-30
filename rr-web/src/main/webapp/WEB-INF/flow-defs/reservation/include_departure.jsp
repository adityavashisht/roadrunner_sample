<%@ include file="../../views/common/includes.jsp" %>

<div class="row-fluid mt10">
    <div class="span1"></div>
    <div class="span10">
        <span class="f13em muted">
        <i class="icon-fighter-jet orange"></i> Flight Information
            (To Airport)
        </span>

    </div>
    <div class="span1"></div>
</div>

<div class="row-fluid">
    <div class="span1"></div>
    <div class="span10 well well-small">
        <div class="row-fluid pt3">
            <div class="span2 bbg"><label class="lbl b">Date <span class="red">*</span></label></div>
            <div class="span4">
                <input type="text" class="span12" name="routeStepTwo.departureInfo.travelInfo.date"
                       id="depTravelDate"
                       value="<joda:format value='${reservationForm.routeStepTwo.departureInfo.travelInfo.date}' pattern='MM/dd/yyyy'/>">
                <script>
                    $(function () {
                        $("#depTravelDate").datepicker();
                    });
                </script>
            </div>
            <div class="span2 bbg"><label class="lbl b">Dep. Time <span class="red">*</span></label></div>
            <div class="span4">
                <script>
                    function updateAmPm() {
                        var flightHour = $("#depFlightHour").val();
                        var value = parseInt(flightHour);
                        if (value > 11) {
                            $("#depAmOrPm").val("PM");
                        }
                        else {
                            $("#depAamOrPm").val("AM");
                        }
                    }
                </script>
                <div class="row-fluid">
                    <form:select path="routeStepTwo.departureInfo.travelInfo.hourFlight" cssClass="span5" id="depFlightHour" onchange="updateAmPm();">
                        <form:options items="${hourFlight}" itemValue="hour" itemLabel="displayValue"/>
                    </form:select>
                    <form:select path="routeStepTwo.departureInfo.travelInfo.minuteFlight" cssClass="span4" id="depFlightMinute">
                        <form:options items="${minuteFlight}" itemValue="minute" itemLabel="minute"/>
                    </form:select>

                </div>
            </div>
        </div>

        <div class="row-fluid pt3">
            <div class="span2 bbg"><label class="lbl b">Airline <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.departureInfo.travelInfo.airlineName" cssClass="span12"
                            id="depAirlineCode" placeholder="Start Typing"/>
                <form:hidden path="routeStepTwo.departureInfo.travelInfo.airlineId" id="departureAirlineId"/>
                <script>
                    var departureMap = {};
                    var departureAirlines = [];
                    $('#depAirlineCode').typeahead({
                        source: function (query, process) {
                            return $.get('<c:url value="/reference/airlines"/>', { query: query }, function (data) {
                                $.each(data.options, function (i, airline) {
                                    departureMap[airline.entityValue] = airline;
                                    departureAirlines.push(airline.entityValue);
                                });
                                process(departureAirlines);
                            });
                        },
                        updater: function (item) {
                            var entityKey = departureMap[item].entityKey;
                            $("#departureAirlineId").val(entityKey);
                            departureMap = {};
                            departureAirlines = [];
                            return item;
                        }
                    });
                </script>
                <form:errors path="routeStepTwo.departureInfo.travelInfo.airlineName" cssClass="red"/>
            </div>
            <div class="span2 bbg"><label class="lbl b">Number <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.departureInfo.travelInfo.flightNumber" cssClass="span10 positive" maxlength="7"/>
                <form:errors path="routeStepTwo.departureInfo.travelInfo.flightNumber" cssClass="red"/>
            </div>
        </div>


        <div class="row-fluid pt3">
            <div class="span2 bbg"><label class="lbl b">Type <span class="red">*</span></label></div>
            <div class="span4">
                <form:select path="routeStepTwo.departureInfo.travelInfo.flightRegion" cssClass="span12"
                             id="depRegionSelect"> ">
                    <form:options items="${flightRegions}" itemValue="code" itemLabel="selection"/>
                </form:select>
            </div>
            <div class="span2 bbg pt5">
                <button id="depPickUpTimeButton" class="btn btn-mini btn-block btn-warning">Pickup Time</button>
                <script>
                    $(function () {
                        $("#depPickUpTimeButton").click(function (event) {
                            event.preventDefault();
                            /*Please see pickup for this logic*/
                            getDepTravelTime();
                        });
                    });
                </script>
            </div>
            <div class="span4">
                <input type="text" id="depPickUpTime" class="span10 positive" readonly="true" disabled="disabled" placeholder="Click PickUp Time">
                <form:errors path="routeStepTwo.departureInfo.travelInfo.pickUpTime" cssClass="red"/>
            </div>

        </div>


    </div>
    <div class="span1"></div>
</div>

