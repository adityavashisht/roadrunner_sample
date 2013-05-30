<%@ include file="../../views/common/includes.jsp" %>
<script>

var URL = 'http://maps.googleapis.com/maps/api/directions/json?origin=${reservationForm.routeStepOne.zipCode}&destination=${reservationForm.routeStepOne.airportZipCode}&sensor=false&mode=driving';
var routeType = '${reservationForm.routeStepOne.routeType.direction}';

// delays and current time settings
var domesticDelay = 7200;// time in seconds
var internationalDelay = 14400;
var defaultDelay = 7200;

/**
 * Load Travel Times between two zip codes
 */
function getDepTravelTime() {
    var timeToTravel;
    var timeToTravelMinutes;
    var selectedDate = $("#depTravelDate").val();
    if (selectedDate != undefined && selectedDate != '') {
        $.ajax({
            type: "GET",
            url: URL,
            dataType: "json",
            success: function (data) {
                timeToTravel = data.routes[0].legs[0].duration.value;
                timeToTravelMinutes = data.routes[0].legs[0].duration.text;
                if (timeToTravelMinutes != undefined) {
                    //$("#timeToTravel").empty().html(timeToTravelMinutes);
                    $("#timeToTravelValue").val(timeToTravelMinutes);
                    getDeparturePickUpTime(timeToTravel);

                }
            },
            error: function (data) {
            }
        });
    }
}

/**
 * Load Travel Times between two zip codes
 */
function getTravelTime() {
    var timeToTravel;
    var timeToTravelMinutes;
    var selectedDate = $("#travelDate").val();
    if (selectedDate != undefined && selectedDate != '') {
        $.ajax({
            type: "GET",
            url: URL,
            dataType: "json",
            success: function (data) {
                timeToTravel = data.routes[0].legs[0].duration.value;
                timeToTravelMinutes = data.routes[0].legs[0].duration.text;
                if (timeToTravelMinutes != undefined) {
                    //$("#timeToTravel").empty().html(timeToTravelMinutes);
                    $("#timeToTravelValue").val(timeToTravelMinutes);
                    getArrivalPickUp();
                }
            },
            error: function (data) {
            }
        });
    }
}


/**
 *  Departure pick up time
 *
 */
/**
 *  Departure pick up time
 *
 */
function getDeparturePickUpTime(timeToTravel) {
    var regionSelect = $("#depRegionSelect").val();
    var flightHour = parseInt($("#depFlightHour").val());
    var flightMinute = parseInt($("#depFlightMinute").val());

    var selectedDate = $("#depTravelDate").val();
    var parts = selectedDate.split("/");

    var month = parts[0];
    month = month.replace(/^0+/, "");
    var day = parts[1];
    day = day.replace(/^0+/, "");
    var now = new Date(Number(parts[2]), month - 1, day);
    var year = parseInt(now.getYear());

    var selectedFlightTimeInSeconds = new Date(year, month - 1, day, flightHour, flightMinute).getTime() / 1000;
    var delay;
    if (regionSelect != undefined) {
        if ('D' == regionSelect) {
            delay = domesticDelay;
        }
        else {
            delay = internationalDelay;
        }
    }
    else {
        // default to two hours
        delay = defaultDelay;
    }

    timeToTravel = timeToTravel + delay;
    var pickUpTime = selectedFlightTimeInSeconds - timeToTravel;
    updateDeparturePickUpTimes(pickUpTime);
}

function updateDeparturePickUpTimes(pickUpTime) {
    var pickUpDate = new Date(pickUpTime * 1000);
    var pickUpHour = parseInt(pickUpDate.getHours());
    var pickUpMinute = parseInt(pickUpDate.getMinutes());
    var flightHour = parseInt($("#depFlightHour").val());

    var selectedDate = $("#depTravelDate").val();
    var parts = selectedDate.split("/");

    var month = parts[0];
    month = month.replace(/^0+/, "");
    var day = parts[1];
    day = day.replace(/^0+/, "");
    var now = new Date(Number(parts[2]), month - 1, day);

    var fullYear = parseInt(now.getUTCFullYear());
    var amPm = 'AM';
    if (flightHour > 11) {
        $("#amPmValue").html('PM');
        $("#depFlightTimeAmPm").val('PM');
        amPm = 'PM';
    }
    else {
        $("#depAmPmValue").html('AM');
        $("#depFlightTimeAmPm").val('AM');
    }

    var todayDate = parseInt(now.getDate());
    var utcDay;
    var utcMonth = parseInt(now.getMonth() + 1);
    // decrement day if a midnight flight is selected, falling behind by one day
    if (amPm == 'AM') {

        if (todayDate - 1 == 0) {
            var temp = month - 1;
            utcDay = new Date(fullYear, temp, 0).getDate();
            utcMonth = temp;
        }
        else {
            // decrement day only if the hour is in PM, that is a day before the flight
            if (pickUpHour > 12) {
                utcDay = parseInt(now.getDate()) - 1;
            }
            else {
                utcDay = parseInt(now.getDate());
            }
        }
    }
    else {
        utcDay = todayDate;
    }

    if (pickUpMinute < 10) {
        pickUpMinute = '0' + pickUpMinute;
    }

    var pickUpTimeAmPm = 'AM';
    if (pickUpHour < 10) {
        pickUpHour = '0' + pickUpHour;
    }
    else {
        if (pickUpHour != undefined && pickUpHour >= 12) {
            pickUpTimeAmPm = 'PM';
            pickUpHour = pickUpHour - 12;
            if (pickUpHour < 10) {
                pickUpHour = '0' + pickUpHour;
            }
        }
    }
    var timeValue = pickUpHour + ':' + pickUpMinute + ' ' + pickUpTimeAmPm;
    $("#amOrPm").val(pickUpTimeAmPm);

    //MM/dd/yyyy HH:mm
    if (utcMonth < 10) {
        utcMonth = '0' + utcMonth;
    }
    if (utcDay < 10) {
        utcDay = '0' + utcDay;
    }
    var persistTimeValue = '' + utcMonth + '/' + utcDay + '/' + fullYear + ' ' + pickUpHour + ':' + pickUpMinute;
    $("#depPickUpTime").empty().val(timeValue);
    $("#depPickUpTimeValue").empty().val(persistTimeValue);

}


/**
 *
 */
function getArrivalPickUp() {
    var flightHour = parseInt($("#flightHour").val());
    var flightMinute = parseInt($("#flightMinute").val());
    var selectedDate = $("#travelDate").val();
    var parts = selectedDate.split("/");

    var month = parts[0];
    month = month.replace(/^0+/, "");
    var day = parts[1];
    day = day.replace(/^0+/, "");
    var now = new Date(Number(parts[2]), month - 1, day);
    var year = parseInt(now.getYear());

    var selectedFlightTimeInSeconds = new Date(year, month - 1, day, flightHour, flightMinute).getTime() / 1000;
    var pickUpTime = selectedFlightTimeInSeconds + (60 * 20);
    updateArrivalPickUpTimes(pickUpTime);
}

function updateArrivalPickUpTimes(pickUpTime) {
    var pickUpDate = new Date(pickUpTime * 1000);
    var pickUpHour = parseInt(pickUpDate.getHours());
    var pickUpMinute = parseInt(pickUpDate.getMinutes());
    var flightHour = parseInt($("#flightHour").val());

    var selectedDate = $("#travelDate").val();
    var parts = selectedDate.split("/");

    var month = parts[0];
    month = month.replace(/^0+/, "");
    var day = parts[1];
    day = day.replace(/^0+/, "");
    var now = new Date(Number(parts[2]), month - 1, day);

    var fullYear = parseInt(now.getUTCFullYear());

    var amPm = 'AM';
    if (flightHour > 11) {
        $("#amPmValue").html('PM');
        $("#flightTimeAmPm").val('PM');
    }
    else {
        $("#amPmValue").html('AM');
        $("#flightTimeAmPm").val('AM');
    }

    var pickUpTimeAmPm = 'AM';
    if (pickUpHour < 10) {
        pickUpHour = '0' + pickUpHour;
    }
    else {
        if (pickUpHour != undefined && pickUpHour >= 12) {
            pickUpTimeAmPm = 'PM';
            pickUpHour = pickUpHour - 12;
            if (pickUpHour < 10) {
                pickUpHour = '0' + pickUpHour;
            }
        }
    }
    var timeValue = pickUpHour + ':' + pickUpMinute + ' ' + pickUpTimeAmPm;
    $("#amOrPm").val(pickUpTimeAmPm);
    var utcMonth = pickUpDate.getMonth() + 1;
    var utcDay = pickUpDate.getDate();
    //MM/dd/yyyy HH:mm
    if (utcMonth < 10) {
        utcMonth = '0' + utcMonth;
    }
    if (utcDay < 10) {
        utcDay = '0' + utcDay;
    }
    var persistTimeValue = '' + utcMonth + '/' + utcDay + '/' + fullYear + ' ' + pickUpHour + ':' + pickUpMinute;
    $("#pickUpTime").empty().val(timeValue);
    $("#pickUpTimeValue").empty().val(persistTimeValue);
}

</script>