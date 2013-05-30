<%@ include file="../../views/common/includes.jsp" %>
<div class="row-fluid well well-small">
    <label class="b f11em lbl pt1 bg-blue-nopad pl5"><i class="icon-fighter-jet orange"></i> Flight
        Information
        (To Airport)</label>

    <table class="formTable twoColumn vTop">
        <tbody>
        <tr>
            <th>Airline</th>
            <td>${reservationForm.routeStepTwo.departureInfo.travelInfo.airlineName}</td>
            <th>PickUp Time</th>
            <td>${reservationForm.routeStepTwo.pickUpTime} ${reservationForm.routeStepTwo.amOrPm}</td>

        </tr>
        <tr>
            <th>Flight Date</th>
            <td><joda:format value='${reservationForm.routeStepTwo.departureInfo.travelInfo.date}'
                             pattern='MM/dd/yyyy'/></td>
            <th>Flight Time</th>
            <td>
                <joda:format value='${reservationForm.routeStepTwo.arrivalInfo.travelInfo.timeOfTravel}'
                             pattern='MM/dd/yyyy HH:mm a'/>

            </td>
        </tr>

        <tr>
            <th>Flight Number</th>
            <td>${reservationForm.routeStepTwo.departureInfo.travelInfo.flightNumber}</td>
            <th>Flight Type</th>
            <td>${reservationForm.routeStepTwo.departureInfo.travelInfo.flightRegionSelection}</td>
        </tr>
        </tbody>
    </table>
</div>