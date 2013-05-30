<%@ include file="../../views/common/includes.jsp" %>
<div class="row-fluid well well-small">
    <label class="b f11em lbl pt1 bg-blue-nopad pl5">
        <i class="icon-briefcase blue"></i> Trip Summary</label>

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
            <td>${reservationForm.routeStepOne.airport}</td>
        </tr>

        <tr>
            <th>Zip</th>
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