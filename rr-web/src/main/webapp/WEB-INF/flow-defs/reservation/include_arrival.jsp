<%@ include file="../../views/common/includes.jsp" %>


<div class="row-fluid mt10">
    <div class="span1"></div>
    <div class="span10">
        <span class="f13em muted">
        <i class="icon-fighter-jet orange"></i> Flight Information
            (From Airport)
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
                <input type="text" class="span12" name="routeStepTwo.arrivalInfo.travelInfo.date"
                       id="travelDate"
                       value="<joda:format value='${reservationForm.routeStepTwo.arrivalInfo.travelInfo.date}' pattern='MM/dd/yyyy'/>">
                <script>
                    $(function () {
                        $("#travelDate").datepicker();
                    });
                </script>
            </div>
            <div class="span2 bbg"><label class="lbl b">Arrival Time <span class="red">*</span></label></div>
            <div class="span4">
                <div class="row-fluid">
                    <form:select path="routeStepTwo.arrivalInfo.travelInfo.hourFlight" cssClass="span5" id="flightHour">
                        <form:options items="${hourFlight}" id="hour" itemValue="hour" itemLabel="displayValue"/>
                    </form:select>
                    <form:select path="routeStepTwo.arrivalInfo.travelInfo.minuteFlight" cssClass="span4"
                                 id="flightMinute">
                        <form:options items="${minuteFlight}" itemValue="minute" itemLabel="minute"/>
                    </form:select>
                    <span id="amPmValue f09em"></span>
                </div>
            </div>
        </div>

        <div class="row-fluid pt3">
            <div class="span2 bbg"><label class="lbl b">Airline <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.arrivalInfo.travelInfo.airlineName" cssClass="span12"
                            id="airlineCode" placeholder="Start Typing"/>
                <form:hidden path="routeStepTwo.arrivalInfo.travelInfo.airlineId" id="arrivalAirlineId"/>
                <script>
                    var arrivalMap = {};
                    var arrivalAirlines = [];
                    $('#airlineCode').typeahead({
                        source: function (query, process) {
                            return $.get('<c:url value="/reference/airlines"/>', { query: query }, function (data) {
                                $.each(data.options, function (i, airline) {
                                    arrivalMap[airline.entityValue] = airline;
                                    arrivalAirlines.push(airline.entityValue);
                                });
                               process(arrivalAirlines);
                            });
                        },
                        updater: function (item) {
                            var entityKey = arrivalMap[item].entityKey;
                            $("#arrivalAirlineId").val(entityKey);
                            arrivalMap = {};
                            arrivalAirlines = []
                            return item;
                        }
                    });
                </script>
                <form:errors path="routeStepTwo.arrivalInfo.travelInfo.airlineName" cssClass="red"/>
            </div>
            <div class="span2 bbg"><label class="lbl b">Number <span class="red">*</span></label></div>
            <div class="span4">
                <form:input path="routeStepTwo.arrivalInfo.travelInfo.flightNumber" cssClass="span10 positive"
                            maxlength="7"/>
                <form:errors path="routeStepTwo.arrivalInfo.travelInfo.flightNumber" cssClass="red"/>
            </div>
        </div>


        <div class="row-fluid pt3">
            <div class="span2 bbg"><label class="lbl b">Type <span class="red">*</span></label></div>
            <div class="span4">
                <form:select path="routeStepTwo.arrivalInfo.travelInfo.flightRegion" cssClass="span12"
                             id="regionSelect"> ">
                    <form:options items="${flightRegions}" itemValue="code" itemLabel="selection"/>
                </form:select>
            </div>

            <div class="span2 pt5">
                <button id="pickUpTimeArvButton" class="btn btn-mini btn-block btn-warning">Pickup Time</button>
                <script>
                    $(function () {
                        $("#pickUpTimeArvButton").click(function (event) {
                            event.preventDefault();
                            getTravelTime();
                        });
                    });
                </script>
            </div>
            <div class="span4">
                <input type="text" id="pickUpTime" class="span10 positive" readonly="true" disabled="disabled" placeholder="Click PickUp Time">
                <form:errors path="routeStepTwo.arrivalInfo.travelInfo.pickUpTime" cssClass="red"/>
            </div>
        </div>
    </div>
    <div class="span1"></div>
</div>

