
evaluateExpression = function() {
    $("#errorMsg").text("")

    var exprText = $.trim($("#expression").val());
    var json = $.trim($("#json").val());

    if (exprText === "" || json === "") {
        $("#errorMsg").text("Provide expression and json values.");
        return;
    }

}



