<%-- 
    Document   : customerIndex
    Created on : 08-Nov-2013, 10:28:39
    Author     : Aaron, Kris, Lars, Timea
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<script>
$(document).ready(function() {
   // $("#getCubtn").click(function(){
        $.ajax({
            url: "CurrencyInfoServlet",
            cache: false,
            dataType: "text",
            success: getCurrencyInfo
        });
   // });
    });
    function getCurrencyInfo(data) {
        $("#currencyinfo").html(data);
    }

</script>

<div id="main">
    <p id="username">${customer.firstName} ${customer.lastName} is currently logged in</p>
    <a href="Controller?custemail=${customer.email}&username=${username}&command=customerViewDetails">Your Bank Profile</a>
        
    <div id='basicPanel'>
        <h3>News Section</h3>
    </div><br>
    <div id='basicPanel'>
        <div id='infoPanel'>
            <h3>Information</h3>
            <div id="currencyinfo"></div>
            <%--<button id="getCubtn">Get current currency rates</button>--%>
        </div>
    </div>
</div>
    

<%@include file="../WEB-INF/jspf/footer.jspf" %>
