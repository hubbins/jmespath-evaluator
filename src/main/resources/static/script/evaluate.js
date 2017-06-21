// simple javascript that may be painful to look at

evaluateExpression = function() {
    // clear previous values
    $("#errorMsg").text("");
    $("#result").text("");

    // get edit box text and make sure there is some data
    var exprText = $.trim($("#expression").val());
    var jsonText = $.trim($("#json").val());

    if (exprText === "" || jsonText === "") {
        $("#errorMsg").text("Provide expression and JSON values.");
        return;
    }

    localStorage.setItem("json_value", jsonText);

    // save the scratchpad
    localStorage.setItem("scratchpad_value", $("#scratchpad").val());

    // post the request and display the result
    $.ajax({
        url: "evaluator",
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify({ expression: exprText, json: jsonText })
    }).done(function(response) {
        if (response.result.length > 0)
            $("#result").text(response.result);
        if (response.errorMessage.length > 0)
            $("#errorMsg").text(response.errorMessage);
    }).fail(function( jqXHR, textStatus ) {
        $("#errorMsg").text("Error: " + textStatus);
    });
}

loadValues = function() {
    var json = localStorage.getItem("json_value");
    if (json != null) {
        $("#json").text(json);
    }

    var scratchpadValue = localStorage.getItem("scratchpad_value");
    if (scratchpadValue != null) {
        $("#scratchpad").text(scratchpadValue);
    }
}

checkEnter = function(e) {
    if (e.keyCode == 13) {
        evaluateExpression();
        return false;
    }
}

$(document).ready(function () {
    loadValues();
});
