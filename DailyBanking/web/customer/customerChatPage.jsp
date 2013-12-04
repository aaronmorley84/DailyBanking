<%-- 
    Document   : chatPage
    Created on : Dec 3, 2013, 12:48:44 PM
    Author     : krismaini
--%>

<%@include file="../WEB-INF/jspf/header.jspf"%>

<script>
    var ws = new WebSocket("ws://localhost:8080/DailyBanking/echo");
                ws.onopen = function(evt)    { 
                    $("#msgall").append("Connection open ..."); 
                }; 
                ws.onmessage = function(evt) {
                    $("#msgall").append(evt.data+'\n');
                }; 
                ws.onclose = function(evt)   { 
                    $("#msgall").append("Connection closed."); 
                };
            $(document).ready(function(){
                $("#btn").click(function(){
                    ws.send($("#msgsend").val());
                    $("#msgsend").val("");
                });
            });
</script>

<div id="chatpanel">
    <h2>Web socket test</h2><br>
    <textarea id='msgall' rows='10' cols="50"></textarea><br/>
    <input type="text" id='msgsend'><button id='btn'>Send</button>
</div>

<%@include file="../WEB-INF/jspf/footer.jspf" %>
