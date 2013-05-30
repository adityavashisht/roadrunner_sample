<%@ include file="../../views/common/includes.jsp" %>
<div class="row-fluid well well-small">
    <label class="b f11em lbl pt1 bg-blue-nopad pl5"><i class="icon-user green"></i> Passenger
        Information</label>


    <table class="formTable twoColumn vTop">
        <tbody>
        <tr>
            <th>First Name</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.firstName}</td>
            <th>Last Name</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.firstName}</td>

        </tr>
        <tr>
            <th>Phone</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.cellPhone.number}</td>
            <th>Email</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.email}</td>
        </tr>

        <tr>
            <th>Address</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.address.addressLine}</td>
            <th>City</th>
            <td>${reservationForm.routeStepTwo.travelerInfo.contactInformation.address.city}</td>
        </tr>
        </tbody>
    </table>
</div>