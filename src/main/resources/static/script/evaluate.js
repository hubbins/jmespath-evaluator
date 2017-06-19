
evaluateExpression = function() {
    $("#errorMsg").text("");
    $("#result").text("");

    var exprText = $.trim($("#expression").val());
    var json = $.trim($("#json").val());

    if (exprText === "" || json === "") {
        $("#errorMsg").text("Provide expression and JSON values.");
        return;
    }

}



