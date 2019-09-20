$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
    var guestList = "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";
    guestList = "<table style='border: 1px; border-color: blue;border-style: solid;' ><th>FirstName</th><th>Last Name</th>";
    for (var i=0; i<data.length;i++) {
        guestList += "<tr>";
        guestList += "<td>" + data[i].first + "</td>";
        guestList += "<td>" + data[i].last + "</td>";
        guestList += "</tr>";
    }
    guestList += "</table>";
    $("#guestList").html(guestList);
    
}