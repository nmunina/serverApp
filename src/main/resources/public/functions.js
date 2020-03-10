
document.getElementById("btn_input").addEventListener("click", function () {
    const http = new XMLHttpRequest();

    http.onreadystatechange = function() {
        if (http.readyState === XMLHttpRequest.DONE) {
            document.getElementById("result").innerHTML = "Recommended length is: " + http.responseText;
        }
    };

    http.abort();

    const myLength = document.getElementById("length").value;

    const myAge = document.getElementById("age");
    const strAge = myAge.options[myAge.selectedIndex].value;

    const myStyle = document.getElementById("style");
    const strStyle =myStyle.options[myStyle.selectedIndex].value;

    const boolCompetition = document.getElementById("competition").checked;

    if (!myLength) {
        alert('Fill in the body length!');
    } else if (strAge.includes("null") || strStyle.includes("null") ) {
        alert('Fill in both age and style!');
    } else {
    http.open("GET", "/calculate?length=" + myLength + "&age=" + strAge + "&style=" + strStyle + "&competition=" + boolCompetition);
    http.setRequestHeader("length", myLength);
    http.setRequestHeader("age", strAge);
    http.setRequestHeader("style", strStyle);
    http.setRequestHeader("competition", boolCompetition);
    http.send( null );
    }
});