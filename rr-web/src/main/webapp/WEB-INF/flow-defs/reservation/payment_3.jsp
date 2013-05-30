<%@ include file="../../views/common/includes.jsp" %>
<div class="container">
<form:form name="reservationForm" modelAttribute="reservationForm" id="reservationForm"
           action="${flowExecutionUrl}" method="POST" cssClass="form-horizontal">
<input name="_eventId" id="_eventId" type="hidden"/>
<input type="hidden" name="_flowExecutionKey" id="_flowExecutionKey" value="${flowExecutionKey}"/>

<div class="row-fluid">

<div class="span9 inner">
<div class="panelHead b">RESERVATION - PAYMENT</div>
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

<div class="row-fluid mt0">
    <div class="span1"></div>
    <div class="span10">
        <span class="f13em muted">
        <i class="icon-credit-card blue"></i> Credit Card Information</span> <span id="siteseal" class="pl20"><script
            type="text/javascript"
            src="https://seal.godaddy.com/getSeal?sealID=XZ1ysKlLamccRqLuPfDiMirdKUGbnz7MQcd6JJlTm8QmYWLWpdI6S1gWpHj2"></script></span>
    </div>
    <div class="span1"></div>
</div>

<div class="row-fluid mt5">
    <div class="span1"></div>
    <div class="span10">

        <div class="span7">
            <div class="row-fluid pt3">
                <label class="lbl b">Name <span class="red">*</span></label>
                <form:input path="routeStepThree.paymentInfo.cardHolderFullName" cssClass="span12" maxlength="80"
                            tabindex="1"/>
                <form:errors path="routeStepThree.paymentInfo.cardHolderFullName" cssClass="red"/>

                <label class="b pt5 lbl">Card Number <span class="red">*</span></label>
                <form:input path="routeStepThree.paymentInfo.creditCardNumber" cssClass="span12 positive"
                            maxlength="16" tabindex="2"/>
                <form:errors path="routeStepThree.paymentInfo.creditCardNumber" cssClass="red"/>

                <div class="row-fluid">
                    <div class="span6">
                        <label class="b pt5 lbl">Card Type <span class="red">*</span></label>
                        <form:select path="routeStepThree.paymentInfo.ccTypeId" cssClass="span12" id="cardTypeSelect">
                            <form:options items="${cardTypes}" itemValue="code" itemLabel="displayValue"/>
                        </form:select>
                        <form:errors path="routeStepThree.paymentInfo.ccTypeId" cssClass="red"/>
                    </div>
                    <div class="span6">
                        <label class="b pt5 lbl">Exp. Date <span class="red">*</span>
                        <span class="muted f09em">ex. 0713 for July 2013 </span>
                        </label>

                        <form:input path="routeStepThree.paymentInfo.expirationDate" cssClass="span12 positive"
                                    maxlength="4" tabindex="3"/>
                        <form:errors path="routeStepThree.paymentInfo.expirationDate" cssClass="red"/>

                    </div>
                </div>
            </div>

            <div class="row-fluid">
                <div class="span6">
                    <label class="b pt5 lbl">AVS Code <span class="red">*</span></label>
                    <form:input path="routeStepThree.paymentInfo.cvcCode" cssClass="span12 positive" maxlength="4"  tabindex="4"/>
                    <form:errors path="routeStepThree.paymentInfo.cvcCode" cssClass="red"/>
                </div>
                <div class="span6">
                    <label class="b pt5 lbl">Billing Zip Code <span class="red">*</span></label>
                    <form:input path="routeStepThree.paymentInfo.zip" cssClass="span12 positive" maxlength="5"  tabindex="5"/>
                    <form:errors path="routeStepThree.paymentInfo.zip" cssClass="red"/>
                </div>
            </div>

        </div>
        <div class="span5 center well">
            <div class="row-fluid center">
                <button id="back-btn" class="btn btn-block "><i
                        class="icon-arrow-left icon-large"></i> Back
                </button>
            </div>

            <div class="panelHead b mt15">AMOUNT CHARGED</div>
            <div class="panelBody">
                <c:choose>
                    <c:when test="${reservationForm.routeStepTwo.reservationFare.totalAmountWithGratuity ne null}">
                        <span class="green f14em b">$ ${reservationForm.routeStepTwo.reservationFare.totalAmountWithGratuity}</span>

                        <div id="showOriginal" class="row-fluid">
                            <div><b>Fare</b>: ${reservationForm.routeStepTwo.reservationFare.amount}</div>
                            <div><b>Gratuity</b>: <span
                                    id="gratuityPercentage">${reservationForm.routeStepTwo.reservationFare.gratuityAmount}</span>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <h3 class="green">$ ${reservationForm.routeStepTwo.reservationFare.amount}</h3>
                    </c:otherwise>
                </c:choose>


            </div>

            <div class="row-fluid center mt15">
                <button id="buy-btn" class="btn btn-success btn-block"><i
                        class="icon-arrow-right icon-large"></i> Purchase
                </button>
            </div>

            <script>
                $(function () {
                    $('#buy-btn').click(function (event) {
                        document.getElementById("_eventId").value = "yes";
                    });

                    $('#back-btn').click(function (event) {
                        document.getElementById("_eventId").value = "no";
                    });
                });

            </script>

            <span class="help inline f09em">
                <label class="checkbox">
                    <input type="checkbox" name="routeStepThree.terms"><span class="red">*</span> By clicking Purchase,
                    you agree to the
                    <a id="terms" href="#" data-toggle="modal">Terms</a> and <a id="policy" href="#"
                                                                                data-toggle="modal">Privacy Policy</a>
                </label>
                <form:errors path="routeStepThree.terms" cssClass="red"/>
            </span>
        </div>
    </div>
    <div class="span1"></div>
</div>
<div class="row-fluid center"><h4>Confirm Itinerary</h4></div>
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
</div>
<jsp:include page="shuttle.jsp" flush="true"/>
</div>
<jsp:include page="right_menu.jsp"/>
</div>
</form:form>


<script type="text/javascript">
    /**
     * Setup modals for terms and privacy sections
     */
    $(function () {
        $('#terms').click(function (event) {
            event.preventDefault();
            $('#myModal').modal('show');
        });

        $('#policy').click(function (event) {
            event.preventDefault();
            $('#myModalPrivacy').modal('show');
        });
    });
</script>

<%--<-- Modal -->--%>
<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" class="modal hide fade" id="myModal"
     style="display: none;">
<div class="modal-header">
    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">x</button>
    <h5 id="myModalLabel" class="center red">Terms of Use</h5>
</div>
<div class="modal-body">

<strong>Terms of Use</strong><br/>
<br/>
<strong>
    How this agreement works.
</strong>

<p>
    Introduction. Welcome to our website for desktop and mobile, GORRShuttlec.om or m.GORRShuttle.com, owned and
    operated by Shuttle Company of America, LLC. The Terms of Use Agreement ("Agreement") lists the terms of the
    agreement between you and Shuttle Company of America, LLC for pre-booking airport transportation, and all
    other services that we provide. By completing a reservation on GORRShuttle.com, you agree to accept the
    terms and conditions of this Agreement and to become a registered user of this Site.

    Modification. If we change this Agreement, we shall post a revised version of this Agreement here, which
    shall automatically replace the terms of this Agreement. Your continued use of the Site and the Services
    following GORRShuttle.com’s posting of a revised Agreement will constitute your acceptance of the revised
    Agreement. If you do not agree with the terms of this Agreement or any revised version of this Agreement, do
    not continue to use the Services or this Site.

    Additional Policies. This Agreement incorporates by reference the following policies and documents also
    found on this Site:

</p>

<strong>
    Privacy Policy
</strong>

<p>
    Reservation Purchase Policy. Our goal at GORRShuttle.com is to make your purchasing experience easy, efficient
    and equitable, so we can get you on your way to your travel destination. The following purchase policies are
    designed to ensure your satisfaction and understanding of the purchase process on GORRShuttle.com. If you have
    any questions about the information below, please contact us.
</p>

<strong>How to become a registered user</strong>

<p>
    Requirements. To be a registered user of this Site, you must agree to accept the terms and conditions of this
    Agreement, and you must have a valid credit or debit card that we accept (see Section Payment Methods below for
    further details). You may only use the Services if you are able to form legally binding contracts, are over the
    age of 18, and are not temporarily or indefinitely suspended from our Sites. If you do not qualify, please do
    not use or try to use the Services. If you are under the age of 18, you may only use this site in conjunction
    with and under the supervision of your parents or guardians.
</p>

<p>
    Registration. To register, you must provide an active email address, a valid credit or debit card and credit
    card, zip code and password. Your registration is accepted and completed after the reservation has been
    confirmed.
</p>

<p>
    Email Address and Password. You will need an email address and password to access the Registration Section of
    the Site. You are solely responsible for maintaining the security of your email address and password and for all
    activity that occurs under your email address and password. You should not disclose your password to any other
    person.
</p>

<p>
    Payment Methods: GORRShuttle.com accepts several methods of payment to accommodate your needs, including:
    American Express, Discover, MasterCard, and Visa.
</p>

<p>
    Pricing and Availability: GORRShuttle.com is the exclusive website for airport ground transportation
    reservations for owned and operated transportation services of Shuttle Company of America, LLC. We only offer
    FLAT RATES, so what we quote you for a flat rate, to/from the airport is guaranteed. Additional fees may apply,
    including but not limited to baggage fees. Gratuity is not included in the fare but can be added to your
    shopping cart.
</p>
<br/>

<strong>REFUNDS</strong>

<p>
    Service requested must be cancelled by booking party with a minimum of eight (8) hours in order to receive a
    full refund. Cancellations with less than six (6) hours notice is not refundable. Furthermore, unless otherwise
    prescribed by law, carrier reserves the right to refund any charges when service was not provided or completed
    by any conditions mentioned thereof on the liability rule No. 40.
</p>
<br/>

<strong>LIABILTY</strong>

<p>The carrier will not be liable for delays or cancellations caused by act of God, public enemy, acts of
    terrorism, authority of law, quarantine, riots, strikes, breakdowns, bad conditions of the road, traffic jams,
    and other conditions beyond its control; and does not guarantee to arrive at or depart from any point at a
    specified time. The carrier will endeavor to maintain the schedule submitted by its agent or employee; and over
    routes Indicated, but the same is not guaranteed. If any act of God, public enemy, authority of law, quarantine,
    peril of navigation, riots, strikes, the hazards or dangers of incident to the state of war, accidents,
    breakdowns, bad conditions of the road, traffic jams, and other conditions beyond its control make it, in the
    opinion of the carrier, inadvisable to operate its equipment either from the point of origin or any point en
    route, the carrier will not be held liable for damages for any reason( s) whatsoever.
</p>

<strong>Intellectual Property</strong>

<p>
    Content on the Web site is our property or our Affiliates’ property and is protected by the law of copyright,
    trademarks, service marks, patents and other property rights. You may display, re-format and print any content
    you receive through our service for your personal use only. You will not re-post, transmit, reproduce, sell,
    publish, distribute, broadcast, perform, create derivative works from, or in any way commercially exploit any of
    the content, or infringe on trademarks or service marks displayed or received through our service, without our
    express prior consent in writing.

    You also agree not to deep-link to the site for any purpose, unless we specifically authorized you to do so.
</p>

<strong>Trademarks</strong>

<p>
    Shuttle Company of America, GORRShuttle.com, Roadrunner Shuttle, Get Home Faster are trademarks of Shuttle
    Company of America, LLC. Other marks and content on the Web sites are the property of their respective owners.
</p>


<strong>Access and Interference</strong>

<p>
    You agree that you will not use any robot, spider, other automatic device, or manual process to monitor or copy
    our web pages or the content contained thereon or for any other unauthorized purpose without our prior expressed
    written permission. You agree that you will not use any device, software or routine to interfere or attempt to
    interfere with the proper working of our Web site. You agree that you will not take any action that imposes an
    unreasonable or disproportionately large load on our infrastructure. You agree that you will not copy,
    reproduce, alter, modify, create derivative works, or publicly display any content (except for your own
    personal, non-commercial use) from our Web site without our prior expressed written permission.
</p>

<strong>Privacy Policy</strong>

<p>
    We have established a Privacy Policy governing your expectation of privacy in information you provide to us. Any
    expectation of privacy by you is subject to that Privacy Policy.
</p>

<strong>Information about Yourself</strong>

<p>
    You represent that you are 18 years or older and will be responsible for any charges and consequences incurred
    in connection with your use of services. If you are less than 18 years old, please have a parent or guardian use
    the services on your behalf.
</p>

<p>
    You agree to provide true and correct information about yourself, including your e-mail address, in any
    registration form, and once registered you agree to update your registration information within ten (10) days of
    any change in that information. Any requirement, under either this Terms of Use Agreement or applicable law,
    that we provide you with a notice is conditioned upon your complying with this provision.
</p>

<p>
    You agree to take reasonable measures to protect your user name and password from being accessed and used by
    others without your authority.
</p>

<strong>Prohibited Activities</strong>

<p>
    You acknowledge that you bear an obligation not to use the services for infringing, illegal or improper purposes
    or in an infringing, illegal or improper manner. This includes, without limitation: (a) transmitting
    threatening, abusive, profane, libelous, slanderous, obscene, pornographic or harassing materials; (b) engaging
    in harassment, sexual in nature or otherwise, whether through language, frequency or size of messages; (c)
    engaging in any other purpose or activity that violates any applicable law or regulation, either foreign or
    domestic, or facilitates the violation of any applicable law or regulation; and (d) engaging in any other
    purpose or activity that we believe could subject us to criminal liability or civil penalty or judgment.
</p>

<p>
    You agree not to engage in actions that could adversely affect operation of any Web site, or our ability to
    provide the services to other visitors. These actions include: (a) attempting to circumvent user authentication
    or our security (“cracking”); (b) attempting to cancel, supersede, or otherwise interfere with services being
    provided to other visitors; and (c) attempting to access, copy, change or erase information or data on our
    servers.
</p>

<strong>External Links</strong>

<p>
    Our service includes links to other material and sites on the Internet, including materials provided by
    Advertisers or Affiliates. We are not responsible for the availability of these resources, or for their
    contents. We do not endorse and are not responsible for any of the material, advertising, products or content on
    such sites. We will not be held responsible or liable, directly or indirectly, for any loss or damage caused or
    alleged to have been caused by use or reliance on any such content, services or products on or offered on such
    sites. If you have a concern about any external link on our site, please notify us.
</p>

<strong>Disclaimer of Warranties and Liability</strong>

<p>
    The service (including all content, software, functions, materials and information accessed by any means
    thereof) is provided as is. To the fullest extent permissible by law, we make no warranties and shall not be
    liable for the use of the services, including, without limitation, any interruption of or error in the services
    under any circumstances, including, but not limited to, our negligence. We expressly disclaim any and all
    warranties of any kind, whether express or implied, including, but not limited to: (a) any warranties as to the
    availability, accuracy, completeness, currentness or reliability of the content available through the service,
    or the services itself; (b) any warranties that the services will be uninterrupted, timely, secure or error
    free, or that software defects will be corrected; (c) any warranty that the services will be available on a
    specified date or time or that we will have the capacity to meet the demand of customers during specific hours;
    and (d) warranties of merchantability, fitness for a particular purpose or non-infringement.
</p>

<p>
    You agree and acknowledge that any content, material, executable files and/or data downloaded or otherwise
    obtained through the use of our service is done at your own discretion and risk and that you will be solely
    responsible for any damages to your computer system or network or any loss of data or system availability that
    results from the downloading of any such content, material, executable files and/or data.
</p>
No information or advice, whether written or oral, obtained by you from or through our service shall create any
warranty not expressly made herein.
<p>
    We shall not be liable to you or anyone else for any injury, damages or loss resulting from use of this service,
    caused in whole or in part by our negligence or events beyond our control in procuring, reporting, delivering,
    compiling or interpreting our service and any content accessible through the service. In no event shall we be
    liable to you or anyone else for any decision made or action taken by you in reliance on such content.
</p>

<p>
    We shall not be liable to you or anyone else for any direct, consequential, special, incidental, indirect or
    other form of damages, even if we have been advised of the possibility of such damages, related to the use or
    the inability to use the service. You agree that our liability, if any, arising out of any kind of legal claim,
    whether arising in tort, contract or otherwise, in any way connected with this service or the content in this
    service shall not exceed the amount of $100.
</p>
You further agree that we, our employees and agents will not be liable for any lost property or data of yours or
any claim or demand against you by any other party.

<p>Some jurisdictions do not allow the exclusion of certain warranties, so some of the above exclusions may not
    apply to you.
</p>


<strong>Termination</strong>

<p>
    We reserve the right to suspend or to cease providing the service to you at any time for any reason. We may
    report to law enforcement authorities any suspected fraudulent, abusive or illegal activity. We will not be
    liable to you or anyone for termination of the service or any claims relating to the termination of the service.
</p>

<p>
    If you object to this Terms of Use Agreement or any change to it or become dissatisfied with the service in any
    way, your sole remedy and recourse is to immediately stop using the service. Your continued use of the service
    is your acceptance of this Terms of Use Agreement and any and all subsequent changes to it.
</p>

<strong>Laws</strong>

<p>
    This User Agreement constitutes the sole and entire agreement between us and you with respect to the services
    and supersedes any other prior agreement. This agreement is entered into in the State of Delaware, USA and will
    be governed by its laws and the intellectual property laws of the United States of America, without regard to
    conflict of laws provisions.
</p>

<p>With respect to any claim, issue, action or dispute, to which Shuttle Company of America, LLC or an affiliate is
    a party, regarding or related to a Web site or the services, the Federal and state courts of the State of
    Delaware shall have exclusive jurisdiction and venue over all such actions.
</p>

<p>You consent to personal jurisdiction in the Federal and state courts of the State of Delaware for any action
    arising out of or relating to your use of the services. Any action brought by you or us arising out of this
    agreement, its performance or non-performance shall be brought, if at all, within one (1) year of a cause of
    action arising. In the event that any portion of this Terms of Use Agreement is held unenforceable, the
    unenforceable portion shall be construed in accordance with applicable law as nearly as possible to reflect the
    original intentions of the parties, and the remainder of the provisions shall remain in full force and effect.
</p>

<strong>Non-Waiver</strong>

<p>
    Our failing to act at any time or times on any one or more violations of this Terms of Use Agreement will not
    preclude us from acting on them or exercising our right to remove content and terminate your account at any time
    thereafter.
</p>

<strong>
    Indemnification
</strong>

<p>You agree to indemnify, defend and hold us harmless from and against any and all liability and costs incurred by
    us in connection with any claim arising out of your use of the services or any breach by you of this Terms of
    Use Agreement, or incurred by us in responding to a third-party claim that you have used the services in an
    infringing, illegal or improper manner, including, without limitation, reasonable attorneys’ fees and costs. You
    agree to cooperate as fully as reasonably required in the defense of any claim. We reserve the right, at our own
    expense, to assume the exclusive defense and control of any matter otherwise subject to indemnification by you
    and you shall not in any event settle any matter without our written consent.
</p>

<p>
    Definitions: “We,” “Us,” “You,” “Our Service” and “This Service”
    In this agreement, “we” and “us” means Shuttle Company of America, LLC its subsidiaries entities, managers,
    officers, employees, independent contractors, agents, service providers and affiliates.

    “Service” “Our service” and “this service” mean the Web site and any service, whether free or for a fee or
    subscription, provided through the Web site by us or our subsidiary city site entities.
</p>

</div>
<div class="modal-footer">
    <button data-dismiss="modal" class="btn btn-success">Close</button>
</div>
</div>

<%--
PRIVACY--%>

<%--<-- Modal -->--%>
<div aria-hidden="true" aria-labelledby="myModalLabelPrivacy" role="dialog" tabindex="-1" class="modal hide fade"
     id="myModalPrivacy"
     style="display: none;">
<div class="modal-header">
    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">x</button>
    <h5 id="myModalLabelPrivacy" class="center red">Privacy</h5>
</div>
<div class="modal-body">

    <strong>Privacy Policy</strong>
    <br/>

    Please Note: as of 03/01/13, we have made changes to our Privacy Policy

    <br/>
    <strong>Overview</strong>

    <p>
        Shuttle Company of America, LLC (SCOA), a licensee and operator of Roadrunner Shuttle (GORRShuttle) is a
        licensee of the TRUSTe Privacy Program. TRUSTe is an independent organization whose mission is users trust
        and confidence in the internet by promoting the use of fair information practices. This privacy statement
        covers the site www.gorrshuttle.com . Because SCOA wants to demonstrate its commitment to our users'
        privacy, it has agreed to disclose its information practices and have its privacy practices reviewed for
        compliance by TRUSTe.

        Users with questions or concerns regarding their privacy or this statement should contact Roadrunner Shuttle
        Customer Service at:
    </p>

    <address>
        Shuttle Company of America, LLC
        Dba Roadrunner Shuttle
        2275 Corporate Circle
        Henderson, NV 89074
    </address>

    Telephone: (702) 659-8829
    Email: support@gorrshuttle.com

    If they do not receive acknowledgment of their inquiry or their inquiry is not satisfactorily addressed, they
    should then contact TRUSTe through the TRUSTe Watchdog Dispute Resolution Process. TRUSTe will serve as a
    liaison with the website to resolve users concerns.

    <strong>What Data Do We Collect?</strong>

    <p>SCOA respects your privacy and has created this Privacy Statement in order to demonstrate our commitment to
        your privacy. We have established this Statement to communicate our information gathering and dissemination
        practices to our customers and visitors. This Statement describes how we use, disclose and protect personal
        information that you share with us. “Personal Information” is information that can be used to identify you
        such as your name and email.

        We request your personal information on our Site such as your name, email, phone number and physical address
        to complete the reservation process on our Site for your shuttle. We also collect financial information from
        you at the point of reservation such as your credit card number and billing zip code to process payment for
        your reservation.

        This Site may also collect certain information from visitors and users of our Site such as Internet
        Addresses. This Website navigational information is logged to help diagnose technical problems, to analyze
        trends, to track users’ movements around the Site and to administer our Site in order to constantly improve
        the quality of the Site and our Service. We may also track and analyze individual usage and volume
        statistical information in aggregate form from the visitors to our Site. None of this aggregated data
        contains personal information.
    </p>
    <strong>How We Use Your Data</strong>

    <p>
        We will not use your personal information to send you information about available products or services,
        unless you affirmatively tell us we can by opting to receive them during the registration process on our
        Site.

        We use your personal information to complete your reservation requests on our Site, contact you for customer
        service fulfillment when you use our “Contact Us” forms and to send you service related notifications.
        Generally, these messages are not promotional in nature; consequently, you cannot opt out of receiving them.

        We may also use your personal information to tell you about new products or services we feel may be of
        interest to you and otherwise customize our Web site and services to better serve your needs.

        We may also collect and track information on an aggregate (i.e., group) basis, so that we may track customer
        interests, tailor our marketing efforts, and improve the services offered through the Site. We may share
        this aggregate information with third parties. This aggregate information does not contain any personal
        information.
    </p>
    <strong>Service Providers</strong>

    <p>We do not provide or release your personally identifiable information to third parties, except to companies
        you have selected to provide transportation services to you, as appropriate to operate our business in
        providing you the requested service. We use a third party agent to process credit card payments submitted on
        our Site. We also use a third party agent to support our newsletters and promotional emails to you.

        We do not share your personal information with third parties for their promotional purposes.
    </p>
    <strong>Exceptions:</strong>

    <p>We may be obligated to disclose your personal information under the following circumstances:

        In cooperation with a civil request or investigation by any governmental body or agency.
        In complying with a court order, judicial proceeding, or in response to a subpoena.
        To protect or defend ourselves, our copyrights or the safety of our users or in any legal action.
    </p>
    <strong>Business Transition</strong>
    In the event of a sale, merger or acquisition of some, or all of SCOA’s assets, your personal information would
    likely be part of the transferred assets. In the event of such an occurrence, we shall notify you by means of a
    notice on our Site and by email.

    <strong>Cookies</strong>

    <p>When you visit our Site, our web server sends a cookie to your computer. Cookies are files that Web browsers
        place on a computers hard drive and are used to indicate whether you have visited the Site Previously.

        We use cookies on our Site for the following purposes:

        To keep track of pending transactions
        To deliver content that is specific to your interests
        To save your password so you don’t have to re-enter it each time you visit our Site.
        Your browser may decline the Cookie if it is set to do so. Declining Cookies will limit the functionality of
        our site.
    </p>
    <strong>Third Party Cookies</strong>

    <p>We may from time to time engage third parties to track and analyze non-personally identifiable usage and
        volume statistical information from visitors and users’ to our Site to help us administer our Site and
        improve its quality. Such third parties use cookies to help track visitor behavior. These cookies are not
        tied to your personal information.

        Advertisers and affiliates may also set cookies on our Site. We do not have access to nor are we responsible
        for any of the cookies set by third parties on our Site.
    </p>
    <strong>Email a Friend</strong>

    <p>If you choose to use our referral service to email a friend about our site, we will ask you for your friend's
        name and email address. We will automatically send your friend a one-time email inviting him or her to visit
        the site and register an account. SCOA stores this information for the sole purpose of sending this one-time
        email and tracking the success of our referral program.
    </p>
    <strong>Blog Disclosure</strong>

    <p>If you use a blog on this Site, you should be aware that any personally identifiable information you submit
        there can be read, collected, or used by other users of these forums, and could be used to send you
        unsolicited messages. We are not responsible for the personally identifiable information that you choose to
        submit in these forums.
    </p>
    <strong>Linked Sites</strong>

    <p>This Site may contain links to other sites. We are not responsible for the content of such Web sites or for
        the way that these sites may treat any personal information that you may choose to provide to them.
    </p>
    <strong>Site Security</strong>

    <p>SCOA has security measures in place to protect against the loss, misuse and alteration of the information
        under our control. We have put in place reasonable physical, electronic and managerial procedures that are
        designed to safeguard and secure the information we collect online. We employ the use of generally accepted
        industry standards in securing your sensitive information on our Site. We use SSL [Secure Socket Layer]
        technology to encrypt your financial information during credit card transactions.
    </p>
    <strong>Minors</strong>

    <p>SCOA will not knowingly collect personally identifiable information from children under the age of thirteen.
    </p>
    <strong>Choice/Opt-Out</strong>

    <p>You may send a request to remove your information from our database or not receive future communications from
        us pertaining to new products or services by emailing us at contact@rrshuttle.com or following the
        unsubscribe instructions in each email communication received from us.
    </p>
    <strong>Questions</strong>

    <p>
        If you have any questions about this privacy statement, the practices of this Web site, or other matters
        regarding your experiences with the Web site, please contact our customer support department by mail or
        telephone at the above address or by e-mail at support@gorrshuttle.com. We will acknowledge any consumer
        privacy complaint and report to you with a clear account of our findings within thirty days from receipt of
        the complaint.
    </p>
    <strong>Access</strong>

    <p>
        You can access, update or change any of the personal information you have submitted on our Site by signing
        into your account on our Site. In the event that you no longer require our services and elect to delete your
        account, you can do so by contacting us via email at contact@gorrshuttle.com.
    </p>
    <strong>Changes to this Statement</strong>

    <p>SCOA may update this Statement at any time, so please review it frequently. If we make material changes to
        this Statement, we will notify you in this Statement, by email or by a notice posted on the home page of the
        Site.
    </p>
    <strong>Other Provisions</strong>

    <p>In this Privacy Statement, “we” and “us” means SCOA, LLC its officers, directors, employees, independent
        contractors, agents, service providers and affiliates. It also includes any entity with which we merge or
        combine, whether by a sale of assets, a sale of ownership interests, or other mechanism or any successor in
        interest including an estate in bankruptcy, so long as that entity agrees to abide with the provisions of
        this privacy statement.

        SCOA reserves the right to change or update this policy, or any other SCOA policy or practice, at any time
        with reasonable notice to its registered users. Any changes or updates will be effective immediately upon
        posting to the Web site.
    </p>


</div>
<div class="modal-footer">
    <button data-dismiss="modal" class="btn btn-success">Close</button>
</div>
</div>

</div>