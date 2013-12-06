<%@include file="../WEB-INF/jspf/header.jspf" %>
<script type="text/javascript">
            $(document).ready(function(){
                $("#addCustForm").validate({
                    rules: {
                        firstName: {minlength: 2},
                        lastName: {minlength: 2},
                        password: {minlength: 6},
                        email:{required: true, email: true, remote: "CheckEmailCommand"}
                    }
                        });
                
                $.extend($.validator.messages, {remote: "This email is in use already"});   
            
            
                $("#fillInAddress").click(function() {
                 $.ajax({
                url: "AutofillAddressCommand",
                data: "phone=" + $("#phone").val(),
                cache: false,
                dataType: "json",
                success: dataReady
                });

                        });
                        
       
        
               $("#getRating").click(function() {
            $.ajax({
                url: "CreditRating",
                cache: false,
                dataType: "text",
                success: dateReady
                });
                    });
            
        });
        
        function dateReady(data) {
        $("#cr").html(data);       
            
        };
        
         function dataReady(data) {
            alert(data.address);
            $("#firstName").val(data.firstName);
            $("#lastName").val(data.lastName);
            $("#ad").val(data.address);
            $("#city").val(data.city);
            $("#zip").val(data.zip);
            $("#email").val(data.email);
        }
        ;
               
</script>


<div id="main">
    <p id="username">${custemail} is currently logged in</p>

    <div id="addcustpanel">
        <form action="Controller" id="addCustForm">
            <button type="button" id="fillInAddress">Fill Form from Phone Number</button><br>
            <label>First Name:</label><br>
            <input type="text" name="firstName" id="firstName" class="required"><br>
            <label>Last Name:</label><br>
            <input type="text" name="lastName" id="lastName" class="required"><br>
            <label>Phone:</label><br>
            <input type="text" name="phone" id="phone" class="required"><br>
            <label>City:</label><br>
            <input type="text" name="city" id="city" class="required"><br>
            <label>Address:</label><br>
            <input type="text" name="ad" id="ad" class="required"><br>
            <label>Zip:</label><br>
            <input type="text" name="zip" id="zip" class="required"><br>
            <label>Email:</label><br>
            <input type="email" name="email" id="email" class="required email"><%--<button id="btn">Check email</button>--%>
            <label id="feedback"></label><br>
            <label>Password:</label><br>
            <input type="password" name="password" id="password" class="required"><br>
            <button name="submit">Submit</button>

            <input type="hidden" name="command" value="addCustomer">
        </form>
    </div>
        
        <div id="cr"></div>        
        <button id="getRating">CreditRating for test@gmail.com</button>
        
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
